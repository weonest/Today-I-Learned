package BaekJun.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _13975 {

    static int T, K;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            long answer = 0;
            K = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            PriorityQueue<Long> pq = new PriorityQueue<>();
            for (int i = 0; i < K; i++) {
                long file = Integer.parseInt(st.nextToken());
                pq.offer(file);
            }

            while (pq.size() > 1) {
                long a = pq.poll();
                long b = pq.poll();

                long c = a + b;

                answer += c;
                pq.offer(c);
            }
            System.out.println(answer);
        }
    }
}
