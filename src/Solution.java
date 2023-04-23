import java.util.Arrays;

class Solution {
        int[] answer;
    public int[] solution(int[] array, int[][] commands) {

        answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            cutArray(array, commands[i], i);
        }

        return answer;
    }

    public void cutArray(int[] array, int[] arr, int n) {

        int start = arr[0] -1;
        int end = arr[1] - 1;
        int target = arr[2] - 1;

        int[] tmp = new int[end - start + 1];

        int idx = 0;
        for (int i = start; i <= end; i++) {
            tmp[idx] = array[i];
            idx++;
        }
        Arrays.sort(tmp);

        answer[n] = tmp[target];
    }
}