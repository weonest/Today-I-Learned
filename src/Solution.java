import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        List<String> list = new ArrayList<>();
        list.add(words[0]);

        char target = words[0].charAt(words[0].length() - 1);
        for (int i = 1; i < words.length; i++) {

            if (!list.contains(words[i]) && target == words[i].charAt(0)) {
                list.add(words[i]);
                target = words[i].charAt(words[i].length() - 1);
            } else {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
        }

        System.out.println("Arrays.toString(answer) = " + Arrays.toString(answer));

        return answer;
    }
}