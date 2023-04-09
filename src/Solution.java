import java.util.Arrays;
import java.util.Locale;

class Solution {
    public String solution(String str) {
        String s = str.toLowerCase();

        StringBuilder answer = new StringBuilder();

        String firstStr = s.charAt(0) + "";
        answer.append(firstStr.toUpperCase());

        for (int i = 1; i < s.length(); i++) {

            String cur = s.charAt(i) + "";
            System.out.println("cur = " + cur);

            if (cur.equals(" ")) {
                answer.append(" ");
            } else if (s.charAt(i - 1) == ' ') {
                answer.append(cur.toUpperCase());
            } else {
                answer.append(cur);
            }

        }
        System.out.println("answer.toString() = " + answer.toString());
        return answer.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution("a   a   a   a ");
        // 무조건 공백은 하나만 남겨야 하는 건 줄
    }
}