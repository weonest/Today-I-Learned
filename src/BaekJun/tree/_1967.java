package BaekJun.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 다익스트라의 반대 (최대) 를 구함
// 트리는 근본이 dfs
public class _1967 {

    static int N;

    static int max;

    static int maxNode;

    static boolean[] visited;

    static class Node{
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }

    static List<Node>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        list = new List[N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[u].add(new Node(v, c));
            list[v].add(new Node(u, c));

        }

        visited = new boolean[N + 1];
        visited[1] = true;
        dfs(1, 0);

        visited = new boolean[N + 1];
        visited[maxNode] = true;
        dfs(maxNode, 0);
        System.out.println(max);

    }

    static void dfs(int node, int cost) {
        if (max < cost) {
            max = cost;
            maxNode = node;
        }

        for (Node cur : list[node]) {
            if (!visited[cur.end]) {
                visited[cur.end] = true;
                dfs(cur.end, cost + cur.cost);
            }
        }
    }
}
