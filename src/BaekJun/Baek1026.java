package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Baek1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        int[] b = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        Integer[] B = Arrays.stream(b).boxed().toArray(Integer[]::new);

        Arrays.sort(a);
        Arrays.sort(B, Comparator.reverseOrder());

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i] * B[i];
        }
        System.out.println(sum);
    }
}
