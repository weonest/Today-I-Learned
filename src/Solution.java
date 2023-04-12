import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);


        // 0 1 3 5 6
        // 0 1 2 3 4


        for (int i = 0; i < citations.length; i++) {

            if (citations[i] >= citations.length - i) {
                answer = citations.length - i;
                break;
            }
        }

        return answer;
    }
}