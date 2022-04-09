package JumpToJava;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //65,45,2,3,45,8
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        String[] arr = s.split(",");

        List<Integer> list = new ArrayList<>();

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            list.add(Integer.parseInt(arr[i]));
        }

        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        System.out.println(sum);
    }
}