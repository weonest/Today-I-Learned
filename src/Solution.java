import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] numbers) {
        int answer = -1;

        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

        System.out.println("list = " + list);

        for (int i = 0; i < numbers.length; i++) {
            if (list.contains(numbers[i])) {
                list.remove(list.indexOf(numbers[i]));
            }
        }
        if (list.size() > 0) answer = list.stream().mapToInt(Integer::intValue).sum();

        return answer;
    }

    // 초간단 풀이..
    // return 45 - Array.stream(arr).sum();
}