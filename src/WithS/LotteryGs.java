package WithS;

import java.util.Scanner;
import java.util.TreeSet;

public class LotteryGs {
    int HopeCnt;
    int GameCnt = 1;
    int cnt = 0;

    public int getHopeCnt() {
        return HopeCnt;
    }

    public void setHopeCnt() {
        Scanner sc = new Scanner(System.in);
        HopeCnt = sc.nextInt();
    }

    public int getGameCnt() {
        return GameCnt;
    }

    public void setGameCnt(int gameCnt) {
        gameCnt++;
        GameCnt = gameCnt;
    }

    public void doGame() {
        System.out.printf("===== %d 번째 게임  =====\n",GameCnt);
        for (int i = 0; i < getHopeCnt(); i++) {
            TreeSet<Integer> set = new TreeSet<>();

            do {
                Integer a = (int) (Math.random() * 45 + 1);
                set.add(a);
            } while (set.size() <= 5);
            cnt++;
            System.out.println(set);
            if (cnt % 5 == 0) {
                GameCnt++;
                System.out.printf("===== %d 번째 게임  =====\n",GameCnt);

            }
        }

    }

}