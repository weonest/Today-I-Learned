package BaekJun.floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek14938 {

    static int dp[][];

    static int N, MAX, R;

    static int[] items;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        MAX = Integer.parseInt(st.nextToken()) + 1;
        R = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][N + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, MAX);
        }
        // 자기 자신을 0으로 초기화 해야지 아이템을 판별할 수 있으니까

        items = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            dp[u][v] = c;
            dp[v][u] = c;
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
