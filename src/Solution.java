import java.util.Arrays;

class Solution {
    int answer = 0;

    public int solution(int n, int k) {
        String str = "";

        while (n > 0) {
            str = String.valueOf(n % k) + str;
            n /= k;
        }
        String[] nums = str.split("0");

        for (String s : nums) {
            if (s.equals("")) continue;
            if (checkPrime(Long.valueOf(s))) answer++;
        }

        return answer;
    }

    public boolean checkPrime(long s) {
        if (s == 1) return false;

        for (int i = 2; i <= (int) Math.sqrt(s); i++) {
            if (s % i == 0) return false;
        }
        return true;
    }
}