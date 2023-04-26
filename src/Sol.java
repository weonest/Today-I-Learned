public class Sol {

    int answer = 0;

    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};

    int[][] visited;

    class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;

        }
    }
    public int solution(int[][] maps) {

        visited = new int[maps.length][maps[0].length];

        dfs(maps, 0, 0);
        answer = visited[maps.length - 1][maps[0].length-1];
        return answer;
    }



    public void dfs(int[][] maps, int x, int y) {
        visited[x][y] = 1;

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

//               if(newX < 0 || newX > maps[0].length - 1 || newY < 0 || newY > maps.length - 1) {
            if (newX >= 0 && newY >= 0 && newX <= maps[0].length - 1 && newY <= maps.length - 1){
                if (visited[newX][newY] == 0 && maps[newX][newY] == 1) {
                    visited[newX][newY] = visited[x][y] + 1;
                    dfs(maps, newX, newY);
                }
            }
        }
    }

}
