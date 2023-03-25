package Practice;

import java.util.*;

public class Combination {

    static int[] coins = {2, 3, 5, 6};
    static int[] numbers;
    static String answer = "";

    static List<List<int[]>> list = new ArrayList<>();


    public static void main(String[] args) {
        int[] coins = {2, 3, 5, 6};
        int[] numbers;

        for (int i = 2; i < coins.length; i++) {
            Combination com = new Combination();
            numbers = new int[i];
            System.out.println(com.comb(0, 0, i));
            String neo = answer.replaceAll("\\[", "").replaceAll("\\]", " ").replaceAll(", ", "");
            System.out.println("neo = " + neo);
            answer = "";
        }
    }

    public String comb(int start, int depth, int comb_length) {
        if (depth == comb_length) {
            answer += Arrays.toString(numbers);
            System.out.println(Arrays.toString(numbers));
            return answer;
        }


        for (int i = start; i < coins.length; i++) {
            numbers[depth] = coins[i];
            comb(i + 1, depth + 1, comb_length);
        }
        return answer;
    }
}

