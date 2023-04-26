import java.util.LinkedList;
import java.util.Queue;

class Solution {

    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};

    class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;

        }
    }

    public int solution(int[][] maps) {
        int answer = 0;

        int[][] visited = new int[maps.length][maps[0].length];

        bfs(maps, visited);

        answer = visited[maps.length - 1][maps[0].length - 1];

        if (answer == 0) {
            answer = -1;
        }

        return answer;
    }

    public void bfs(int[][] maps, int[][] visited) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));

        visited[0][0] = 1;

        while (!q.isEmpty()) { // 더 나아갈 곳이 없을 때까지
            Node node = q.poll();

            int X = node.x;
            int Y = node.y;

            for (int i = 0; i < 4; i++) {

                int newX = X + dx[i];
                int newY = Y + dy[i];

                // 좌표가 maps에서 벗어날 경우 패스
                if (newX < 0 || newX > maps[0].length - 1 || newY < 0 || newY > maps.length - 1) {
                    continue;
                }

                // 아직 방문하지 않았고, 벽이 아닌 경우
                if (visited[newY][newX] == 0 && maps[newY][newX] == 1) {
                    visited[newY][newX] = visited[Y][X] + 1;
                    q.add(new Node(newX, newY));
                }
            }
        }
    }
}