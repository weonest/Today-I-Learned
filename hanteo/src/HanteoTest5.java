import java.util.*;

public class HanteoTest5 {

    static int sum = 10;
    //    static int sum = 4;
    static int answer = 0;
    static Set<String> set = new HashSet<>();
    static List<String> lis = new ArrayList<>();


    public static void main(String[] args) {
        int[] coins = {2, 3, 5, 6};
//        int[] coins = {1, 2, 3};
        int[] numbers;
//        List<Integer> list = Arrays.stream(coins).boxed().collect(Collectors.toList());
        Combination2 com = new Combination2();

//        String tmp = "";


        // 1. 숫자 한 개 or 전체를 이용하여 구현이 가능한지
        checkCondition(coins);
        System.out.println("1번 메소드 answer = " + answer);


        // 2. 1 < n < coins.length 개의 숫자를 이용하여 구현이 가능한지
        for (int i = 2; i < coins.length; i += 2) {

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
                    check += arr[j].charAt(k);
                }
                if (arrSum > sum) {
                    continue;
                } else if (sum - arrSum == 0 || arrSum*2 == sum) {
                    answer++;
                } else {
                    System.out.println("check = " + check);
                    System.out.print("arrSum = " + arrSum + ", ");
                    canDivide(coins, sum - arrSum);
//                    distinct(arr[j], coins, arrSum);
                }
            }

        }
        System.out.println("전체 답 answer = " + answer);

    }

    public static void distinct(String arr, int[] coins, int value) {
        int dis = 0;
        System.out.println("value = " + value);
        String tmp = "";

        for (int i = 0; i < coins.length; i++) {
            dis = value + coins[i];
            if (dis == sum) {
            tmp += arr + coins[i];
            lis.add(tmp);
            }
        }
        System.out.println("lis = " + lis);
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


