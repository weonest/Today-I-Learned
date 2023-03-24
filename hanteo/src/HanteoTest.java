import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class HanteoTest {

    int[] coins;
    int sum;
    int answer;


    public void solution(int sum, int[] coins) {

        answer = 0;
        this.coins = coins;
        this.sum = sum;

//        for (int i = 0; i < coins.length - 1; i++) {
//            System.out.println(" ####################### " + i);
//            dfs(i, 0, coins[i]);
//        }
        dfs(0, 0, coins[0]);

    }

    public void dfs(int idx, int depth, int tmp) {
        System.out.print("idx = " + idx + ", ");
        System.out.print("coins = " + coins[idx] + ", ");
        System.out.print("depth = " + depth + ", ");
        System.out.println("tmp = " + tmp);


        if (tmp>=sum) {
            if (tmp == sum) {
                answer++;
                System.out.println("10%2 = " + 10%3);
                System.out.println("&&&& answer &&&&& = " + answer);
            }
            return;
        }
        dfs(idx+1, depth + 1, tmp + coins[idx+1]);
        dfs(idx, depth + 1, tmp + coins[idx]);
    }


    public static void main(String[] args) {
        HanteoTest han = new HanteoTest();
        int[] arr = {2, 5, 3, 6};
        han.solution(10, arr);

    }

}
