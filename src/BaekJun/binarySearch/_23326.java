package BaekJun.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _23326 {

    static int N, Q;

    static Map<Integer, Integer> map = new HashMap<>();
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            int exit = Integer.parseInt(st.nextToken());
            if (exit != 0) {
                map.put(i, exit + cnt);
                set.add(i);
                cnt++;
                continue;
            }
            map.put(i, exit);
        }
        System.out.println(map);

        int curPos = 1;

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            if (command == 3) {
                if (set.isEmpty()) {
                    System.out.println(-1);
                    continue;
                }
                if (map.get(curPos) == 0) {
                    int move = 0;
                    for (int j = curPos + 1; i <= N; j++) {
                        int cur = map.get(j);
                        move++;
                        if (cur > 0) {
                            System.out.println(move);
                        }
                    }
                }
                continue;
            }
            if (command == 1) {
                int option = Integer.parseInt(st.nextToken());
                int target = map.get(option);

                if (target != 0) {
                    map.put(option, 0);
                } else {
                    map.put(option, 1);
                }
            } else {
                int option = Integer.parseInt(st.nextToken());
                curPos += (curPos + option) % N;
                if (curPos == 0) curPos = N;
            }
        }
    }
}
