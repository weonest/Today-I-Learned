import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class arrT {

    static int[] result = new int[] {0, 0, 0, 0, 0}; // 최소 값의 몫의 길이ㅇㅇ

    static int[] coins = {2, 5, 3, 6};
    static int sum = 10;
    static int total = 0;

    public static void main(String[] args) {

    }

    public void dfs(int start, int n) {
        for (int i = start; i < coins.length; i++) {
            result[i] = coins[i];
            total += result[i];

            for (int j = 0; j < coins.length; j++) {

            }

        }

    }
}






