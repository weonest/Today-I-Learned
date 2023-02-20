import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

class Solution {

    public int solution(int[] ingredient) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for (int value : ingredient) {
            stack.push(value);

            if (stack.size() >= 4) {

                if (stack.get(stack.size() - 4) == 1
                        && stack.get(stack.size() - 3) == 2
                        && stack.get(stack.size() - 2) == 3
                        && stack.get(stack.size() - 1) == 1) {

                    System.out.println("stack = " + stack);
                    answer++;
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                }

            }

        }
        return answer;
    }


    public static void main(String[] args) {

        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        Solution sol = new Solution();
        sol.solution(ingredient);
    }
}
/**
 * class Solution {
 * static int answer = 0;
 * <p>
 * public int solution(int[] ingredient) {
 * <p>
 * String ingre = "";
 * <p>
 * for (Integer value : ingredient) {
 * ingre += value;
 * }
 * <p>
 * makeBurger(ingre);
 * <p>
 * return answer;
 * }
 * <p>
 * public String makeBurger(String ingre) {
 * <p>
 * String remainIngredient = "";
 * <p>
 * if (ingre.length() < 4) {
 * return "end";
 * }
 * <p>
 * int target = ingre.indexOf("1231");
 * <p>
 * if (!ingre.contains("1231")) {
 * return "end";
 * } else if (ingre.contains("1231")) {
 * answer++;
 * remainIngredient += ingre.substring(0, target);
 * remainIngredient += ingre.substring(target + 4, ingre.length());
 * }
 * makeBurger(remainIngredient);
 * return remainIngredient;
 * }
 */
