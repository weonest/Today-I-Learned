package BaekJun.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek2230 {

    static int N, M;
    static int[] arr;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int left = 0, right = 0;

        while (left < N && right < N) {
            if (arr[right] - arr[left] < M) {
                right++;
            }
            else {
                answer = Math.min(answer, arr[right] - arr[left]);
                left++;
            }
        }
        System.out.println(answer);
    }


}
