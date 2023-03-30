import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int[] box = new int[m];
        int boxLimit = score.length / m;

        Queue<Integer> que = new LinkedList<>();

        Integer[] tmp = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(tmp, Comparator.reverseOrder());

        for (Integer i : tmp) {
            que.add(i);
        }

        for (int i = 0; i < boxLimit; i++) {
            for (int j = 0; j < box.length; j++) {
                box[j] = que.poll();
            }
            int min = Arrays.stream(box).min().orElse(0);

            answer += min * m;
        }


        return answer;
    }

    /**
     * 더 좋은 풀이
     */

    int answer = 0;
    Arrays.sort(score);
    for (int i = score.length-m; i >= 0; i-=m) {
        answer += score[i] * m;
    }

}