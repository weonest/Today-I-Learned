import java.util.ArrayList;
import java.util.List;

class Solution {
    static int answer = 0;

    public int solution(int number, int limit, int power) {

        for (int i = 1; i <= number; i++) {
            getNum(i, limit, power);
        }
        System.out.println("answer = " + answer);
        return answer;
    }

    public void getNum(int number, int limit, int power) {
        int cnt = 0;
        for (int i = 1; i * i <= number; i++) {
            if (i * i == number) {
                cnt++;
            } else if (number % i == 0) { // 나누려는 몫이 뒤로 들어가야 함
                cnt += 2;
            }
        }
        if (cnt > limit) {
            cnt = power;
        }
        answer += cnt;

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(10, 3, 2);
    }
}