package BaekJun.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek1647 {


    static int N;

    static int M;

//    static int[M][3] graph;

    static PriorityQueue<Node> graph;

    static int[] parent;

    static int answer = 0;

    static class Node implements Comparable<Node> {
        int start;
        int end;
        int val;

        public Node(int start, int end, int val) {
            this.start = start;
            this.end = end;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            return this.val - o.val;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new PriorityQueue<>();
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            graph.add(new Node(u, v, val));
        }

        kruskal();
    }

    private static void kruskal() {

        int last = 0;
        while (!graph.isEmpty()) {
            Node node = graph.poll();
            if (find(node.start) != find(node.end)) {
                answer += node.val;
                union(node.start, node.end);
                last = node.val;
            }
        }
        System.out.println(answer - last);
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        return find(parent[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) parent[y] = x;
        else parent[x] = y;
    }

}
