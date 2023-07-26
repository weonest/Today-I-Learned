package BaekJun.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class _1941 {

    static int answer;

    static char[][] map = new char[5][5];

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static boolean[] visited = new boolean[25];

    static int[] chosenGirls = new int[7];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            for (int j = 0; j < 5; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        combination(0, 0, 7);

        System.out.println(answer);
    }

    static void combination(int depth, int start, int r) {
        if (depth == r) {
            if (bfs()) answer++;
            return;
        }

        for (int i = start; i < 25; i++) {
            visited[i] = true;
            chosenGirls[depth] = i;
            combination(depth + 1, start + 1, r);
            visited[i] = false;
        }
    }

    static boolean bfs() {
        if (validGroup()) {
            List<Integer> princess = Arrays.stream(chosenGirls).boxed().collect(Collectors.toList());
            Queue<Integer> que = new ArrayDeque<>();
            que.offer(chosenGirls[0]);
            while (!que.isEmpty()) {
                int girl = que.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = girl / 5 + dx[i];
                    int ny = girl % 5 + dy[i];

                    if (!(nx < 0 || ny < 0 || nx >= 5 || ny >= 5)) {
                        if (princess.contains(nx * 5 + ny)) {
                            princess.remove(Integer.valueOf(nx * 5 + ny));
                            que.offer(nx * 5 + ny);
                        }
                    }
                }
            }
            if (!princess.isEmpty()) return false;
            return true;
        }
        return false;
    }

    static boolean validGroup() {
        int y = 0;
        for (int girl : chosenGirls) {
            if (map[girl / 5][girl % 5] == 'Y') y++;
        }
        if (y > 3) return false;
        return true;
    }
}
