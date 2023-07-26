package BaekJun.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9663 {

    static int[] board;

    static int N;

    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        board = new int[N];

        backTracking(0);

        System.out.println(answer);
    }

    static void backTracking(int depth) {
        if (depth == N) {
            answer++;
            return;
        }

        for (int i = 0; i < N; i++) {
            board[depth] = i;
            if (checkQueenPosition(depth)) {
                backTracking(depth + 1);
            }
        }
    }

    static boolean checkQueenPosition(int depth) {
        for (int i = 0; i < depth; i++) {
            if (board[depth] == board[i]) {
                return false;
            }

            if (Math.abs(board[depth] - board[i]) == Math.abs(depth - i)) {
                return false;
            }
        }
        return true;
    }
}
