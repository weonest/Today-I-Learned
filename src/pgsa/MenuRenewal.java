package pgsa;

import java.util.*;

class MenuRenewal {

    Map<String, Integer> map = new HashMap<>();
    List<String> courseMenu = new ArrayList<>();
    boolean[] visited;

    public List<String> solution(String[] orders, int[] course) {
        String[] answer = {};

        for (int i = 0; i < orders.length; i++) {
            char[] cur = orders[i].toCharArray();
            Arrays.sort(cur);
            orders[i] = String.valueOf(cur);
        }

        for (int len : course) {
            for (String order : orders) {
                visited = new boolean[order.length()];
                combination("", order, 0, len);
            }

            if (!map.isEmpty()) {
                int max = 0;
                for (String key : map.keySet()) {
                    max = Math.max(max, map.get(key));
                }
                if (max > 1) {
                    for (String key : map.keySet()) {
                        if (map.get(key) == max)
                            courseMenu.add(key);
                    }
                }
                map.clear();
            }
        }
        Collections.sort(courseMenu);
        return courseMenu;
    }

    void combination(String menu, String order, int start, int len) {
        if (menu.length() == len) {
            map.put(menu, map.getOrDefault(menu, 0) + 1);
            return;
        }

        for (int i = start; i < order.length(); i++) {
            visited[i] = true;
            combination(menu + order.charAt(i), order, i + 1, len);
            visited[i] = false;
        }
    }
}