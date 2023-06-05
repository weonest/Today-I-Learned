package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// 배추?
public class Baek1012 {

    static int M, N, K;

    static boolean[][] graph;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int count;

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            graph = new boolean[M + 2][N + 2];

            K = Integer.parseInt(st.nextToken());
            for (int j = 1; j <= K; j++) {
                st = new StringTokenizer(br.readLine());
                int p1 = Integer.parseInt(st.nextToken()) + 1;
                int p2 = Integer.parseInt(st.nextToken()) + 1;
                graph[p1][p2] = true;
            }

            for (int x = 1; x <= N; x++) {
                for (int y = 1; y <= N; y++) {
                    if (graph[y][x]) {
//                        dfs(x, y);
                        bfs(x, y);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }


    }

    public static void dfs(int x, int y) {
        graph[y][x] = false;

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (graph[newY][newX]) {
                dfs(newX, newY);

            }
        }
    }

    public static void bfs(int x, int y) {
        graph[y][x] = false;
        Queue<Node> que = new LinkedList<>();
        Node node = new Node(x, y);
        que.add(node);

        while (!que.isEmpty()) {
            x = que.peek().x;
            y = que.peek().y;
            graph[y][x] = false;

            que.poll();

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (graph[newY][newX]) {
                    que.add(new Node(newX, newY));
                }
            }
        }
    }

}
