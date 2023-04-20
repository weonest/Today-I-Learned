import java.util.*;

class Solution {
    public List<Integer> solution (int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> que = new LinkedList<>();


        for (int i = 0; i < progresses.length; i++) {
            que.add((int) (Math.ceil((100.0 - progresses[i]) / speeds[i]))); //소수점을 정수로 반올림
        }
        System.out.println("que = " + que);

        while (!que.isEmpty()) {
            int day = que.poll();
            int cnt = 1;

            while (!que.isEmpty() && day >= que.peek()) {
                cnt++;
                que.poll();
            }
            answer.add(cnt);
        }


        return answer;
    }
}