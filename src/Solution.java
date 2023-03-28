import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;


        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();

        long target = 0;
        long sum1 = 0, sum2 = 0;




        for (Integer i : queue1) {
            sum1 += i;
            que1.add(i);
        }

        for (Integer i : queue2) {
            sum2 += i;
            que2.add(i);
        }
        target = sum1 + sum2;
        if (target % 2 != 0) {
            return -1;
        }

        target /= 2;

        int cnt = 0;

        while (sum1 != target) {
            if (sum1 > target) {
                int tmp = que1.poll(); // 반환 & 삭제
                sum1 -= tmp;
                sum2 += tmp;
                que2.add(tmp);
                cnt++;
            }
            if (sum2 > target) {
                int tmp = que2.poll();
                sum2 -= tmp;
                sum1 += tmp;
                que1.add(tmp);
                cnt++;
            }
            if (cnt > queue1.length * 3) { // 한계치 = 모든 원소를 교체했는데도 해를 찾지 못한 경우
                return -1;
            }
        }
        answer = cnt;

        return answer;
    }
}