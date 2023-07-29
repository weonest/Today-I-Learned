package BaekJun.garph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.toUnsignedLong;

public class Baek2617 {
    static int N, M;
    static boolean[] visited;
    static int answer;
    static Marble[] marbles;

    static class Marble {

        int idx;
        int hCnt;
        int lCnt;

        public Marble(int idx) {
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = parseInt(st.nextToken());
        M = parseInt(st.nextToken());

        marbles = new Marble[N + 1];
        visited = new boolean[100];

        for (int i = 1; i <= N; i++) {
            marbles[i] = new Marble(i);
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int heavy = Integer.parseInt(st.nextToken());
            int light = Integer.parseInt(st.nextToken());

            marbles[heavy].hCnt += marbles[light].hCnt + 1;
            marbles[light].lCnt--;
        }

        System.out.println("marbles = " + marbles[4].hCnt);
        System.out.println("marbles = " + marbles[1].lCnt);
        
        // 다시 풀어야 함
    }
}
