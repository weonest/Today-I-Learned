package JumpToJava;

public class test {
    public static void main(String[] args) {
        // 알파벳은 총 26자임.
        Password p = new Password();
//        p.printAlphabets();

        System.out.println(5 % 26);
        p.setCaesarPassword("CAT", 5);
    }
}