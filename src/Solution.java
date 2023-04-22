import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);


        for (int i = 0; i < phone_book.length - 1; i++) {
            String cur = phone_book[i];
            String nex = phone_book[i + 1];

            if (cur.length() > nex.length()) {
                continue;
            } else if (nex.substring(0, cur.length()).equals(cur)) {
                answer = false;
                return answer;
            }
        }
        return answer;
    }
}