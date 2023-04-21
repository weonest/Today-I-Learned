import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        List<String> wantList = new ArrayList<>();

        for (int i = 0; i < want.length; i++) {

            for (int j = 0; j < number[i]; j++) {
                wantList.add(want[i]);
            }
        }
        // 1 2 3 4 5 6 7 8 9 10 11 12 13 14

        for (int i = 0; i < discount.length - 9; i++) {
            List<String> disList = new ArrayList<>();
            for (int j = i; j < i + 10; j++) {
                disList.add(discount[j]);
            }

            for (String s : wantList) {
                disList.remove(s);
            }
            if (disList.isEmpty()) {
                answer++;
            }

        }

        return answer;
    }
}