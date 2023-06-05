package BaekJun;

import java.io.*;
import java.util.*;


// 그림 문제
public class Baek2178 {
    static int Max = 500 + 2;

    static int[][] graph;
    static int[][] ans;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int N, M;

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
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[Max][Max];
        ans = new int[Max][Max];
        for (int a[] : ans) {
            Arrays.fill(a, 1);
        }


        for (int i = 1; i <= N; i++) {
            String[] s = br.readLine().split("");

            for (int j = 1; j <= M; j++) {
                graph[i][j] = Integer.parseInt(s[j - 1]);
            }
        }

        for (int x = 1; x <= M; x++) {
            for (int y = 1; y <= N; y++) {
                if (graph[y][x] == 1) {
                    bfs(x, y);
                }
            }
        }
    }


    public static void bfs(int x, int y) {
        Queue<Node> que = new LinkedList<>();
        Node node = new Node(x, y);
        que.add(node);

        while (!que.isEmpty()) {

            x = que.peek().x;
            y = que.peek().y;
            que.poll();

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (graph[newY][newX] > 0) {
                    que.add(new Node(newX, newY));
                    ans[newY][newX] = graph[y][x] + 1;
                }
            }
        }
        System.out.println(ans[M][N]);
    }
}
