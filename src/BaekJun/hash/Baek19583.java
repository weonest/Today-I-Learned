package BaekJun.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek19583 {
    static int S;
    static int E;
    static int Q;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken().replaceAll(":", ""));
        E = Integer.parseInt(st.nextToken().replaceAll(":", ""));
        Q = Integer.parseInt(st.nextToken().replaceAll(":", ""));

        HashSet<String> enter = new HashSet<>();
        String value = br.readLine();


        while (!value.isEmpty() && value != null) {
            st = new StringTokenizer(value);
            int time = Integer.parseInt(st.nextToken().replaceAll(":", ""));
            String name = st.nextToken();

            if (time <= S) {
                enter.add(name);
            } else if (E <= time && time <= Q && enter.contains(name)) {
                enter.remove(name);
                answer++;
            }
        }
        System.out.println(answer);
    }
}
