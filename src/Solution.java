import java.util.Arrays;
import java.util.List;

class Solution {
    public int solution(String skill, String[] skill_trees) {

        if (skill.length() == 1) return skill_trees.length;

        int answer = 0;

        String pt = "[^" + skill + "]";

        for (String s : skill_trees) {
            s = s.replaceAll(pt, "");

            System.out.println("s = " + s);

            if (s.equals("")) { // 없으면 다 배울 수 있으니까
                answer++;
                continue;
            }
            for (int i = 1; i <= skill.length(); i++) {
                if (skill.substring(0, i).equals(s)) {
                    answer++;
                }
            }

        }


        return answer;
    }
}
