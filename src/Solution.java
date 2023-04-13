import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];

        Map<Integer, String> map = new HashMap<>();

        int rank = 1;
        for (String val : players) {
            map.put(rank, val);
            rank++;
        }
        System.out.println("map = " + map);

        for (int i = 1; i < callings.length; i++) {

            if ()

            }

        }



        return answer;
    }

}