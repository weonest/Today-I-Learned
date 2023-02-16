import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";

        if (checkMethod(cards1, cards2, goal) == true && checkMethod(cards2, cards1, goal) == true) {
            answer = "Yes";
        } else {
            answer = "No";
        }
        return answer;
    }

    public boolean checkMethod(String[] arr, String[] arr2, String[] target) {
        boolean flag = true;
        List<String> tmp = new ArrayList<>(Arrays.asList(target));
        System.out.println("tmp = " + tmp);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < tmp.size(); j++) {
                if (arr[i].equals(tmp.get(j))) {
                    tmp.remove(j);
                }
            }
        }
        for (int i = 0; i < tmp.size(); i++) {
            if (tmp.get(i).equals(arr2[i])) {
                continue;
            } else {
                System.out.println("다릅니다");
                flag = false;
            }
        }
        return flag;
    }

    /**
     * class Solution {
     *     public String solution(String[] cards1, String[] cards2, String[] goal) {
     *         List<String> card1Ary = new ArrayList<>(Arrays.asList(cards1));
     *         List<String> card2Ary = new ArrayList<>(Arrays.asList(cards2));
     *
     *         String answer = "Yes";
     *         for(String str:goal) {
     *             if(!card1Ary.isEmpty() && card1Ary.get(0).equals(str)) {
     *                 card1Ary.remove(0);
     *             } else if(!card2Ary.isEmpty() && card2Ary.get(0).equals(str)) {
     *                 card2Ary.remove(0);
     *             } else {
     *                 answer = "No";
     *                 break;
     *             }
     *         }
     *         return answer;
     *     }
     * }
     */

    public static void main(String[] args) {

        String[] cards1 = {"i", "water", "drink"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};

        Solution sol = new Solution();
        System.out.println(sol.solution(cards1, cards2, goal));
    }
}