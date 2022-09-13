package programmers;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class NQueen {
    /*
     * 문제 설명
     *가로, 세로 길이가 n인 정사각형으로된 체스판이 있습니다. 체스판 위의 n개의 퀸이 서로를 공격할 수 없도록 배치하고 싶습니다.
     * 예를 들어서 n이 4인경우 다음과 같이 퀸을 배치하면 n개의 퀸은 서로를 한번에 공격 할 수 없습니다.
     *
     */   //1, 3, 0, 2
//        0,X,0,0 // set = 0,
//        0,0,0,X // if(set.contains(previous) || Math.abs(j - i) == 1 ? continue : set.add(current);
//        X,0,0,0  // temp - 1 < 0 계산 X
//        0,0,X,0 //
    public void solution(int n) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        int[] temp = new int[n]; // 1,3,0,2 , 2,0,3,1
        for (int i = 0; i < n; i++) {
            int index = 0;
            temp[index] = i;
            isPossible(i, temp);
            index++;
            }

    }
    // 0, 0, 0, 0
    // temp[0] = 0;
    public void isPossible(int pre, int[] temp) {
        int sum = 0;

        for (int i = 0; i < temp.length; i++) {

            if (temp[pre] == i) {

            }

            if (temp[pre] != temp[i] && Math.abs(pre - i) != 1) {

            }
        }
    }
}
