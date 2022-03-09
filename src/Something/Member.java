package Something;

public class Member {

    private int memberID;
    private String memberName;


           // 생성자
    public Member(int memberID, String memberName) {
        this.memberID = memberID;
        this.memberName = memberName;
    }
// getter , setter
    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

//           클래스를 출력하는 오버라이딩
    public String toString() { // String toString 여기 뭐지?
        return memberName + "회원님의 아이디는 " + memberID + "입니다.";
    }

    // Set 에서 중복을 방지하려면  MemberID 값이 같으면 true로 리턴 , hashCode도 정의해줘야한다.
    @Override
    public boolean equals(Object obj) {
        Member member = (Member) obj; // 다운캐스팅
        if (member.memberID == memberID) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return memberID;
    }
}
