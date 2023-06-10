package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek1759 {

    static char[] alphas;
    static char[] answer;
    static boolean[] visited;
    static int vowels, consonants;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        answer = new char[l];
        alphas = new char[c];
        visited = new boolean[c];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            alphas[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(alphas);

        combination(0, 0, l);

    }

    public static void combination(int start, int depth, int l) {
        if (depth == l) {
            for (char c : answer) {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    vowels = 1;
                }else {
                    consonants++;
                }
            }
            if (vowels == 1 && consonants > 1) {
                for (char c : answer) {
                    System.out.print(c);
                }
                System.out.println();
            }
            vowels = 0;
            consonants = 0;
            return;
        }
        for (int i = start; i < alphas.length; i++) {

            answer[depth] = alphas[i];
            combination(i + 1, depth + 1, l);
        }
    }
}
