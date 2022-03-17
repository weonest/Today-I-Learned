# 05 - 02 Class

------

클래스에 대해서 자세히 알아보자.

여기서는 클래스에 대한 개념적인 설명을 하기보다는 가장 간단한 클래스를 작성하는 것에서부터 시작하여 조금씩 클래스의 규모를 키워가는 방식으로 클래스를 설명해 볼까 한다.

### 객체에 대하여

------

Animal 클래스를 다음과 같이 [Main.java](http://Main.java) 파일에 작성하자.

```java
class Animal {
}

public class Main {
    public static void main(String[] args) {
    }
}
```

> Animal 클래스를 [Main.java](http://Main.java) 파일에 작성한 것은 원활한 설명을 위해서이다. 보통 클래스는 특별한 경우가 아니라면 파일 단위로 하나씩작성한다. 즉, 위의 경우에 Animal 클래스는 [Animal.java](http://Animal.java) 파일에 단독으로 작성하는 것이 일반적인 방법이다.

위 Animal 클래스는 가장 간단한 형태의 클래스이다. 클래스의 선언만 있고 내용이 없는 껍데기뿐인 클래스이다. 하지만 이 껍데기뿐인 클래스도 아주 중요한 기능을 가지고 있다. 그 기능은 **객체(object)를 만드는 기능**이다.

객체는 다음과 같이 만들 수 있다.

```java
class Animal {
}

public class Main {
    public static void main(String[] args) {
        Animal cat = new Animal();
    }
}
```

`new` 는 객체를 생성할 때 사용하는 키워드이다. 이렇게 하면 Animal 클래스의 인스터는(instance)인 cat, 즉 Animal의 객체가 만들어진다.

**객체와 인스턴스**

클래스의 의해서 만들어진 객체를 인스턴스라고도 한다. 그렇다면 객체와 인스턴스의 차이는 무엇일까?

이렇게 생각해 보자. `Animal cat = new Animal()` 이렇게 만들어진 cat은 객체이다. 그리고 cat 이라는 객체는 Animal의 **인스턴스(instance)** 이다. 인스턴스라는 말은 특정 객체(cat)가 어떤 클래스(Animal)의 객체인지를 관계위주로 설명할 때 사용된다. **즉, “cat은 인스턴스” 보다는 “cat”은 객체” 라는 표현이 “cat은 Animal의 객체” 보다는 “cat은 Animal의 인스턴스” 라는 표현**이 훨씬 잘 어울린다.

### 객체 변수 (Instance varible)

------

Animal 이라는 껍데기 클래스를 조금 더 발전시켜 보자. Animal 클래스에 의해 만들어진 동물에 이름을 지어보자.

```java
class Animal {
    String name;
}

public class Main {
    public static void main(String[] args) {
        Animal cat = new Animal();
    }
}
```

Animal 클래스에 name 이라는 String 변수를 추가했다. 이렇게 클래스에 선언된 변수를 **객체 변수** 라고 한다. 객체 변수는 인스턴스 변수, 멤버 변수, 속성이라고도 한다.

> 클래스에 의해 생성되는 것은 객체, 그리고 그 클래스에 선언된 변수는 객체 변수라고 생각하면 쉽다.

객체 변수를 만들었으니 이제 객체 변수를 사용해 보자. 먼저 객체 변수는 변수이므로 값을 대입할 수 있을 것이다. 대입하기 전에 객체 변수는 현재 어떤 값을 가지고 있는지 먼저 출력해 보자.

객체 변수를 출력하려면 객체 변수에 어떻게 접근해야 하는지를 먼저 알아야 한다. 객체 변수는 다음과 같이 도트연산자`(.)` 를 이용하여 접근할 수 있다.

즉, `Animal cat = new Animal()` 처럼 cat 이라는 객체를 생성했다면 이 cat 객체의 객체 변수 name에는 다음과 같이 접근할 수 있다.

```java
cat.name // 객체 : cat, 객체 변수 : name
class Animal {
    String name;
}

public class Main {
    public static void main(String[] args) {
        Animal cat = new Animal();
        System.out.println(cat.name);
    }
}
```

`[cat.name](<http://cat.name>)` 을 출력한 결과값으로 null 이 나왔다. null은 값이 할당되어 있지 않은 상태를 말한다.

객체 변수로 name을 선언했지만 아무런 값도 대입을 하지 않았기 때문에 null이라는 값이 출력된 것이다.

### 메소드

------

이제 객체변수에 접근하는 방법과 현재 값이 할당되어 있지 않은 상태에 대해서 알게 되었다. 이제 객체 변수에 값을 대입하는 방법에 대해서 알아보자. 객체 변수에 값을 대입하는 방법에는 여러가지가 있지만 여기서는 가장 보편적인 메소드를 이용하는 방법에 대해서 알아보자.

클래스에는 객체 변수와 더불어 **메소드 (Method)** 라는 것이 있다. 메소드는 클래스 내에 구현된 함수를 의미하는데 보통 함수라고 말하지 않고 메소드라고  말한다.

이제 메소드를 이용하여 Animal 클래스의 객체 변수인 name에 값을 대입해 보자.

```java
class Animal {
    String name;

    public void setName(String name) {
        this.name = name;
    }
}

public class Main {
    public static void main(String[] args) {
        Animal cat = new Animal();
        System.out.println(cat.name);
    }
}
```

Animal 클래스에 추가된 setName 메소드는 다음과 같은 형태의 메소드이다.

- 입력 : String name
- 출력 : void (리턴값 없음)

즉, 입력으로 name이라는 문자열을 받고 출력은 없는 형태의 메소드이다.

이번에는 setName 메소드의 내부를 살펴보자. setName 메소드는 다음의 문장을 가지고 있다.

```java
this.name = name;
```

이 문장에서 `this` 에 대해서 이해하는 것은 꽤 중요하다. 이 문장에 대한 설명은 잠시 보류하고 일단은 우선 이 메소드를 호출 하는 방법에 대해서 알아보자. 객체 변수에 접근하기 위해서 `객체.변수` 와 같이 도트연산자로 접근할 수 있었던 것과 마찬가지로 객체가 메소드를 호출하기 위해서는 `객체.메소드` 로 호출해야 한다.

즉, 우리가 만든 setName 메소드를 호출하려면 다음과 같이 호출해야 한다.

```java
cat.setNAme("Dari");
```

여기서 setName 메소드의 입력으로 “Dari”와 같은 문자열을 전달해야 한다. 왜냐하면 setName 메소드는 입력항목으로 문자열을 필요로 하기 때문이다.

setName 메소드를 호출할 수 있도록 main 메소드를 다음과 같이 수정해 보자.

```java
class Animal {
    String name;

    public void setName(String name) {
        this.name = name;
    }
}

public class Main {
    public static void main(String[] args) {
        Animal cat = new Animal();
        cat.setNAme("Dari");  // 메소드 호출
        System.out.println(cat.name);
    }
}
```

이렇게 수정하면 `[cat.name](<http://cat.name>)` 을 출력하기 전에 setName 메소드가 먼저 호출될 것이다.

main 메소드에서 `cat.setName(”Dari”)` 와 같이 “Dari”  라는 입력값으로 setName 메소드를 호출했기 때문에 setName 함수의 입력항목 name 에는 “Dari” 라는 문자열이 전달될 것이다.

따라서 setName 메소드의 `this.name = name;` 문장은 다음과 같이 해석되어 질 것이다.

```java
this.name = "Dari";
```

setName 메소드 내부에 사용된 `this` 는 Animal 클래스에 의해서 생성된 객체를 지칭한다. 만약 `Animal cat = new Animal()` 과 같이 cat 이라는 객체를 만들고 `cat.setName("Dari")` 와 같이 cat 객체에 의해 setName 메소드를 호출하면 setName 메소드 내부에 선언된 this는 바로 cat 객체를 지칭한다.

> 만약 `Animal dog = new Animal()` 로 dog 개체를 만든 후 `dog.setName("Happy")` 와 같이 호출한다면 setName 메소드 내부에 선언된 this는 바로 dog 객체를 가리킨다.

따라서 `this.name = "Dari";` 문장은 다시 다음과 같이 해석된다.

```java
cat.name = "Dari";
```

`cat.naem` 과 같이 하면 객체 변수에 접근할 수 있음을 우리는 알고 있다. 객체 변수에 값을 대입하는 방법은 아주 쉽다. 그냥 변수에 값을 대입하는 것과 마찬가지이다.

```java
객체.객체변수 = 값
```

따랏 `cat.name = "Dari"` 라는 문장은 객체 cat 의 객체변수 name에 “Dari” 라는 값을 대입한다.

### 객체 변수는 공유되지 않는다

------

```java
class Animal {
    String name;

    public void setName(String name) {
        this.name = name;
    }
}

public class Main {
    public static void main(String[] args) {
        Animal cat = new Animal();
        cat.setName("Dari");

        Animal dog = new Animal();
        dog.setName("happy");
    }
}
```

cat 객체에는 “Dari”라는 이름을 대입하고 dog 객체에는 “happy”라는 이름을 대입했다. 이렇게 하면 setName 메소드에 의해 다음과 같은 문장이 두 번 실행될 것이다.

```java
cat.name = "Dari";
dog.name = "happy";
```

이럴 경우 `dog.name = "happy"` 라는 문장이 나중에 수행되므로 [cat.name](http://cat.name) 의 값도 “happy”라는 값으로 변경되지는 않을까? Animal 클래스의 객체 변수 name이 cat 객체와 dog 객체간 서로 공유되는 변수라면 아마도 그럴 것이다. 하지만 결과를 보면 다음과 같다.

```java
class Animal {
    String name;

    public void setName(String name) {
        this.name = name;
    }
}

public class Main {
    public static void main(String[] args) {
        Animal cat = new Animal();
        cat.setName("Dari");  // 메소드 호출

        Animal dog = new Animal();
        dog.setName("happy");

        System.out.println(cat.name);         // Dari 출력
        System.out.println(dog.name);         // happy 출력
    }
}
```

**이 부분은 정말 너무너무 중요하다.** 클래스에서 가장 중요한 부분은 그 뭐라해도 이 객체 변수의 값이 독립접으로 유진된다는 점이다. 사실 이 점이 바로 클래스 존재의 이유이기도 하다. 객체 지향적 (Obeject Oriented)이라는 말의 의미도 곱씹어 보면 결국 이 객체 변수의 값이 독립적으로 유지되기 때문에 가능한 것이다.

> 객체 변수의 값은 공유되지 않지만 나중에 알게될 static을 이용하게 되면 객체 변수를 공유하도록 만들 수도 있다.