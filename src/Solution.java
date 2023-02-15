
import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> list = new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<>();
        for (String term : terms) {
            String[] temp = term.split(" ");
            int date = Integer.parseInt(temp[1]) * 28;
            map.put(temp[0], date);
        }

        String[] todaySplited = today.split("\\.");
        int todayYear = Integer.parseInt(todaySplited[0]);
        int todayMonth = Integer.parseInt(todaySplited[1]);
        int todayDate = Integer.parseInt(todaySplited[2]);

        int index = 0;
        for (String data : privacies) {
            String[] temp = data.split(" ");
            String term = temp[1];
            String[] dataSplited = temp[0].split("\\.");
            int dataYear = Integer.parseInt(dataSplited[0]);
            int dataMonth = Integer.parseInt(dataSplited[1]);
            int dataDate = Integer.parseInt(dataSplited[2]);

            int diff = 0;
            diff += (todayYear - dataYear) * (28 * 12);
            diff += (todayMonth - dataMonth) * 28;
            diff += (todayDate - dataDate);

            System.out.println(diff + " " + map.get(term));

            if (map.get(term) <= diff) {
                list.add(index + 1);
            }

            index++;
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}