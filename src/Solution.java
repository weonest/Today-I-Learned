import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int sum = brown + yellow;

        int sqrt = (int) Math.sqrt(sum);

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= sqrt; i++) {
            if (sum % i == 0) {
                list.add(i);
                    list.add(sum / i);
            }
        }
        System.out.println("list = " + list);

        for (int i = 0; i < list.size(); i+=2) {
            int tmp = list.get(i);
            for (int j = 1; j < list.size(); j+=2) {
                if (tmp + list.get(j) - 2 == brown / 2) {
                    answer[0] = list.get(j);
                    answer[1] = list.get(i);
                }
            }
        }

        return answer;
    }
}