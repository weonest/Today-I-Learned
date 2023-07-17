package BaekJun.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek1261 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int N, M;

    static int answer;
    static int[][] map;
    static boolean[][] visited;

    static class Node {
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j) == '1' ? 1 : 0;
            }
        }

        answer = bfs(0, 0);

        System.out.println(answer);
    }

    static int bfs(int x, int y) {
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.cnt - o2.cnt);
        q.add(new Node(x, y, 0));
        visited[y][x] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            x = cur.x;
            y = cur.y;

            if (x == N - 1 && y == M - 1) {
                return cur.cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny >= M || nx >= N || ny < 0) {
                    continue;
                }

                if (!visited[ny][nx]) {
                    if (map[ny][nx] == 1) {
                        q.offer(new Node(nx, ny, cur.cnt + 1));
                        visited[ny][nx] = true;
                    }
                    else if (map[ny][nx] == 0) {
                        q.offer(new Node(nx, ny, cur.cnt));
                        visited[ny][nx] = true;
                    }
                }
            }
        }
        return 0;
    }
}
