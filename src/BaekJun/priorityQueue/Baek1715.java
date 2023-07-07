package BaekJun.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baek1715 {

    static int N;

    static int answer = 0;

    static PriorityQueue<Integer> que;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        que = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int card = Integer.parseInt(br.readLine());
            que.add(card);
        }

        while (que.size() != 1) {
            int a = que.poll();
            int b = que.poll();

            answer += a + b;

            que.add(a + b);
        }
        System.out.println(answer);
    }
}
