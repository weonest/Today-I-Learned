import java.util.HashMap;
import java.util.Map;

class Solution {
    Position left;
    Position right;
    Position pos;

    public String solution(int[] numbers, String hand) {

        StringBuilder answer = new StringBuilder();

        left = new Position(3, 0);
        right = new Position(3, 2);

        for (int i : numbers) {
            pos = new Position((i - 1) / 3, (i - 1) % 3);
            if (i == 0) pos = new Position(3, 1);

            String finger = pos.getFinger(hand);

            answer.append(finger);

            if (finger.equals("L")) {
                left = pos;
            } else {
                right = pos;
            }
        }

        return answer.toString();
    }

    class Position {
        int row;
        int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public String getFinger(String hand) {
            String finger = hand.equals("right") ? "R" : "L";

            if (this.col == 0) finger = "L";
            else if (this.col == 2) finger = "R";
            else {
                int leftGap = left.getGap(this);
                int rightGap = right.getGap(this);

                if (leftGap < rightGap) {
                    finger = "L";
                } else if (leftGap > rightGap) {
                    finger = "R";
                }
            }
            return finger;
        }

        public int getGap(Position pos) {
            return Math.abs(this.row - pos.row) + Math.abs(this.col - pos.col);
        }

    }

}