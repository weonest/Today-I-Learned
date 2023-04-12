import java.util.Arrays;

class Solution {
    int n = 0;
    
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        this.n = n;

        for (int i = 0; i < n; i++) {
            String bin1 = Integer.toBinaryString(arr1[i]);
            String bin2 = Integer.toBinaryString(arr2[i]);

            String cod1 = plusLength(bin1);
            String cod2 = plusLength(bin2);

            String row = "";

            for (int j = 0; j < n; j++) {
                String cur1 = cod1.charAt(j) + "";
                String cur2 = cod2.charAt(j) + "";

                if (cur1.equals("1") || cur2.equals("1")) {
                    row += "#";
                }else{
                    row += " ";
                }
            }
            answer[i] = row;

        }

        return answer;
    }

    public String plusLength(String bin) {
        if (bin.length() != n) {
            String zero = "";
            for (int i = 0; i < n - bin.length(); i++) {
                zero += "0";
            }
            bin = zero + bin;
        }
        return bin;
    }
}