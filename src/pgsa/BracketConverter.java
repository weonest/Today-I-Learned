package pgsa;

import java.util.Stack;

public class BracketConverter {

    public String solution(String p) {

        String answer = dfs(p);
        return answer;
    }

    static String dfs(String b) {
        // step 1
        if (b.length() == 0) return "";

        // step 2
        String u = "", v = "";
        stepTwo(u, v, b);

        // step 3
        if(isRightBracket(u)) return u + dfs(v);

        return stepFour(u, v);

    }

    static void stepTwo(String u, String v, String p) {
        int idx = 2;
        while(true) {
            u = p.substring(0, idx);
            v = p.substring(idx, p.length());
            if (v.equals("") || isBalBracket(v))
                break;
            idx += 2;
        }
    }

    static String stepFour(String u, String v) {
        String tmp = "(";
        tmp += dfs(v);
        tmp += ")";

        u = u.substring(1, u.length()-1);

        for(char c : u.toCharArray()) {
            if (c == '(') tmp += ')';
            else tmp += '(';
        }
        return tmp;
    }

    static boolean isBalBracket(String str) {
        int open = 0;
        for (char c : str.toCharArray()) {
            if (c == '('){
                open++;
            }else {
                open--;
            }
        }
        return open == 0;
    }

    static boolean isRightBracket(String str) {
        if (str.charAt(0) == ')') return false;
        Stack<Character> stack = new Stack<>();
        stack.add(str.charAt(0));

        for (int i = 1; i < str.length(); i++) {
            char cur = str.charAt(i);
            if (!stack.isEmpty() && cur ==')') {
                stack.pop();
                continue;
            }

            if (cur == '(') {
                stack.add(cur);
            }
        }
        if (stack.isEmpty()) return true;
        return false;

    }
}
