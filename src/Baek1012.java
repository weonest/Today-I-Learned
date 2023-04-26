import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek1012 {

    static int M, N, K;
    static int[][] cabbage;
    static boolean[][] visited;
    static int count;
    static int[] dx = { 0, -1, 0, 1 };
    static int[] dy = { 1, 0, -1, 0 };

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int x, int y) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(x, y));

        while (!que.isEmpty()) {

            x = que.peek().x;
            y = que.peek().y;
            visited[x][y] = true;
            que.poll();

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (!visited[newX][newY] && cabbage[newX][newY] == 1) {
                    que.add(new Node(newX, newY));
                    visited[newX][newY] = true;
                }
            }
        }


        
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

                if (!visited[newX][newY] && cabbage[newX][newY] == 1) {
                    dfs(newX, newY);
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
            visited = new boolean[M+5][N+5];

            K = Integer.parseInt(st.nextToken());
            for (int j = 1; j <= K; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int p1 = Integer.parseInt(st.nextToken())+1;
                int p2 = Integer.parseInt(st.nextToken())+1;
                cabbage[p1][p2] = 1;
            }

            for (int x = 1; x <= M; x++) {
                for (int y = 1; y <= N; y++) {
                    if (cabbage[x][y] == 1 && !visited[x][y]) {
//                        dfs(x, y);
                        bfs(x, y);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }

    }

}