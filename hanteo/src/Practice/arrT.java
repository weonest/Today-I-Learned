package Practice;

import java.util.*;

public class arrT {

    static int[] result = new int[]{0, 0, 0, 0, 0}; // 최소 값의 몫의 길이ㅇㅇ

    static int[] coins = {2, 5, 3, 6};
    //    static int[] coins = {1, 2, 3};
    static int sum = 10;
    //    static int sum = 4;
    static int total = 0;

    static int cnt = 4;

    static List<Integer> list = Arrays.asList(2, 3, 5, 6);
    static Set<Stack<Integer>> set = new HashSet<>();

    public static void main(String[] args) {


        for (int i = 0; i < list.size(); i++) {
            Stack<Integer> stack = new Stack<>();
            if (sum % list.get(i) == 0) {
                for (int j = 0; j < sum / list.get(i) - 1; j++) {
                    stack.push(list.get(i));
//                    total++;
                }
//                stack.pop();

            } else {
                for (int k = 0; k < sum / list.get(i); k++) {
                    stack.push(list.get(i));
                }
            }
            System.out.println("stack = " + stack);
            System.out.println();
            System.out.println("!@#!@#!@#재귀 진입합니다!@#!@#!@# ===" + i);
            System.out.println();

            dfs(0, stack);

        }
        System.out.println(set);

    }

    public static void dfs(int n, Stack<Integer> stack) {
        if (n == list.size()-1) {
            return;
        }

        if (stack.stream().mapToInt(Integer::intValue).sum() >= sum) {
            if (stack.stream().mapToInt(Integer::intValue).sum() == sum) {
                total++;
                System.out.println();
                System.out.println("stack 결과  = " + stack);
                System.out.println("####### 정답 올라갑니다 #######" + total);
                System.out.println();
                clear(2, stack);
            }
            clear(2, stack);

            return;
        }


        for (int i = n; i < list.size(); i++) {
            stack.push(list.get(i));
            System.out.println("stack 내부2  = " + stack);
//            dfs(n, stack);
            dfs(n + 1, stack);
        }

        System.out.println();
    }

    public static void clear(int cnt, Stack<Integer> stack) {

        while (stack.size() > cnt) {
            stack.pop();
        }

    }
}






