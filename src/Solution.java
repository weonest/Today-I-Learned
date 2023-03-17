class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        StringBuffer sb = new StringBuffer();

        int[] XX = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        //          1  0  0  0  0  0  2  0  0  0
        //          1  0  1  0  1  0  2  0  0  0

        int[] YY = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < X.length(); i++) {
            XX[X.charAt(i) - 48] += 1;
        }
        for (int i = 0; i < Y.length(); i++) {
            YY[Y.charAt(i) - 48] += 1;
        }

        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < Math.min(XX[i], YY[i]); j++) {
                sb.append(i);
            }
        }
        if (sb.toString().equals("")) {
            return "-1";
        } else if (sb.toString().charAt(0) == '0') {
            return "0";
        } else {
            return sb.toString();
        }
    }
}
