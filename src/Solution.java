import java.util.*;

class Solution {

    public List<Integer> solution(String msg) {
        List<Integer> answer = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();

        int init = 65;

        for (int i = 0; i < 26; i++) {
            map.put(String.valueOf((char) init), i + 1);
            init++;
        }

        lzw(map, answer, msg);


        return answer;
    }

    public void lzw(Map<String, Integer> map, List<Integer> list, String msg) {

        for (int i = 0; i < msg.length(); i++) {
            String cur = msg.substring(0, i + 1);

            if (!map.containsKey(cur)) {
                map.put(cur, map.size() + 1);
                list.add(map.get(msg.substring(0, i)));
                lzw(map, list, msg.substring(i));
                break; // 한 번만 확인하면 끝이기 때문
            } else if (i + 1 == msg.length()) {
                list.add(map.get(cur));
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.solution("KAKAO");
    }
}