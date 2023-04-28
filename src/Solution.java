import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;


class Solution {

    class Number{
        int num;
        int idx;

        public Number(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        Arrays.fill(answer, -1);

        Stack<Number> stack = new Stack<>();

        for (int i = 0; i < numbers.length; i++) {
            if (stack.isEmpty()) {
                stack.push(new Number(numbers[i], i));
                continue;
            }

            while (!stack.empty() && numbers[i] > stack.peek().num) {
                Number top = stack.pop();
                answer[top.idx] = numbers[i];
            }
            stack.push(new Number(numbers[i], i));

        }

        return answer;
    }
}