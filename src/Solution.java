import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    static int[] answer = new int[2];

    public int[] solution(int[] lottos, int[] win_nums) {

        List<Integer> list = Arrays.stream(lottos).boxed().collect(Collectors.toList());

        int wild = 0;
        int cnt = 0;

        for (int i = 0; i < win_nums.length; i++) {

            if (list.get(i) == 0) {
                wild++;
            }
            if (list.contains(win_nums[i])) {
                cnt++;
            }

            checkWin(0, cnt+wild);
            checkWin(1, cnt);

        }

        return answer;
    }

    public void checkWin(int div, int num) {
        switch (num) {
            case 6:
                answer[div] = 1;
                break;
            case 5:
                answer[div] = 2;
                break;
            case 4:
                answer[div] = 3;
                break;
            case 3:
                answer[div] = 4;
                break;
            case 2:
                answer[div] = 5;
                break;
            default:
                answer[div] = 6;
        }
    }
}