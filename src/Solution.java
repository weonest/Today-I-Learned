import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int answer = 0;

    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};

    public int solution(int[][] maps) {

        int[][] visited = new int[maps.length][maps[0].length];

        bfs(maps, visited);

        answer = visited[maps.length - 1][maps[0].length - 1];

        if (answer == 0) {
            answer = -1;
        }

        return answer;
    }

    public void bfs(int[][] maps, int[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[0][0] = 1;

        while (!q.isEmpty()) { // 더 나아갈 곳이 없을 때까지
            int[] cur = q.poll();
            int X = cur[0];
            int Y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nX = X + dx[i];
                int nY = Y + dy[i];

                // 좌표가 maps에서 벗어날 경우 패스
                if (nX < 0 || nX > maps[0].length - 1 || nY < 0 || nY > maps.length - 1) {
                    continue;
                }

                // 아직 방문하지 않았고, 벽이 아닌 경우
                if (visited[nX][nY] == 0 && maps[nX][nY] == 1) {
                    visited[nX][nY] = visited[X][Y] + 1;
                    q.add(new int[]{nX, nY});
                }
            }
        }
    }
}