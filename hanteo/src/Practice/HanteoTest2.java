package Practice;

import java.util.*;

public class HanteoTest2 {

    int[] coins;
    int sum;
    int answer;



    Stack<Integer> stack = new Stack<>();

    public void solution(int sum, int[] coins) {
        answer = 0;
        this.coins = coins;
        this.sum = sum;


        for (int i = 0; i < 1; i++) {
            stack.add(coins[i]);
            dfs(0, 0, coins[i]);
            stack.clear();
        }

    }

    int cnt = 0;


    public void dfs(int idx, int depth, int tmp) {

        if (tmp >= sum) {
            if (tmp == sum) {
                answer++;
            }
            return;
        }

        for (int i = 0; i < coins.length; i++) {
            cnt = depth+1;

            if (i == coins.length - 1) {
                cnt--;
            }

            stack.add(depth + 1, coins[i]);

            if (stack.size() > sum/coins[i]) {
                stack.pop();
                if (coins.length-1 == i || stack.get(stack.size())-1 == 6) {
                    stack.set(stack.size() - 1, 0);
                }
            }
            dfs(i, depth + 1, tmp + coins[i]);
        }

    }


    public static void main(String[] args) {
        HanteoTest2 han = new HanteoTest2();
        int[] arr = {2, 5, 3, 6};
        Arrays.sort(arr);
        han.solution(10, arr);

    }

}
