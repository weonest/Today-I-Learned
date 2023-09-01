package BaekJun.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1504 {

    static int N;
    static int E;
    static int v1;
    static int v2;
    static int MAX = 200_000_000;
    static class Node {
        int dest;
        int cost;

        public Node(int index, int cost) {
            this.dest = index;
            this.cost = cost;
        }
    }

    static int[] dist;
    static ArrayList<Node>[] graph;
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());


        dist = new int[N + 1];

        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, c));
            graph[v].add(new Node(u, c));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        int route1, route2;

        route1 = dijkstra(1, v1);
        route1 += dijkstra(v1, v2);
        route1 += dijkstra(v2, N);

        route2 = dijkstra(1, v2);
        route2 += dijkstra(v2, v1);
        route2 += dijkstra(v1, N);

        if (route1 >= MAX && route2 >= MAX) System.out.println("-1");
        else System.out.println(Math.min(route1, route2));

    }
    private static int dijkstra(int start, int end) {
        Arrays.fill(dist, MAX);
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            int cur = pq.peek().dest;
            int dis = pq.poll().cost;

            if (dis > dist[cur]) {
                continue;
            }
            if (cur == end) {
                break;
            }

            for (Node next : graph[cur]) {
                if (dist[next.dest] > dist[cur] + next.cost) {
                    dist[next.dest] = dist[cur] + next.cost;
                    pq.offer(new Node(next.dest, dist[next.dest]));
                }
            }
        }
        return dist[end];
    }
}
