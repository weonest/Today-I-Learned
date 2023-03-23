import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination2 {

    static String answer = "";


    static List<List<int[]>> list = new ArrayList<>();


    public static void main(String[] args) {
        int[] coins = {2, 3, 5, 6};
        int[] numbers;

        for (int i = 2; i < coins.length; i++) {
            Combination2 com = new Combination2();
            numbers = new int[i];
            System.out.println(com.comb(coins, numbers,0, 0, i));
            answer = "";
        }
    }

    public String comb(int[] coins, int[] numbers, int start, int depth, int comb_length) {
        if (depth == comb_length) {
            answer += Arrays.toString(numbers);

            System.out.println(Arrays.toString(numbers));
            return answer;
        }


        for (int i = start; i < coins.length; i++) {
            numbers[depth] = coins[i];
            comb(coins, numbers, i + 1, depth + 1, comb_length);
        }
        return answer;
    }
}

