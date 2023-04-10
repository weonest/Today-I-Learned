class Solution {

    public int solution(int n) {
        int answer = 1;

        for (int i = 1; i < n; i++) {
            int tmp = i;
            int sum = 0;

            while (tmp != n) {
                sum += tmp;
                tmp++;
                if (sum >= n) {
                    break;
                }
            }
            if (sum == n) answer++;
        }
        return answer;
    }


    /**
     * 재귀
     */
    //for (int i = 1; i < n; i++) {
    //        recursive(n, i, 0);
    //
    //        }

    // public void recursive(int n, int idx, int sum) {
    //        if (sum >= n) {
    //            if (sum == n) {
    //                answer++;
    //            }
    //            return;
    //        }
    //
    //        recursive(n, idx + 1, sum + idx);
    //
    //    }
}
