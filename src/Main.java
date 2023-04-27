import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int max;
    static int[] arr;
    static int answer;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        max = 0;

        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            arr[i] = cur;
        }
        dfs(0, 0, 0);

        System.out.println(answer);

    }

    static void dfs(int depth, int start, int sum) {
        if (depth == 3) {
            if (sum <= M) {
                answer = Math.max(answer, sum);
            }
            return;
        }



        for (int i = start; i < N; i++) {
            dfs(depth + 1, i+1, sum + arr[i]);
        }
    }
}

