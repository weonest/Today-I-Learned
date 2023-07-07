package BaekJun.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baek1655 {

    static int N;

    static PriorityQueue<Integer> minQue;
    static PriorityQueue<Integer> maxQue;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        /**
         * 내림차순 정렬을 하지 않았더니 minQue에 있는 max 값에 접근하기가 번거로움.
         * Deque를 쓰고 정렬을 해도 괜찮을듯?
         */
        minQue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        maxQue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (minQue.size() == maxQue.size()) {
                minQue.add(num);
            } else {
                maxQue.add(num);
            }

            if (!maxQue.isEmpty() && minQue.peek() > maxQue.peek()) {
                int tmp = maxQue.poll();
                maxQue.add(minQue.poll());
                minQue.add(tmp);
            }

            /**
             * if (!maxQue.isEmpty() && minQue.peek() > maxQue.peek()) {
             *      maxQue.add(minQue.poll());
             *      
             *      이렇게 하는 경우 계속 maxQue로만 데이터가 쌓임.
             *      스왑을 해주지 않으면 NullPointer 발생
             */


            sb.append(minQue.peek() + "\n");
        }
        System.out.println(sb);
    }
}
