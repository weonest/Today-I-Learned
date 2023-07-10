package BaekJun.topological_sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek1766 {

    static int N;

    static int M;

    static ArrayList<Integer>[] difficulty;

    static int[] edgeCount;

    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        difficulty = new ArrayList[N + 1];
        edgeCount = new int[N + 1];
        answer = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            difficulty[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            difficulty[u].add(v);
            edgeCount[v]++;
        }

        PriorityQueue<Integer> que = new PriorityQueue<>();

        for (int i = 1; i < edgeCount.length; i++) {
            if (edgeCount[i] == 0) {
                answer[i] = i;
                que.offer(i);
            }
        }

        while (!que.isEmpty()) {
            int cur = que.poll();
            System.out.println(cur);

            for (int i = 0; i < difficulty[cur].size(); i++) {
                int nex = difficulty[cur].get(i);
                edgeCount[nex]--;

                if (edgeCount[nex] == 0) {
                    que.offer(nex);
                }
            }
        }


    }
}
