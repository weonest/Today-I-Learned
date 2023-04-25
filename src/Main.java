import java.io.*;
import java.util.*;

public class Main {

    static int Max = 55;
    static boolean[][] graph;
    static boolean[][] visited;
    static int countPerDan;
    static int count;

    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};

    static void dfs(int x, int y) {
        visited[x][y] = true;

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

        int T = Integer.parseInt(st.nextToken());

        for (int l = 0; l < T; l++) {
            count = 0;
            StringTokenizer stt = new StringTokenizer(br.readLine(), " ");
            int M = Integer.parseInt(stt.nextToken());
            int N = Integer.parseInt(stt.nextToken());
            graph = new boolean[M+5][N+5];
            visited = new boolean[M+5][N+5];

            int K = Integer.parseInt(stt.nextToken());
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int p1 = Integer.parseInt(st.nextToken());
                int p2 = Integer.parseInt(st.nextToken());
                graph[p1][p2] = true;
            }

            for (int j = 1; j <= M; j++) {
                for (int k = 1; k <= N; k++) {
                    if (graph[j][k] && !visited[j][k]) {
                        dfs(j, k);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }

    }


}

