package BaekJun.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

// 트리셋 사용하기 + 트리셋은 컴페어투로 값을 비교하고 삭제
public class _21939 {

    static int N;

    static int M;
    
    static TreeMap<Integer, Integer> map = new TreeMap<>();
    static Map<Integer, Integer> tmp = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            map.put(l, p);
            tmp.put(p, l);
        }

        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                if (command.equals("add")) {
                    int p = Integer.parseInt(st.nextToken());
                    int l = Integer.parseInt(st.nextToken());
                    add(p, l);
                    continue;
                }
                if (command.equals("recommend")) {
                    int option = Integer.parseInt(st.nextToken());
                    recommend(option);
                } else {
                    int option = Integer.parseInt(st.nextToken());
                    solved(option);
            }
        }
    }

    static void add(int p, int l) {
        map.put(l, p);
        tmp.put(p, l);
    }

    static void recommend(int option) {
        if (option == 1) {
            System.out.println(map.lastEntry().getValue());
            return;
        }
        System.out.println(map.firstEntry().getValue());
    }

    static void solved(int target) {
//        AtomicInteger key = new AtomicInteger();
//        map.forEach((integer, integer2) -> {
//            if (integer2 == target) {
//                key.set(integer);
//            }
//        });
//        map.remove(key.get());
        int key = tmp.get(target);
        map.remove(key);
        tmp.remove(target);
    }
}
