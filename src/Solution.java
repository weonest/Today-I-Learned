
class Solution {
    int solution(int[][] land) {
        int answer = 0;


        int[][] d = new int[land.length][land[0].length];

        for (int i = 0; i < 4; i++) {

            d[0][i] = land[0][i];


        }
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                for (int k = 0; k < land[i].length; k++) {
                    if (j==k) continue;

                    d[i][j] = Math.max(d[i][j], d[i - 1][k] + land[i][j]);
                }

            }
        }
        int max = 0;
        for (int i = 0; i < d[0].length; i++) {
            max = Math.max(max, d[d.length - 1][i]);
        }
        answer = max;


        return answer;
    }
}