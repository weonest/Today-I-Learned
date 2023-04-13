import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {

        int rank = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String s : players) {
            map.put(s, rank);
            rank++;
        }

        for (int i = 0; i < callings.length; i++) {
            int cur = map.get(callings[i]);

            map.put(callings[i], cur - 1);
            map.put(players[cur - 1], cur);

            players[cur] = players[cur - 1];
            players[cur - 1] = callings[i];
        }

        return players;
    }

}