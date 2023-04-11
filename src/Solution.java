import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Deque<Integer> que = new ArrayDeque<>();

        Arrays.sort(people);

        for (Integer i : people) {
            que.add(i);
        }

        while (que.size() > 0) {

            if (que.peek() + que.peekLast() > limit) {
                que.pollLast();
                answer++;
            }
            else if (que.peek() + que.peekLast() <= limit){
                que.poll();
                que.pollLast();
                answer++;
            }
        }

        return answer;
    }
}