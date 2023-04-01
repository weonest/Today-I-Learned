class Solution {
    public String solution(int[] food) {
        String answer = "";


        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < food.length; i++) {
            int tmp = food[i];

            if (tmp < 1) continue;

            if (tmp % 2 == 1) {
                tmp = tmp - 1;
            }
            tmp /= 2;

            for (int j = 0; j < tmp; j++) {
                sb.append(i);
            }


        }
        answer += sb + "0";
        answer += sb.reverse();

        System.out.println("sb = " + sb);

        return answer;
    }
}