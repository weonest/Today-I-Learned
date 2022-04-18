package JumpToJava;

import java.util.Arrays;
import java.util.List;

public class Main{

    public static void main(String[] args) {

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        List<String> list = Arrays.asList(alphabet.split(""));

        String tmp = "CAT";

        List<String> list2 = Arrays.asList(alphabet.split(""));

        System.out.println(list.contains("C"));


        


    }
}