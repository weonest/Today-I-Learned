package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baek9095 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dp = new int[12];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < 12; i++) {
            dp[i] = dp[i - 1] * 2;

        }

        System.out.println(dp[3]);

    }
}
