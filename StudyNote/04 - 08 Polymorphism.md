# 04 - 08 Polymorphism

------

객체지향 프로그래밍의 **특징 중에는 다형성(Polymorphism)**이 있다.

이전 챕터에서 작성한 [Main.java](http://Main.java) 파일에 다음과 같은 Bounce(경비원) 클래스를 추가해 보자.

```java
interface Predator {
    ... (생략) ...
}

class Animal {
    ... (생략) ...
}

class Tiger extends Animal implements Predator {
    ... (생략) ...
}

class Lion extends Animal implements Predator {
   ... (생략) ...
}

class ZooKeeper {
    ... (생략) ...
}

class Bouncer {
    void barkAnimal(Animal animal) {
        if (animal instanceof Tiger) {
            System.out.println("어흥");
        } else if (animal instanceof Lion) {
            System.out.println("으르렁");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Tiger tiger = new Tiger();
        Lion lion = new Lion();

        Bouncer bouncer= new Bouncer();
        bouncer.barkAnimal(tiger);
        bouncer.barkAnimal(lion);
    }
}
```

경비원 클래스는 동물을 짖게하여 건물을 지킨다고 한다.

barkAnimal 메소드는 입력으로 받은 animal 객체가 Tiger의 객체인 경우에는 “어흥”을 출력하고 Lion 객체인 경우에는 “으르렁”을 출력한다. `instanceof` 는 어떤 객체가 특정 클래스의 객체인지를 조사할 때 사용되는 자바의 내장 명령어이다. `animal instanceof Tiger` 는 “animal 객체는 Tiger 클래스로 만들어진 객체인가?”를 묻는 조건문이다.

**IS-A**

barkAnimal 메소드의 입력자료형은 Tiger나 Lion이 아닌 Animal 이다. 하지만 barkAnimal 메소드를 호출할 때는 tiger또는 lion 객체를 전달할 수가 있다. 이게 가능한 이유는 Tiger, Lion 클래스가 Animal 이라는 부모 클래스를 상속한 자식 클래스이기 때문이다. 자식 클래스에 의해서 만들어진 객체는 언제나 부모 클래스의 자료형으로 사용할 수가 있다. (이전에 공부했던 IS-A 관계를 떠올려 보자.)

즉, 다음과 같은 코딩이 가능하다.

```java
Animal tiger = new Tiger();  // Tiger is a Animal
Animal lion = new Lion();   // Lion is a Animal
```

여러분은 이 Bouncer 클래스의 barkAnimal 메소드가 마음에 드는가? Crocodile, Leopard 등의 클래스가 추가되면 barkAnimal 메소드는 다음처럼 수정되어야 할 것이다.

> 아래코드는 예시이니 눈으로만 보고 실제로 코딩하지는 말자.

```java
class Bouncer {
    void barkAnimal(Animal animal) {
      if (animal instanceof Tiger) {
            System.out.println("어흥");
        } else if (animal instanceof Lion) {
            System.out.println("으르렁");
        } else if (animal instanceof Crocodile) {
	          System.out.println("쩝쩝");
        } else if (animal instanceof Leopard) {
	          System.out.println("캬옹");
        }
    }
}
```

위오 같은 방식은 동물 클래스가 추가될 때마다 분기문이 추가되어야 하므로 좋지 않다. 하지만 우리는 인터페이스를 배웠으므로 좀 더 나은 해법을 찾을 수 있다.

다음처럼 Barkable 인터페이스를 작성하고 Tiger 클래스와 Lion 클래스가 Barkable 인터페이스를 구현하도록 변경해 보자.

```java
interface Predator {
    ... (생략) ...
}

interface Barkable {
    void bark();
}

class Animal {
    ... (생략) ...
}

class Tiger extends Animal implements Predator, Barkable {
    public String getFood() {
        return "apple";
    }

    public void bark() {
        System.out.println("어흥");
    }
}

class Lion extends Animal implements Predator, Barkable {
    public String getFood() {
        return "banana";
    }

    public void bark() {
        System.out.println("으르렁");
    }
}

class ZooKeeper {
    ... (생략) ...
}

class Bouncer {
    void barkAnimal(Barkable animal) {  // Animal 대신 Barkable을 사용
        animal.bark();
    }
}

public class Sample {
    ... (생략) ...
}
```

인터페이스는 위에서 보듯이 콤마(,)를 이용하여 여러개를 implements 할 수 있다. Tiger, Lion 클래스는 Predaotr 인터페이스와 Barkable 인터페이스를 implements 하였다. 따라서 Tiger, Lion 클래스는 bark 메소드를 위와 같이 구현해야 한다. 이렇게 Tgier, Lion 클래스에 bark 메소드를 구현하면 Bouncer 클래스의 barkAnimal 메소드를 위처럼 수정할 수 있다.

다음은 barkAnimal 메소드의 바뀌기 전과 바뀐 후의 모습이다.

바뀌기 전

```java
void barkAnimal(Animal animal) {
    if (animal instanceof Tiger) {
        System.out.println("어흥");
    } else if (animal instanceof Lion) {
        System.out.println("으르렁");
    }
}
```

바뀐 후

```java
void barkAnimal(Barkable animal) {
    animal.bark();
}
```

barkAnimal 메소드의 입력 자료형이 Animal 에서 Barkable 로 변경되었다. 그리고 animal 의 객체 타입을 체크하여 “어흥” 또는 “으르렁”을 출력하던 부분을 그냥 bark 메소드를 호출하도록 변경했다. 이렇게 변경했더니 복잡하던 조건 분기문도 사라지고 누가봐도 명확한 코드가 되었다.

놀랍지 않은가!

> 폴리모피즘을 이용하면 위의 예에서 보듯이 복잡한 형태의 분기문을 간단하게 처리할 수 있는 경우가 많다.

위 예제에서 사용한 tiger, lion 객체는 각각 Tiger, Lion 클래스의 객체이면서 Animal 클래스의 객체이기도 하고 Barkable, Predator 인터페이싀 객체이기도 하다. 이러한 이유로 barkAnimal 메소드의 입력 자료형을 Animal 에서 Barkable로 바꾸어 사용할 수 있는 것이다.

이렇게 하나의 객체가 여러개의 자료형 타입을 가질 수 있는 것을 객체지향 세계에서는 **다형성(Polymorphism)이라고 한다.**

즉, Tiger 클래스의 객체는 다음과 같이 여러가지 자료형으로 표현할 수 있다.

```java
Tiger tiger = new Tiger();  // Tiger is a Tiger
Animal animal = new Tiger();   // Tiger is a Animal
Predaotr predator = new Tiger();  // Tiger is Predator
Barkable barkable = new Tiger();  // Tgier is a Barkable
```

여기서 알아두어야 할 사항은 Predator 로 선언된 predator 객체와 Barkable 로 선언된 barkable 객체는 사용할 수 있는 메소드가 서로 다르다는 점이다. predator 객체는 `getFood()` 메소드가 선언된 Predator 인터페이스의 객체이므로 getFood 메소드만 호출이 가능하다. 이와 마찬가지로 Barkable 로 선언된 barkable 객체는 bark 메소드만 호출이 가능하다.

만약 getFood 메소드와 bark 메소드를 모두 사용하고 싶다면 어떻게 해야 할까?

Predator, Barkable 인터페이스를 구현한 Tiger 로 선언된 tiger 객체를 그대로 사용하거나 다음과 같이 getFood, bark 메소드를 모두 포함하는 새로운 인터페이스를 새로 만들어 사용하면 된다.

```java
interface Predator {
    ... (생략) ...
}

interface Barkable {
void bark();
}

interface BarkablePredator extends Predator,Barkable {
}

... (생략) ...
```

기존의 인터페이스를 상속하여 BarkablePredator를 만들었다. 위와 같이 하면 BarkablePredator는 Predator의 getFood 메소드, Barkable의 bark 메소드를 그대로 사용할 수 있다. 인터페이스는 일반 클래스와는 달리 **extends** 를 이용하여 여러개의 인터페이스(Predator, Barkable)를 동시에 상속할 수 있다. 즉, 다중 상속이 지원된다.

> ※ 일반 클래스는 단일상속만 가능하다.

Lion 클래스를 위에서 작성한 BarkablePredator 인터페이스를 구현하도록 수정 해 보자.

```java
... (생략) ...

class Lion extends Animal implements BarkablePredator {
public String getFood() {
return "banana";
    }

public void bark() {
        System.out.println("으르렁");
    }
}

... (생략) ...
```

이렇게 Lion클래스를 수정하고 Bouncer 클래스를 실행하더라도 역시 다음과 같이 동일한 결과값이 출력되는 것을 확인 할 수 있다.

```java
어흥
으르렁
```

Bouncer 클래스의 barkAnimal 메소드의 입력 자료형이 Barkable이더라도 BarkablePredator를 구현한 lion객체를 전달 할 수 있다. 그 이유는 BarkablePredator는 Barkable 인터페이스를 상속받은 자식 인터페이스이기 때문이다. 자식 인터페이스로 생성한 객체의 자료형은 부모 인터페이스로 사용하는 것이 가능하다. 자식 클래스의 객체 자료형을 부모 클래스의 자료형으로 사용가능하다는 점과 동일하다.

다음은 지금까지 진행했던 전체 소스코드이다.

```java
interface Predator {
    String getFood();

default void printFood() {
        System.out.printf("my food is %s\\n", getFood());
    }

int LEG_COUNT = 4;  // 인터페이스 상수

static int speed() {
return LEG_COUNT * 30;
    }
}

interface Barkable {
void bark();
}

interface BarkablePredator extends Predator,Barkable {
}

class Animal {
    String name;

void setName(String name) {
        this.name = name;
    }
}

class Tiger extends Animal implements Predator,Barkable {
public String getFood() {
return "apple";
    }

public void bark() {
        System.out.println("어흥");
    }
}

class Lion extends Animal implements BarkablePredator {
public String getFood() {
return "banana";
    }

publicvoid bark() {
        System.out.println("으르렁");
    }
}

class ZooKeeper {
void feed(Predator predator) {
        System.out.println("feed " + predator.getFood());
    }
}

class Bouncer {
void barkAnimal(Barkable animal) {
        animal.bark();
    }
}

public class Main {
public static void main(String[] args) {
        Tiger tiger =new Tiger();
        Lion lion =new Lion();

        Bouncer bouncer =new Bouncer();
        bouncer.barkAnimal(tiger);
        bouncer.barkAnimal(lion);
    }
}
```