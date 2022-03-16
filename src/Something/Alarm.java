package Something;

import java.util.Scanner;

public class Alarm {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int m = sc.nextInt();

        AlarmSet al = new AlarmSet();

        al.setTime(t);
        al.setMinute(m);

        System.out.println("알람 설정 시각은 " + al.getTime () + ":" + al.getMinute() + " 입니다.");

        if(!al.isRing()){
            al.setRing(true);
        }


    }
}
