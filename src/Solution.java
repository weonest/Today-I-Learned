class Solution {
    public int solution(int n) {
        int answer = 0;


        int target = Integer.bitCount(n);

        int tmp = n;

        while (true) {
            tmp++;
            int cur = Integer.bitCount(tmp);
            if (target == cur) {
                answer = tmp;
                break;
            }
        }


        return answer;
    }
}