package BaekJun.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _13144 {
    static int N;
    static List<Integer> nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            nums.add(Integer.parseInt(st.nextToken()));
        }

        int left = 0;
        int right = 0;
        Set<Integer> set = new HashSet<>(nums);

        while (true) {
            if (right == N) break;
        }
    }
}
