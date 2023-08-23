package BaekJun.topological_sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2056 {

    static int N;

    static List<Integer>[] graph;

    static int[] indegree;

    static int[] time;

    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        indegree = new int[N + 1];
        time = new int[N + 1];
        result = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            for (int j = 0; j < n; j++) {
                int prior = Integer.parseInt(st.nextToken());
                graph[prior].add(i);
                indegree[i]++;
            }
        }

        System.out.println(topologicalSort());
    }

    static int topologicalSort() {
        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            result[i] = time[i];
            if (indegree[i] == 0) { // 선행이 필요 없으니 수행될 수 있는 친구들
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph[cur]) {
                indegree[next]--;
                result[next] = Math.max(result[next], result[cur] + time[next]);
                if (indegree[next] == 0) {
                    q.add(next);
                }
            }
        }
        return Arrays.stream(result).max().getAsInt();
    }
}
