class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];

        for (int i = 0; i < arr.length; i++) {
            answer = answer * arr[i] / gcd(answer, arr[i]);
        }


        return answer;
    }

    // 1. 최대 공약수를 구하는 식 만들기

    public int gcd(int x, int y) {
        int gcd = 0;
        for (int i = x; i > 0; i--) {
            if (x % i == 0 && y % i == 0) {
                gcd = i;
                break;
            }
        }
        return gcd;
    }
}


//    public int solution(int[] arr) {
//        int answer = arr[0];
//
//        for (int i = 0; i < arr.length; i++) {
//
//            int gcd = gcd(answer, arr[i]); // 최대공약수
//            answer = answer * arr[i] / gcd;
//        }
//        return answer;
//    }
//
//    public static int gcd(int a, int b) {
//
//        int x = Math.max(a, b);
//        int y = Math.min(a, b);
//
//        while (x % y != 0) { // 나머지가 0이 될 때까지
//            int r = x % y;
//            x = y;
//            y = r;
//        }
//        return y;
//    }