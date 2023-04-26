class Solution {

    boolean[][] graph;

    public int solution(int n, int[][] wires) {
        int answer = -1;

        graph = new boolean[n][n];

        for (int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];

            graph[a][b] = graph[b][a] = true;
        }

        for (int j = 0; j < wires.length; j++) {
            for (int x = 0; x < wires.length; x++) {
                for (int y = 0; y < wires[0].length; y++) {
                    if (j == x || j == y) continue;
                    if (graph[y][x]) {
                        dfs(x, y);
                    }
                }
            }
        }

        return answer;
    }

    void dfs(int x, int y) {
        graph[x][y] = false;


        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {

            }
        }
    }

}