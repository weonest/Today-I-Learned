public class Member {

    private int memberID;
    private String memberName;

    public Member() {
    }

    public Member(int memberID, String memberName) {
        this.memberID = memberID;
        this.memberName = memberName;
    }

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

    public String toString() { // String toString 여기 뭐지?
        return memberName + "회원님의 아이디는 " + memberID + "입니다.";
    }

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
