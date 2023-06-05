package pgs;

public class Naver extends Logout implements Login {
    String name = "네이버";

    @Override
    public void login() {
        System.out.println("네이버에 로그인 합니다.");

    }

    public void naverSports() {
        System.out.println("네이버 스포츠에 접속합니다.");
    }
}


