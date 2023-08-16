package BaekJun.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1781 {
    static class Problem implements Comparable<Problem> {
        int dead;
        int comp;

        public Problem(int dead, int comp) {
            this.dead = dead;
            this.comp = comp;
        }

        @Override
        public int compareTo(Problem o) {
            if (this.dead == o.dead) {
                return o.comp - this.comp;
            }
            return this.dead - o.dead;
        }

        @Override
        public String toString() {
            return "Problem{" +
                    "dead=" + dead +
                    ", comp=" + comp +
                    '}';
        }
    }

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Problem> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int dead = Integer.parseInt(st.nextToken());
            int comp = Integer.parseInt(st.nextToken());

            list.add(new Problem(dead, comp));
        }
        Collections.sort(list);
        
        // 1 10, 1 20, 2 100, 2 100 
        // 모든 문제는 1시간이 걸리고 데드라인 내에 풀어야 한다
        for (Problem p : list) {
            int time = pq.size();

            if (p.dead > time) {
                pq.add(p.comp);
            } else if (p.dead == time) {
                if (pq.peek() < p.comp) {
                    pq.poll();
                    pq.add(p.comp);
                }
            }
        }
        while (!pq.isEmpty()) {
            answer += pq.poll();
        }

        System.out.println(answer);
    }
}
