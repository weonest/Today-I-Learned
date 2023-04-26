import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int Max = 25 + 2;

    static boolean[][] graph;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int countDanJi;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        graph = new boolean[Max][Max];


        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 1; j <= N; j++) {
                graph[i][j] = s.charAt(j - 1) == '1';
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= N; y++) {
                if (graph[y][x]) {
                    countDanJi = 0;
                    dfs(x, y);
                    list.add(countDanJi);
                }
            }
        }
        System.out.println(list.size());
        list.sort(Comparator.naturalOrder());
        for (int i : list) {
            System.out.println(i);
        }
    }

    public static void dfs(int x, int y) {
        graph[y][x] = false;
        countDanJi++;

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (graph[newY][newX]) {
                dfs(newX, newY);
            }
        }
    }

}
