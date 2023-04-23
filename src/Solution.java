import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < moves.length; i++) {

            for (int j = 0; j < board[0].length; j++) {
                int target = board[j][moves[i] - 1];

                if (target > 0) {
                    board[j][moves[i] - 1] = 0;
                    if (!stack.isEmpty() && stack.peek() == target) {
                        answer += 2;
                        stack.pop();
                    } else {
                        stack.push(target);
                    }
                    break;
                }
            }

        }

        return answer;
    }
}