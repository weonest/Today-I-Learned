package JumpToJava;

public class Password {
    //    field
    final static int ALPHABETS_SIZE = 26;
    final int initNum = 65;
    char[] upperCaseArr;

    //    method

    //   char형의 알파벳 리스트를 생성하는 메소드
    public char[] getAlphabets() {
        upperCaseArr = new char[ALPHABETS_SIZE];

        for (int i = 0; i < ALPHABETS_SIZE; i++) {
            upperCaseArr[i] += (char) initNum + i;
        }
        return upperCaseArr;
    }

    // 생성한 알파벳 배열이 정상 배열인지 검증
    public void printAlphabets() {
        for (char c : upperCaseArr) {
            System.out.print(c + " ,");
        }
    }

    void setCaesarPassword(String input, int index) {
        upperCaseArr = getAlphabets();

        index = index % ALPHABETS_SIZE;

        // "CAT" -> "HFY"
        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; j < upperCaseArr.length; j++) {
                input = input.replaceAll(String.valueOf(input.charAt(i)), String.valueOf(upperCaseArr[j + index]));
            }
            System.out.println(input);
        }
    }
}
