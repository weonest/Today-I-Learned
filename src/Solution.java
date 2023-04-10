class Solution {

    int[] arr;
    public int solution(int n) {
        int answer = 0;
        arr = new int[n + 1];

        return answer = recursive(n);
    }

    public int recursive(int num) {
        if (arr[num] > 0) return arr[num];

        if (num < 2) {
            return num;
        }
        return arr[num] = (recursive(num - 2) + recursive(num-1)) % 1234567;
    }
}