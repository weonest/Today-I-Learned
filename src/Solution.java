

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {

    // 문제에서는 상자들과 섞이지 않도록 따로 둔다고 하는데
    // 배열에서 아예 없애버리면 인덱스가 맞지 않기 때문에 방문 처리를 해야함

    boolean[] visited;
    int cnt = 0;

    public int solution(int[] cards) {

        visited = new boolean[cards.length];

        List<Integer> cntList = new ArrayList<>();

        for (int i = 0; i < cards.length; i++) {
            if (visited[i]) continue; // 첫 번째 카드를 뽑는다. 방문했다면 다음 카드가 첫 번재 카드
            cnt = 1; // 위 조건에서 유효한 카드만을 뽑기 때문에 cnt = 1로 설정
            visited[i] = true;
            recursive(cards, cards[i] - 1);
            cntList.add(cnt);
        }
        System.out.println("cntList = " + cntList);

        cntList.sort(Comparator.reverseOrder());

        if (cntList.size() < 2) {
            return 0;
        } else {
            return cntList.get(0) * cntList.get(1);
        }
    }

    public void recursive(int[] cards, int idx) {
        if (visited[idx]) return;

        visited[idx] = true;
        cnt++;
        recursive(cards, cards[idx] - 1);
    }

    public static void main(String[] args) {
        int[] ex = {2, 3, 1, 4, 5, 6};
        Solution sol = new Solution();
        sol.solution(ex);
    }
}