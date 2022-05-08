package JumpToJava.smallProject1;

import java.util.ArrayList;

public class Packet {
    private ArrayList<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        this.items.add(item);
    }

    public Item getItem(int index) {
        return this.items.get(index);
    }

    public String raw() {
        StringBuffer result = new StringBuffer();
        for (Item item : items) {
            result.append(item.raw());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Packet packet = new Packet();

        Item item1 = new Item();
        item1.setName("이름");
        item1.setLength(20);
        item1.setValue("원건희");

        Item item2 = new Item();
        item2.setName("전화번호");
        item2.setLength(11);
        item2.setValue("01077590672");

        packet.addItem(item1);
        packet.addItem(item2);

        System.out.println("[" + packet.raw() + "]");
    }
}
