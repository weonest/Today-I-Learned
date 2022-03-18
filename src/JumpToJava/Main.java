interface Predator {
    String getFood();

    default void printFood() {
        System.out.printf("my food is %s\n", getFood());
    }
}

class Animal {
    String name;

    void setName(String name) {
        this.name = name;
    }

    void getFood(){
    }
}

class Tiger extends Animal {
    public void getFood() {
        System.out.println("apple");
    }
}

class Lion extends Animal  {
    public void getFood() {
        System.out.println("banana");
    }
}

class ZooKeeper {
    void feed(Animal animal) {  // 호랑이가 오면 사과를 던져 준다.
        animal.getFood();
    }
}


public class Main {
    public static void main(String[] args) {
        ZooKeeper zooKeeper = new ZooKeeper();
        Tiger tiger = new Tiger();
        Lion lion = new Lion();
        zooKeeper.feed(tiger);
        zooKeeper.feed(lion);
    }
}


