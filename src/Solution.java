class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int cur = prices[i];

            if (i == prices.length - 1) {
                answer[i] = 0;
                break;
            }
            for (int j = i+1; j < prices.length; j++) {
                int compare = prices[j];

                if (cur <= compare) {
                    answer[i]++;
                } else {
                    answer[i]++;
                    break;
                }
            }
        }

        return answer;
    }
}