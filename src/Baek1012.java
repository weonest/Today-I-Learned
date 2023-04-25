import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1012 {

    static int M, N, K;
    static int[][] cabbage;
    static boolean[][] visit;
    static int count;
    static int[] dx = { 0, -1, 0, 1 };
    static int[] dy = { 1, 0, -1, 0 };

    static void dfs(int x, int y) {
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

                if (!visit[cx][cy] && cabbage[cx][cy] == 1) {
                    dfs(cx, cy);
                }

        }

    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            cabbage = new int[M+5][N+5];
            visit = new boolean[M+5][N+5];

            K = Integer.parseInt(st.nextToken());
            for (int j = 1; j <= K; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int p1 = Integer.parseInt(st.nextToken())+1;
                int p2 = Integer.parseInt(st.nextToken())+1;
                cabbage[p1][p2] = 1;
            }

            for (int x = 1; x <= M; x++) {
                for (int y = 1; y <= N; y++) {
                    if (cabbage[x][y] == 1 && !visit[x][y]) {
                        dfs(x, y);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }

    }

}