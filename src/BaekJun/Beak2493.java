package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Beak2493 {
    static int N;

    static class Tower {
        int height;
        int index;

        public Tower(int height, int index) {
            this.height = height;
            this.index = index;
        }
    }

    static int[] tower;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder answer = new StringBuilder();
        Deque<Tower> deque = new ArrayDeque<>();
        N = Integer.parseInt(br.readLine());
        tower = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int height = Integer.parseInt(st.nextToken());
            while (!deque.isEmpty()) {
                if (deque.peek().height >= height) {
                    answer.append(deque.peek().index + " ");
                    break;
                }
                deque.pop();
            }
            if (deque.isEmpty()) {
                answer.append("0 ");
            }
            deque.push(new Tower(height, i));
        }
        System.out.println(answer);


//        for (int i = tower.length - 1; i > 0; i--) {
//            int cur = tower[i];
//            int cnt = 0;
//            for (int j = i - 1; j >= 0; j--) {
//                int target = tower[j];
//                if (cur < target) {
//                    cnt++;
//                    answer.append(j).append(" ");
//                    break;
//                }
//            }
//            if (cnt == 0) {
//                answer.append("0").append(" ");
//            }
//        }
    }
}
