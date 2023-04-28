class Solution {
    int answer = 0;

//    public long solution(int n) {
//
//
//        dfs(n,0);
//
//        answer %= 1234567;
//        return answer;
//    }
//
//    public void dfs(int n, int tmp) {
//        if (tmp >= n) {
//            if (tmp == n) {
//                answer++;
//            }
//            return;
//        }
//
//        dfs(n, tmp + 1);
//        dfs(n, tmp + 2);
//    }

    /**
     * 위의 재귀로 푸는 식은 정답을 구할 순 있지만, 테스트 케이스에 따라 시간 초과
     *
     * 마지막에 1칸을 뛰어 도착하는 경우, 그 앞칸을 밟고 1칸을 뛴 경우이므로, dp[i-1] 이다.
     *
     * 마지막에 2칸을 뛰어 도착하는 경우, 그 앞앞칸을 밟고 2칸을 뛴 경우이므로, dp[i-2]이다.
     *
     * 따라서 점화식은 다음과 같다.
     *
     * dp[i] = dp[i-2] + dp[i-1]
     */
    public long solution(int n) {
        long arr[] = new long[2001];
        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i < 2001; i++) {
            arr[i] = (arr[i-1]+arr[i-2])%1234567;
        }
        return arr[n];
    }


}