import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;


        PriorityQueue<Integer> queue1 = new PriorityQueue<>();
        PriorityQueue<Integer> queue2 = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < A.length; i++) {
            queue1.add(A[i]);
            queue2.add(B[i]);
        }

        while (!queue1.isEmpty()) {
            answer += queue1.poll() * queue2.poll();
        }

        return answer;
    }
}