import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];


        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();

        for (int i = 0; i < wallpaper.length; i++) {
            String[] str = wallpaper[i].split("");

            for (int j = 0; j < str.length; j++) {
                if (str[j].equals("#")) {
                    x.add(j);
                    y.add(i);
                }
            }
        }
        x.sort(Comparator.naturalOrder());
        y.sort(Comparator.naturalOrder());

        answer[0] = y.get(0);
        answer[1] = x.get(0);
        answer[2] = y.get(y.size() - 1) + 1;
        answer[3] = x.get(x.size() - 1) + 1;

        System.out.println("x = " + x);
        System.out.println("y = " + y);


        return answer;
    }
}