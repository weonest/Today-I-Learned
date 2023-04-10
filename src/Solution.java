import java.util.Stack;

class Solution {

    public static int solution(String s) {

        Stack<Character> stack = new Stack<>();

        int idx = 0;

        while (idx < s.length()) {
            char c = s.charAt(idx);

            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            }
            else {
                stack.push(c);
            }
            idx++;
        }
        if (stack.isEmpty()) {
            return 1;
        }
        return 0;
    }
}