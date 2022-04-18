package JumpToJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice {
    public static void main(String[] args) {
        String str = "0123456";
        List<String> list = Arrays.asList(str.split(""));
        System.out.println(list.size());
    }
}