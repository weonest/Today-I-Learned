import java.util.Arrays;

class Solution {
    int cnt = 0;
    int zeroCnt = 0;

    public int[] solution(String s) {
        int[] answer = new int[2];

        recursive(s);
        answer[0] = cnt;
        answer[1] = zeroCnt;

        return answer;
    }

    public void recursive(String s) {
        if (s.equals("1")) {
            return;
        }

        String tmp = Integer.toBinaryString(convert(s).length());
        cnt++;
        recursive(tmp);

    }

    public String convert(String s) {
        String tmp = "";
        for (String str : s.split("")) {
            if (str.equals("0")) {
                zeroCnt++;
                continue;
            }
            else {
                tmp += str;
            }
        }
        return tmp;
    }

}