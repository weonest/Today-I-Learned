import java.io.*;
import java.util.*;

public class Main {

    static int Max = 25 + 5;
    static boolean[][] graph;
    static boolean[][] visited;
    static int countPerDan;

    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};

    static void dfs(int x, int y) {
        visited[x][y] = true;
        countPerDan++;

        for (int i = 0; i < 4; i++) {
            int nX = x + dx[i];
            int nY = y + dy[i];

            if (!visited[nX][nY] && graph[nX][nY]) {
                dfs(nX, nY);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        graph = new boolean[Max][Max];
        visited = new boolean[Max][Max];

        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 1; j <= N; j++) {
                graph[i][j] = s.charAt(j - 1) == '1'; // true가 담기는 곳이 아파트가 있는 곳
            }
        }

        List<Integer> countList = new ArrayList<>(); // 각 단지가 몇개의 아파트로 구성
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (graph[i][j] && !visited[i][j]) {
                    countPerDan = 0;
                    dfs(i, j);
                    countList.add(countPerDan);
                }
            }
        }

        System.out.println(countList.size());
        countList.sort(Comparator.naturalOrder());

        for (int i : countList) {
            System.out.println(i);
        }
    }


}

