class Solution {
        int answer = -1;
        boolean[] visited;
    public int solution(int k, int[][] dungeons) {

        visited = new boolean[dungeons.length];


        dfs(dungeons, k, 0);

        return answer;
    }

    public void dfs(int[][] dungeons, int k, int cnt) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                dfs(dungeons, k - dungeons[i][1], cnt + 1);
                visited[i] = false;
            }
        }
        answer = Math.max(cnt, answer);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{80, 20}, {50, 40}, {30, 10}};
        solution.solution(80, arr);
    }
    //틀릴 수도 있지만, 위 코드에서 check는 클래스 전역 변수입니다. dfs를 실행하다 보면 결국엔 모든 check가 true가 되어버리는 경우가 생깁니다. 그런데 여기서 대부분의 경우에는 check의 모든 값들이 true인 상황이지만 전체 경우의 수를 탐색하지 않은 상태입니다. 따라서 완전탐색을 위해 check를 false로 바꿔주는 거라고 이해하고 있습니다. 또 마지막에 Math.max()를 하는 이유는 각각의 경우의 수를 탐색하는 과정에서 어찌되었든 for문이 끝났다는건 그래프의 한 가지를 모두 탐색했다는 뜻이기 때문에 이 때 해당 그래프의 가지를 통해 얻어낸 cnt들을 그때마다 조사해서 가장 큰 값을 ans에 넣어주기 위함인 것으로 이해하고 있어요.
}

