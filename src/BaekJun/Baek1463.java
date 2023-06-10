package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baek1463 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());

        // 1. 3으로 나눌 수 있으면 3으로 나누기
        // 2. 2로 나눌 수 있으면 2로 나누기
        // 3. 1을 빼기

        int[] dp = new int[1000001];

        for (int i = 2; i <= X; i++) {
            dp[i] = dp[i - 1] + 1;

            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);

        }
        System.out.println(dp[X]);
    }
}
