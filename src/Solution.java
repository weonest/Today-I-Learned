
class Solution {
        int answer = 0;
    public int solution(int a, int b, int n) {



        getAnswer(a, b, n);

        System.out.println("answer = " + answer);
        return answer;
    }

    public void getAnswer(int a, int b, int n) {

        if (n < a) {
            return;
        }
        int tmp = (n / a) * b;
        System.out.println("tmp = " + tmp);

        int ret = tmp + (n % a);
        System.out.println("ret = " + ret);
        answer += tmp;

        getAnswer(a, b, ret);
    }


    public static void main(String[] args) {

        int a = 5;
        int b = 3;
        int n = 21;

        Solution sol = new Solution();
        sol.solution(a, b, n);

    }
}