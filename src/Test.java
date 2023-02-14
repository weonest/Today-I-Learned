import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;

        for (int i = 0; i <= t.length() - p.length(); i++) {
            String tmp = t.substring(0 + i, p.length()+i);
            System.out.println(tmp);

            if (Long.parseLong(tmp) <= Long.parseLong(p)) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("3141592", "271"));
        System.out.println(sol.solution("10203", "15"));
    }
}