package BaekJun;

import java.io.*;
import java.util.*;

// 아파트 단지
public class Baek2667 {
    static int Max = 25 + 2;

    static boolean[][] graph;
    static boolean[][] visited;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int countDanJi;

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

        int N = Integer.parseInt(st.nextToken());
        graph = new boolean[Max][Max];
        visited = new boolean[Max][Max];


        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            if (s.length() == 1) continue;

            for (int j = 1; j <= N; j++) {
                graph[i][j] = s.charAt(j - 1) == '1';
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= N; y++) {
                if (graph[y][x]) {
//                    countDanJi = 0; // dfs는 0시작
                    countDanJi = 1;
                    
                    bfs(x, y);
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

    public static void bfs(int x, int y) {

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
                    countDanJi++;
                    graph[newY][newX]=false;
                 }
            }
        }
    }
}
