package pgsa;

import java.util.*;

class DivideWire {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int min;

    public int solution(int n, int[][] wires) {
        graph = new ArrayList[n + 1];
        min = 99;

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] wire : wires) {
            int u = wire[0];
            int v = wire[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        for (int[] wire : wires) {
            int u = wire[0];
            int v = wire[1];

            visited = new boolean[n + 1];

            graph[u].remove(Integer.valueOf(v));
            graph[v].remove(Integer.valueOf(u));

            int cnt = dfs(1);
            int diff = Math.abs(cnt - (n - cnt));
            min = Math.min(min, diff);

            graph[u].add(v);
            graph[v].add(u);
        }

        return min;

    }

    static int dfs(int n) {
        visited[n] = true;
        int cnt = 1;

        for (int next : graph[n]) {
            if (!visited[next]) {
                cnt += dfs(next);
            }
        }
        return cnt;
    }

}