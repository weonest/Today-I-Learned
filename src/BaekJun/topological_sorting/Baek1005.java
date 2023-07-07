package BaekJun.topological_sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek1005 {

    static int T;

    static int N;

    static int K;

    static int W;

    static ArrayList<Integer>[] build;

    static int[] cost;

    static int[] edgeCount;

    static int[] answer;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {

            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            edgeCount = new int[N + 1];
            cost = new int[N + 1];
            build = new ArrayList[N + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                build[i] = new ArrayList<>();
                int t = Integer.parseInt(st.nextToken());
                cost[i] = t;
            }

            for (int i = 1; i <= K; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                edgeCount[v] += 1;
                build[u].add(v);
            }

            answer = new int[N + 1];
            W = Integer.parseInt(br.readLine());

            topologySort();
            System.out.println(answer[W]);
        }
    }

    static void topologySort() {
        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i < edgeCount.length; i++) {
            if (edgeCount[i] == 0) {
                answer[i] = cost[i];
                que.offer(i);
            }
        }

        while (!que.isEmpty()) {
            int cur = que.poll();

            for (int i = 0; i < build[cur].size(); i++) {
                int nex = build[cur].get(i);
                answer[nex] = Math.max(answer[cur] + cost[nex], answer[nex]);
                edgeCount[nex]--;
                if (edgeCount[nex] == 0) {
                    que.offer(nex);
                }
            }
        }
    }
}
