package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Baek1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String equation = br.readLine();
        String[] equationArr = equation.split("-");

        int ret = 0;

        for (int i = 0; i < equationArr.length; i++) {
            int sum = 0;

            String[] arr = equationArr[i].split("\\+");
            for (String num : arr) {
                sum += Integer.parseInt(num);
            }
            if (i == 0) {
                ret += sum;
            } else {
                ret -= sum;
            }
        }
        System.out.println(ret);

        // 10+20+30+40 NumberFormatException
//        int sum = 0;
//
//        for (int i = 0; i < equationArr.length; i++) {
//            if (!equationArr[i].contains("+")) {
//                sum += Integer.parseInt(equationArr[i]);
//            } else {
//                String[] arr = equationArr[i].split("\\+");
//                for (String num : arr) {
//                    sum -= Integer.parseInt(num);
//                }
//
//            }
//        }
//        System.out.println("sum = " + sum);
    }
}
