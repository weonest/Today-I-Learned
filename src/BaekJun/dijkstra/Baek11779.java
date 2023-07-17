package BaekJun.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek11779 {

    static int N;
    static int M;
    static int start;
    static int end;
    static int[] route;

    static class Node {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }

    static boolean[] visited;
    static int[] dist;

    static ArrayList<Node>[] graph;
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        dist = new int[N + 1];
        route = new int[N + 1];
        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, cost));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra();

        System.out.println(dist[end]);
        List<Integer> list = new ArrayList<>();
        int cur = end;
        while (cur != 0) {
            list.add(cur);
            cur = route[cur];
        }
        System.out.println(list.size());
        Collections.reverse(list);
        for (int i : list) {
            System.out.print(i + " ");
        }
    }

    private static void dijkstra() {
        dist[start] = 0;
        route[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            int cur = pq.peek().index;
            int dis = pq.poll().cost;

            if (dis > dist[cur]) {
                continue;
            }
            if (cur == end) {
                break;
            }
//            visited[cur] = true;

            for (Node next : graph[cur]) {
                if (dist[next.index] > dist[cur] + next.cost) {
                    dist[next.index] = dist[cur] + next.cost;

                    pq.offer(new Node(next.index, dist[next.index]));
                    route[next.index] = cur;
                }
            }
        }
    }
}
