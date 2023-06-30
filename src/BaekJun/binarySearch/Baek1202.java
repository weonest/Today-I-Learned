package BaekJun.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek1202 {

    static int N, K;

    static class Jewel implements Comparable<Jewel>{
        int weight;
        int price;

        public Jewel(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(Jewel o) {
            if (this.weight != o.weight) {
                return this.weight - o.weight;
            }
                return this.price - o.price;
        }
    }
    static long answer = 0;
    static PriorityQueue<Jewel> store;
    static PriorityQueue<Integer> bags;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        store = new PriorityQueue<>();
        bags = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            store.add(new Jewel(weight, price));
        }

        for (int i = 0; i < K; i++) {
            int bagCap = Integer.parseInt(br.readLine());
            bags.add(bagCap);
        }

        while (!bags.isEmpty()) {
            int bagCap = bags.poll();

            if (store.peek().weight <= bagCap) {
                answer += store.poll().price;
            }else {
                continue;
            }
        }

        System.out.println(answer);
    }
}
