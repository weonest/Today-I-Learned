import java.util.*;

class Solution {

    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < keymap.length; i++) {
            String str = keymap[i];

            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (map.containsKey(c)) {
                    map.put(c, Math.min(j + 1, map.get(c)));
                } else {
                    map.put(c, j + 1);
                }
            }
        }

        System.out.println("map = " + map);


        for (int i = 0; i < targets.length; i++) {
            String str = targets[i];
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);

                if (map.containsKey(c)) {
                    answer[i] += map.get(c);
                }else {
                    answer[i] = -1;
                    break;
                }

                System.out.println("map.get(c) = " + map.get(c));
            }
        }

        return answer;
    }
}