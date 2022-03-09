public class MemberHashSetTest {
    public static void main(String[] args) {

        MemberHashSet manager = new MemberHashSet();

        Member memberWeon = new Member(100, "원건희");
        Member memberBaek = new Member(200, "백승한");
        Member memberHong = new Member(300, "홍미림");
        Member memberHong2 = new Member(300, "홍미림2");
        Member memberBan = new Member(400, "반달");

        manager.addMember((memberWeon));
        manager.addMember((memberBaek));
        manager.addMember((memberHong));
        manager.addMember((memberHong2));
        manager.addMember((memberBan));

        manager.showAllMember();
        manager.removeMember(100);
        manager.showAllMember();

    }
}
