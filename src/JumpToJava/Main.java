package JumpToJava;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public String caesarCode(String input, int num) {

        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        List<String> list = Arrays.asList(abc.split(""));

        ArrayList<String> code = new ArrayList<>();

        for (String word : input.split("")) {
            int pos = list.indexOf(word);
            int newPos = (pos + num) % 26;   // 26 + 5 = 31

            code.add(list.get(newPos));
        }
        return String.join("", code);
    }




    public static void main(String[] args) {
        Main ma = new Main();
        System.out.println(ma.caesarCode("CAT", 5));

    }
}
