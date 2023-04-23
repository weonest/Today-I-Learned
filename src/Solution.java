
import java.util.Arrays;
import java.util.Comparator;

class Solution {

    public String solution(int[] numbers) {
        String answer = "";

        String[] arr = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        if (arr[0].equals("0")) {
            return "0";
        }

        for (String s : arr) {
            answer += s;
        }

        return answer;

    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] numbers = {6, 2 , 10};

        sol.solution(numbers);
    }
}