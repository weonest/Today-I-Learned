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