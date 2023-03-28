class Solution {
    public int solution(int n) {
        int answer = 0;



        for (int i = n-1; i > 0; i--) {
            if (n % i == 1) {
                answer = i;
            }
        }

        return answer;
    }

    public int solution2(int n) {
        int answer = 0;
        for (int i=2; i<n; i++) {
            if (n % i == 1) {
                answer = i;
                break; // break를 통해 최소 값에서 멈추기 때문에
            }
        }
        return answer;
    }

}