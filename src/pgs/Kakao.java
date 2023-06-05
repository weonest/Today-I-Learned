package pgs;

public class Kakao implements Login {
    String name = "카카오";

    @Override
    public void login() {
        System.out.println("카카오에 로그인 합니다.");
    }


    public void kakaoTalk() {
        System.out.println("카카오톡을 이용합니다.");
    }
}