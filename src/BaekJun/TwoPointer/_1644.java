package BaekJun.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _1644 {

    static boolean[] prime;
    static List<Integer> nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        prime = new boolean[n + 1];
        prime[0] = prime[1] = true;
        nums = new ArrayList<>();

        for (int i = 2; i * i <= n; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = true;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!prime[i]) nums.add(i);
        }

        int left = 0;
        int right = 0;
        int answer = 0;
        int sum = nums.get(0);
        int size = nums.size();
        while (left < size && right < size) {
            if (sum < n) {
                right++;
                if (right >= size) break;
                sum += nums.get(right);
            }

            if (sum > n) {
                sum -= nums.get(left);
                left++;
            }

            if (sum == n) {
                answer++;
                sum -= nums.get(left);
                left++;
            }
        }
        System.out.println(answer);

    }

}
