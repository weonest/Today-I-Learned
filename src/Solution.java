class Solution {
        int answer = 0;
    public int solution(int[] numbers, int target) {

        dfs(0, target, numbers, 0);

        return answer;
    }

    public void dfs(int idx, int target, int[] numbers, int tmp) {
        if (idx == numbers.length) {
            if (tmp == target) {
                answer++;
            }

            return;
        }

        dfs(idx+1, target, numbers, tmp + numbers[idx]);
        dfs(idx+1, target, numbers, tmp - numbers[idx]);

    }
}