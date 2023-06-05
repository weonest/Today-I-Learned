package pgs;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        /**
         * String의 equals() 메소드와 마찬가지로 인스턴스를 확인한 후 캐스팅을 해주면 사용 가능
         */
        Login[] logArr = new Login[2];

        Logout logNaver = new Naver();
        Login logKakao = new Kakao();

//        logArr[0] = logNaver;
        logArr[1] = logKakao;

        Naver naver = new Naver();
        Kakao kakao = new Kakao();
        User u = new User();

        u.loginDomain(naver);
        u.loginDomain(kakao);


        System.out.println(logNaver.name);
        System.out.println(naver.name);

        System.out.println("logNaver = " + logNaver.name);
        System.out.println("logKakao = " + logKakao.name);

        String s = " ";


    }
}
