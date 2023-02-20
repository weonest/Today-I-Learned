import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<Integer, Integer> answerMap = new HashMap<>();
    Map<String, Integer> pes = new HashMap<>();
    String[] arr = {"RT", "CF", "JM", "AN"};

    public String solution(String[] survey, int[] choices) {
        String answer = "";

        answerMap.put(1, 3);
        answerMap.put(2, 2);
        answerMap.put(3, 1);
        answerMap.put(4, 0);
        answerMap.put(5, 1);
        answerMap.put(6, 2);
        answerMap.put(7, 3);

        pes.put("R", 0);
        pes.put("T", 0);
        pes.put("C", 0);
        pes.put("F", 0);
        pes.put("J", 0);
        pes.put("M", 0);
        pes.put("A", 0);
        pes.put("N", 0);

        int idx = 0;

        for (String s : survey) {
            String[] tmp = s.split("");
            System.out.println(Arrays.toString(tmp));
            storeAnswer(tmp, choices[idx]);
            idx++;
        }

        for (String s : arr) {
            String[] tmp = s.split("");
            answer += compareMethod(tmp);
        }

        System.out.println("pes = " + pes);
        System.out.println("answer = " + answer);
        return answer;
    }

    public void storeAnswer(String[] survey, int choice) {
        int tmpAnswer = answerMap.get(choice);
        String target = "";
        if (choice > 4) {
            target = survey[1];
        } else if (choice < 4) {
            target = survey[0];
        } else{
            return;
        }
        pes.replace(target, pes.get(target) + tmpAnswer);


    }

    public String compareMethod(String[] tmp) {
        int a = pes.get(tmp[0]);
        int b = pes.get(tmp[1]);
        String tmpAnswer = "";
        if (a > b || a == b) {
            tmpAnswer = tmp[0];
        } else if (a < b) {
            tmpAnswer= tmp[1];
        }
        return tmpAnswer;
    }

    public static void main(String[] args) {
        String[] survey = {"AN"};
        int[] choices = {4};
//        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
//        int[] choices = {5, 3, 2, 7, 5};
        Solution sol = new Solution();
        sol.solution(survey, choices);
    }
}