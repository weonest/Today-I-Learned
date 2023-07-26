package BaekJun.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _18809 {

    static int N, M, G, R;

    static int[][] map;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean[][][] visited;

    static class Land{
        int x, y, time;
        char color;

        public Land(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Land(int x, int y, int time, char color) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.color = color;
        }
    }

    static ArrayList<Land> availableLands = new ArrayList<>();

    static boolean[] visitedAvailable;

    static Land[] selectedLands;

    static boolean[] selectedColor;

    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][N + M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    availableLands.add(new Land(j, i));
                }
            }
        }

        visitedAvailable = new boolean[availableLands.size()];
        selectedLands = new Land[G + R];
        selectedColor = new boolean[G + R];

        combinationLand(0, 0);

        System.out.println(answer);
    }

    // 조합의 시간 복잡도 O(2^N)
    static void combinationLand(int depth, int idx) {
        if (depth == G + R) {
            combinationColor(0, 0);
            return;
        }

        for (int i = idx; i < availableLands.size(); i++) {
            visitedAvailable[i] = true;
            selectedLands[depth] = availableLands.get(i);
            combinationLand(depth + 1, i + 1);
            visitedAvailable[i] = false;
        }
    }

    static void combinationColor(int depth, int idx) {
        if (depth == R) {
            answer = Math.max(answer, bfs());
            return;
        }

        for (int i = idx; i < selectedLands.length; i++) {
            selectedColor[i] = true;
            combinationColor(depth + 1, i + 1);
            selectedColor[i] = false;
        }
    }

    static int bfs() {
        Queue<Land> que = new ArrayDeque<>();

        for (int i = 0; i < selectedLands.length; i++) {
            Land land = selectedLands[i];
            if (selectedColor[i]) {
                que.offer(new Land(land.x, land.y, 0, 'R'));
                map[land.y][land.x] = 3;
                visited[land.y][land.x][0] = true;
            }
        }

        for (int i = 0; i < selectedLands.length; i++) {
            Land land = selectedLands[i];
            if (!selectedColor[i]) {
                que.offer(new Land(land.x, land.y, 0, 'G'));
                map[land.y][land.x] = 4;
                visited[land.y][land.x][0] = true;
            }
        }

        int cnt = 0;

        while (!que.isEmpty()) {
            Land cur = que.poll();
            int time = cur.time;

            if (map[cur.y][cur.x] == 5) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + cur.x;
                int ny = dy[i] + cur.y;

                if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                    if (map[ny][nx] == 1 || map[ny][nx] == 2) {
                        if (cur.color == 'R') {
                            map[ny][nx] = 3;
                        }
                        else {
                            map[ny][nx] = 4;
                        }
                        que.offer(new Land(nx, ny, time, cur.color));
                        time++;
                        visited[ny][nx][time] = true;
                    } else if (cur.color == 'G' && map[ny][nx] == 3 && visited[ny][nx][time] == true) {
                        map[ny][nx] = 5;
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
