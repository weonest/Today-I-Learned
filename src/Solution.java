import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        if (check(s)) {
            answer++;
        }

        for (int i = 1; i < s.length(); i++) {
            System.out.println(i);
            s = rotate(s);
            if (check(s)) {
                answer++;
            }
        }

        return answer;
    }

    public String rotate(String s) {
        s = s.substring(1) + s.charAt(0);
        return s;
    }

    public boolean check(String s) {
        Stack<Character> stack = new Stack<>();
        // ({})[]

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                switch (c) {
                    case ')':
                        compare(stack, '(');
                        break;
                    case '}':
                        compare(stack, '{');
                        break;
                    case ']':
                        compare(stack, '[');
                        break;
                }
            } else {
                stack.push(c);
            }
            System.out.println("stack = " + stack);
        }
        return stack.isEmpty();

    }

    public void compare(Stack<Character> stack, char c) {
        if (stack.peek() == c) {
            stack.pop();
        }
    }
}