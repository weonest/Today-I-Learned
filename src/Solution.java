import java.util.Arrays;
import java.util.NoSuchElementException;

class Solution {
    public String solution(String s) {
        String answer = "";

        String[] arr = s.split(" ");

        int[] nums = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();

        int min = Arrays.stream(nums).map(x -> x).min().orElseThrow(NoSuchElementException::new);

        int max = Arrays.stream(nums).map(x -> x).max().orElseThrow(NoSuchElementException::new);


        return answer += min + " " + max;
    }
}