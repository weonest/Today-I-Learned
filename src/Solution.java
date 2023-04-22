import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (long i : scoville) {
            pq.offer(i);
        }
        long min = pq.peek();
        while (K > min && pq.size() > 1) {
            answer++;

            long least = pq.poll();
            long less = pq.poll();
            long hotter = least + (less * 2);
            pq.offer(hotter);

            min = pq.peek();
        }
            if (min < K) return -1;


        return answer;
    }
}