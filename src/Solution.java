import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();


        List<String> list1 = new LinkedList<>();
        List<String> list2 = new LinkedList<>();


        String pt = "^[a-z]";

        for (int i = 0; i < str1.length() - 1; i++) {
            String cur = str1.charAt(i) + "";
            String nex = str1.charAt(i + 1) + "";


            if (Pattern.matches(pt, cur) && Pattern.matches(pt, nex)) {
                list1.add(cur + nex);
            }

        }

        for (int i = 0; i < str2.length() - 1; i++) {
            String cur = str2.charAt(i) + "";
            String nex = str2.charAt(i + 1) + "";


            if (Pattern.matches(pt, cur) && Pattern.matches(pt, nex)) {
                list2.add(cur + nex);
            }

        }

        if (list1.size() >= list2.size()) {
            answer = (int) Math.floor(jaccard(list1, list2) * 65536);
        } else {
            answer = (int) Math.floor(jaccard(list2, list1) * 65536);
        }


        return answer;
    }

    public double jaccard(List<String> list, List<String> list2) {

        Queue<String> que = new LinkedList<>(list2);

        if (list.isEmpty() && list2.isEmpty()) {
            return 1;
        }

        double intersection = 0.0;
        double union = list.size();

        while (!que.isEmpty()) {
            if (list.contains(que.peek())) {
                intersection++;
                for (int i = list.size() - 1; i >= 0; i++) {
                    list.remove(que.peek());
                    break;
                }
                que.poll();
            } else {
                que.poll();
                union++;
            }
        }
        double jaccard = intersection / union;


        return jaccard;
    }
}