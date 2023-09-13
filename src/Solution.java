class Solution {

    boolean[] visited;
    int answer = 0;

    public int solution(int k, int[][] dungeons) {

        visited = new boolean[dungeons.length];

        dfs(dungeons, k , 0);
        return answer;
    }

    public void dfs(int[][] dungeons, int k, int cnt) {

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(dungeons, k - dungeons[i][1], cnt + 1);
                visited[i] = false;
            }
        }
        answer = Math.max(answer, cnt);
    }

    public static void main(String[] args) {
        int k = 80;
        int[][] arr = {{80, 20}, {50, 40}, {30, 10}};
        Solution sol = new Solution();
        sol.solution(k, arr);

    }
}