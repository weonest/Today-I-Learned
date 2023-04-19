import java.util.*;
import java.util.regex.Pattern;

class Solution {
    public int[] solution(String s) {
        int[] answer;
        Map<Integer, Integer> map = new HashMap<>();


        s = s.replaceAll("[\\{\\}]", "");


        for (String val : s.split(",")) {
            int tmp = Integer.parseInt(val);
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }

        int size = map.size();
        answer = new int[size];

        for (Integer i : map.keySet()) {
            answer[size - map.get(i)] = i;
        }

        System.out.println("map = " + map);



        return answer;
    }
}