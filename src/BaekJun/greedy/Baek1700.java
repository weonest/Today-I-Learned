package BaekJun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek1700 {

    static int N, K;

    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] orders = new int[K];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            orders[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> multitap = new HashSet<>();

//        for (int i = 0; i < K; i++) {
//            if (multitap.contains(orders[i]) {
//                continue;
//            }
//
//            if (multitap.size() < N) {
//                multitap.add(orders[i]);
//            } else {
//                Set<Integer>
//            }
//        }

    }
}
