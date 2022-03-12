package Something;


import java.util.Scanner;
import java.util.TreeSet;

public class Lottery {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("원하시는 게임 수를 입력해 주세요 :");
        int hopeCnt = sc.nextInt();
        int cnt = 0;
        int gameCnt =1;

        System.out.printf("===== %d 번째 게임  =====\n",gameCnt);
        for (int i = 0; i < hopeCnt; i++) {
            TreeSet<Integer> set = new TreeSet<>();

            do{
                Integer a = (int)(Math.random() * 45 + 1);
                set.add(a);
            } while(set.size() <= 5);
            cnt ++;
            System.out.println(set);
            if (cnt % 5 == 0) {
                gameCnt++;
                System.out.printf("=====  %d 번째 게임  =====\n",gameCnt);
            }
        }
    }
}
