import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class HanteoTest3 {

    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        int[] coins = {2, 3, 5, 6};
        int sum = 10;
        List<int[]> list = Arrays.asList(coins);
        stack.push(2);
        comb(sum, coins, list);
    }

    public static void comb(int sum, int[] coins, List<int[]> list) {
        for (int i = 0; i < coins.length; i++) {
            while (stack.stream().mapToInt(Integer::intValue).sum() <= sum) {
                if (list.contains(sum % stack.stream().mapToInt(Integer::intValue).sum())) {
                    stack.push(list.indexOf(sum % stack.stream().mapToInt(Integer::intValue).sum()));
                }else {
                stack.push(coins[i]);
                System.out.println("stack = " + stack);
                }
            }
            stack.clear();
            stack.push(coins[i]);
            continue;
        }
    }
}






