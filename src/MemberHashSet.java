import java.util.HashSet;
import java.util.Iterator;

public class MemberHashSet {

    private HashSet<Member> hashSet;

    public MemberHashSet() {
        hashSet = new HashSet<>();

    }

    // 멤버 한명 추가
    public void addMember(Member member) { //멤버가 매개변수로 넘온다.
        hashSet.add(member);
    }

    public boolean removeMember(int memberID) {
        // 한명한명 봐야하디 Iterator사용

        Iterator iter = hashSet.iterator();
        if (iter.hasNext()) {
            Member member = (Member) iter.next();
            if (member.getMemberID() == memberID) {
                hashSet.remove(member);
                return true;
            }
        }
        System.out.println(memberID + "번호가 존재하지 않습니다.");
        return false;
    }

    public void showAllMember() {
        for (Member member : hashSet) {
            System.out.println(member);

        }
        System.out.println();
    }

}
