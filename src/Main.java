import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {


    public static void main(String[] args) throws IOException {
        int sum = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            Stack<Character> stack = new Stack<>();
            String bracket = br.readLine();

            for (int j = 0; j < bracket.length(); j++) {
                char cur = bracket.charAt(j);

                if (cur == '(') {
                    stack.push(cur);
                } else if (!stack.isEmpty() && cur == ')') {
                    if (stack.peek() == ')'){
                        continue;
                    }
                    stack.pop();
                } else {
                    stack.push(cur);
                }
            }
            if (stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }
}
 