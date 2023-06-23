package BaekJun.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Baek13414 {

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int count = 0;

        Set<String> set = new LinkedHashSet<>();

        for (int i = 0; i < M; i++) {
            String num = br.readLine();

            if (set.contains(num)) {
                set.remove(num);
            }
            set.add(num);

        }

        for (String s : set) {
            System.out.println(s);
            count++;
            if (count == N)
                break;
        }

    }
}
