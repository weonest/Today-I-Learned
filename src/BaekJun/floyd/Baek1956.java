package BaekJun.floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek1956 {

    static int dp[][];

    static int N, M;

    static final int MAX = 10000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][N + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, MAX);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            dp[u][v] = c;
        }

        // i:중간, j:시작, k:끝
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                for (int k = 1; k <= N; k++) {
                    if (j == k) continue;

                    dp[j][k] = Math.min(dp[j][k], dp[j][i] + dp[i][k]);
                }
            }
        }

        int answer = MAX;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                if (dp[i][j] != MAX && dp[j][i] != MAX)
                answer = Math.min(answer, dp[i][j] + dp[j][i]);
            }
        }
        answer = answer == MAX ? -1 : answer;

        System.out.println(answer);

    }
}
