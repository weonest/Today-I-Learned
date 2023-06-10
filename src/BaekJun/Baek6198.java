package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Baek6198 {

    static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            deque.push(num);
//
            while (!deque.isEmpty()) {
                int cur = deque.removeFirst();
                Deque<Integer> copy = new ArrayDeque<>(deque);

                while (!copy.isEmpty()) {
                    if (cur >= copy.removeFirst()) {
                        answer++;
                    } else {
                        break;
                    }
                }
            }
            System.out.println(answer);
        }
    }
}
