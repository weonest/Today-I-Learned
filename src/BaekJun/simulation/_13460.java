package BaekJun.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class _13460 {

    static int N, M;
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};
    static int holeX, holeY;
    static char[][] map;
    static boolean visited[][][][];

    static class Marble{
        int x;
        int y;
        int cnt;

        public Marble(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M][N][M];
        Marble red = null, blue = null;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);

                if (map[i][j] == 'O') {
                    holeX = j;
                    holeY = i;
                } else if (map[i][j] == 'R') {
                    red = new Marble(j, i, 1);
                } else if (map[i][j] == 'B') {
                    blue = new Marble(j, i, 0);
                }
            }
        }
        System.out.println(bfs(red, blue));
    }

    static int bfs(Marble red, Marble blue) {
        Queue<Marble[]> q = new ArrayDeque<>();
        q.add(new Marble[]{red, blue});
        visited[red.y][red.x][blue.y][blue.x] = true;
        while (!q.isEmpty()) {
            Marble[] poll = q.poll();
            red = poll[0];
            blue = poll[1];

            int rx = red.x;
            int ry = red.y;
            int bx = blue.x;
            int by = blue.y;
            int cnt = red.cnt;

            if (cnt > 10) {
                return -1;
            }

            for (int i = 0; i < 4; i++) {
                int nrx = rx;
                int nry = ry;
                int nbx = bx;
                int nby = by;

                boolean redHole = false;
                boolean blueHole = false;

                while (map[nry + dy[i]][nrx + dx[i]] != '#') {
                    nrx += dx[i];
                    nry += dy[i];

                    if (nrx == holeX && nry == holeY) {
                        redHole = true;
                        break;
                    }
                }

                while (map[nby + dy[i]][nbx + dx[i]] != '#') {
                    nbx += dx[i];
                    nby += dy[i];

                    if (nbx== holeX && nby == holeY) {
                        blueHole = true;
                        break;
                    }
                }
                if (blueHole) continue; // 예제 5에서 error 다음 방문을 처리해야 하니까
                if (!blueHole && redHole) return cnt;
                // 시작 지점 부터 도착 지점의 거리를 파악해서 위치 조정 -> 도연님 아이디어
                if (nrx == nbx && nry == nby) {
                    if (i == 0) { // 상
                        if (ry > by) nry -= dy[i];
                        else nby -= dy[i];
                    }
                    else if (i == 1) { // 하
                        if (ry > by) nby -= dy[i];
                        else nry -= dy[i];
                    }
                    else if (i == 2) { // 좌
                        if (rx > bx) nrx -= dx[i];
                        else nbx -= dx[i];
                    }
                    else  { // 우
                        if (rx > bx) nbx -= dx[i];
                        else nrx -= dx[i];
                    }
                }
                if (!visited[nry][nrx][nby][nbx]) {
                    visited[nry][nrx][nby][nbx] = true;
                    q.add(new Marble[]{new Marble(nrx, nry, cnt + 1), new Marble(nbx, nby, 0)});
                }
            }
        }
        return -1;
    }
}
