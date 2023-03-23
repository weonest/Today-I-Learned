import java.util.*;
import java.util.stream.Collectors;

public class HanteoTest4 {

    static int sum = 10;
    static int answer = 0;


    public static void main(String[] args) {
        Set<int[]> set = new HashSet<>();
        int[] coins = {2,3, 5, 6};
        int[] numbers;
//        List<Integer> list = Arrays.stream(coins).boxed().collect(Collectors.toList());
        Combination2 com = new Combination2();

//        String tmp = "";


        // 1. 숫자 한 개 or 전체를 이용하여 구현이 가능한지
        checkCondition(coins);
        System.out.println("1번 메소드 answer = " + answer);


        // 2. 1 < n < coins.length 개의 숫자를 이용하여 구현이 가능한지
        for (int i = 2; i < coins.length; i+=2) {

            numbers = new int[i];

            // 주어진 coins 배열의 조합 구하기
            String str = com.comb(coins, numbers, 0, 0, i).replaceAll("\\[", "").replaceAll("\\]", " ").replaceAll(", ", "");
            System.out.println("tmp = " + str);
            String[] arr = str.split(" ");
            System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
            Combination2.answer = "";


            // 구한 조합을 바탕으로 sum 만들기
            System.out.println();
            System.out.println("***************** 내부 for문 진입 ****************");
            System.out.println();

            for (int j = 0; j < arr.length; j++) {
                int arrSum = 0;
                int check = 0;
                for (int k = 0; k < arr[j].length(); k++) {
                    arrSum += arr[j].charAt(k) - 48;

                }
                if (arrSum > sum) {
                    continue;
                } else if (sum - arrSum == 0) {
                    answer++;
                } else {
                    System.out.print("arrSum = " + arrSum + ", ");
                    canDivide(coins, sum - arrSum);
                }
            }

        }
        System.out.println("전체 답 answer = " + answer);

    }

    public static boolean canDivide(int[] coins, int value) {
        boolean flag = false;
        for (int i = 0; i < coins.length; i++) {
            if (value % coins[i] == 0) {
                System.out.println("value = " + value);
                answer++;
                flag = true;
            }
        }
        return flag;
    }

    public static void checkCondition(int[] coins) {
        for (int i = 0; i < coins.length; i++) {
            int tmp = 0;
            tmp += coins[i];

            if (sum % coins[i] == 0 || tmp == sum) {
                answer++;
            }
        }
    }

}


