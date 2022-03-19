interface Predator {
    String getFood();

    default void printFood() {
        System.out.printf("my food is %s\n", getFood());
    }
    int legCount = 4;

    static int speed() {
        return legCount * 30;
    }
}

interface Barkable {
    void bark();
}

interface BarkablePredator extends Predator,Barkable{

}

class Animal {
    String name;
    void setName(String name) {
        this.name = name;
    }
}

class Tiger extends Animal implements BarkablePredator {
    public String getFood() {
        return "apple";
    }
    public void bark(){
        System.out.println("어흥");
    }
}

class Lion extends Animal implements BarkablePredator {
    public String getFood() {
        return "banana";
    }
    public void bark(){
        System.out.println("으르렁");
    }
}

class ZooKeeper {
    void feed (Predator predator) { // 호랑이가 오면 사과를 던져 준다.
        System.out.println("feed : " + predator.getFood() );
    }
}

class Bouncer {
    void barkAnimal(Barkable animal) {
        animal.bark();
    }
}

public class Main {
    public static void main(String[] args) {
        ZooKeeper zk = new ZooKeeper();
        Tiger tiger = new Tiger();
        Lion lion = new Lion();
        Bouncer bouncer = new Bouncer();

        bouncer.barkAnimal(tiger);
        zk.feed(tiger);
        zk.feed(lion);
        tiger.bark();
    }
}
