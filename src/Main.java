import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int answer = N;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            boolean visited[] = new boolean[26];

            for (int j = 0; j < str.length() - 1; j++) {
                int cur = str.charAt(j) - 'a';
                int next = str.charAt(j+1) - 'a';

                if (cur != next) {
                    if (visited[next]) {
                        answer--;
                        break;
                    }
                }
                visited[cur] = true;

            }
        }
        System.out.println(answer);
    }

}
