package BaekJun.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Baek7662 {

    static int T, K, Q;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int ti = 0; ti < T; ti++) {
            K = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int i = 0; i < K; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char op = st.nextToken().charAt(0);
                int pr = Integer.parseInt(st.nextToken());

                if (op == 'I') {
                    map.put(pr, map.getOrDefault(pr, 0) + 1);
                }
                else {
                    if (map.size() == 0) {
                        continue;
                    }
                    int target = 0;
                    if (pr == 1) {
                        target = map.lastKey();
                    }else {
                        target = map.firstKey();
                    }

                    if (map.put(target, map.get(target) - 1) == 1) {
                        map.remove(target);
                    }

                }
            }
            if (map.isEmpty()) {
                System.out.println("EMPTY");
            } else{
                System.out.println(map.lastKey() + " " + map.firstKey());
            }
        }
    }
}
