package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek16987 {

    static Egg[] eggs;
    static boolean[] visited;
    static int answer;
    static int N;

    static class Egg {
        int dura;
        int weight;

        public Egg(int dura, int weight) {
            this.dura = dura;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        eggs = new Egg[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            eggs[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        dfs(0, 0);
        System.out.println(answer);
    }

    public static void dfs(int idx, int cnt) {

        if (idx == N) {
            answer = Math.max(answer, cnt);
            return;
        }
        // 손으로 든 계란이 이미 깨졌거나 모든 계란이 이미 다 깨져 있다면
        if (eggs[idx].dura <= 0 || cnt == N - 1) {
            dfs(idx + 1, cnt);
            return;
        }

        int nCnt = cnt;

        for (int i = 0; i < N; i++) {
            if (i == idx) continue;

            if (eggs[i].dura <= 0) continue;

            eggs[i].dura -= eggs[idx].weight;
            eggs[idx].dura -= eggs[i].weight;

            if (eggs[idx].dura <= 0) cnt++;

            if (eggs[i].dura <= 0) cnt++;

            dfs(idx + 1, cnt);

            eggs[i].dura += eggs[idx].weight;
            eggs[idx].dura += eggs[i].weight;

            cnt = nCnt;
        }
    }
}
