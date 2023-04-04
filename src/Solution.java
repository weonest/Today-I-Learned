class Solution {
    public long solution(int price, int money, int count) {
        long answer = money;

        // 3 20 4 10  // 3 + 6 + 9 + 12 = 30 // 30 - 20 = 10

        for (int i = 1; i <= count; i++) {
            answer -= price * i;
        }

        return answer > 0 ? 0 : -answer;
    }
}