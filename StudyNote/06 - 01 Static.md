# 06 - 01 Static

------

### static 변수

------

예를 들어 다음과 같은 HouseLee 클래스가 있다고 하자.

```java
class HouseLee {
	String lastname = "이";
}

public class Main {
	public static void main(String[] args) {
		HouseLee lee1 = new HouseLee();
		HouseLee lee2 = new HouseLee();
	}
}
```

이 씨 집안을 나타내는 HouseLee 클래스이다. 위와 같은 클래스를 만들고 객체를 생성하면 객체마다 객체변수 lastname을 저장하기 위한 메모리가 별도로 할당된다. 하지만 가만히 생각해 보면 HouseLee 클래스의 lastname 은 어떤 객체이던지 동일한 값인 “이” 이어야 하지 않는가? 이렇게 항상 값이 변하지 않는 경우라면 static 사용시 메모리의 이점을 얻을 수 있다.

```java
class HouseLee {
    static String lastname = "이";
}

public class Sample {
    public static void main(String[] args) {
        HouseLee lee1 = new HouseLee();
        HouseLee lee2 = new HouseLee();
    }
}
```

위와 같이 lastname 변수에 static 키워드를 붙이면 자바는 메모리 할당을 딱 한 번만 하게 되어 메모리 사용에 이점이 있다.

> 만약 HosueLee 클래스의 lastname 값이 변경되지 않기를 바란다면 static 키워드 앞에 `final` 이라는 키워드를 붙이면 된다. final 키워드는 한 번 설정되면 그 값을 변경할 수 없다. 변경하려고 하면 오류가 발생한다.

static을 사용하는 또 한 가지 이유로 **공유** 개념을 들 수 있다. static 으로 설정하면 같은 곳의 메모리 주소만을 바라보기 때문에 static 변수의 값을 공유하게 되는 것이다.

다음의 예를 보면 더욱 명확하게 파악할 수 있을 것이다. 웹 사이트 방문시마다 조회수를 증가시키는 Counter 클래스가 다음과 같다고 가정해 보자.

```java
class Counter  {
    int count = 0;
    Counter() {
        this.count++;
        System.out.println(this.count);
    }
}

public class Sample {
    public static void main(String[] args) {
        Counter c1 = new Counter(); // 1출력
        Counter c2 = new Counter(); // 1출력
    }
}
```

이번에는 다음의 예제를 보자

```java
class Counter  {
    static int count = 0;
    Counter() {
        count++;  // count는 더이상 객체변수가 아니므로 this를 제거하는 것이 좋다.
        System.out.println(count);  // this 제거
    }
}

public class Sample {
    public static void main(String[] args) {
        Counter c1 = new Counter(); // 1출력
        Counter c2 = new Counter();  // 2 출력
    }
}
```

`int count = 0` 앞에 static 키워드를 붙였더니 count 값이 공유되어 다음과 같이 count가 증가되어 출력된다.

보통 변수의 static 키워드는 프로그래밍 시 메모리의 효율보다는 공유의 목적으로 훨씬 더 많이 사용한다.

### static 메소드

------

static 이라는 키워드가 메소드 앞에 붙으면 이 메소드는 스태틱 메소드가 된다.

```java
class Counter  {
    static int count = 0;
    Counter() {
        count++;
        System.out.println(count);
    }

    public static int getCount() {
        return count;
    }
}

public class Sample {
    public static void main(String[] args) {
        Counter c1 = new Counter();
        Counter c2 = new Counter();

        System.out.println(Counter.getCount());  // 스태틱 메서드는 클래스를 이용하여 호출
    }
}
```

Counter 클래스에 `getCount()` 라는 static 메소드가 추가되었다. 메소드 앞에 static 키워드를 붙이면 `Counter.getCount()` 와 같이 개체 생성없이 클래스를 통해 메소드를 직접 호출할 수 있다.

> 스태틱 메소드 안에서는 객체변수 접근이 불가능하다. 위 예에서는 count 변수가 static 변수이기 때문에 스태틱 메소드에서 접근이 가능하다.

보통 스태틱 메소드는 유틸리티성 메소드를 작성할 때 많이 사용된다. 예를 들어 “오늘의 날짜 구하기”, “숫자에 콤마 추가하기” 등의 메소드를 작성할 때에는 클래스 메소드를 사용하는 것이 유리하다.

다음은 날을 구하는 Util 클래스의 예이다

```java
import java.text.SimpleDateFormat;
import java.util.Date;

class Util {
    public static String getCurrentDate(String fmt) {
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        return sdf.format(new Date());
    }
}

public class Sample {
    public static void main(String[] args) {
        System.out.println(Util.getCurrentDate("yyyyMMdd"));  // 오늘 날짜 출력
    }
}
```

### 싱글톤 패턴 (Singleton Pattern)

------

이번에는 디자인 패턴 중 하나인 싱글톤에 대해서 알아보자. 여러분은 static에 대한 개념이 생겼기 때문에 싱글톤을 이해하는 것이 어렵지 않다. 싱글톤은 단 하나의 객체만을 생성하게 강제하는 패턴이다. 즉 클래스를 통해 생성할 수 있는 객체는 Only One 즉, 한 개만 되도록 만드는 것이 싱글톤이다.

```java
class Singleton {
    private Singleton() {
    }
}

public class Sample {
    public static void main(String[] args) {
        Singleton singleton = new Singleton();  // 컴파일 오류가 발생한다.
    }
}
```

위와 같은 코드를 작성하면 컴파일 에러가 발생한다. 왜냐하면 Singleton 클래스의 생성자에 pirvate 키워드로 다른 클래스에서 Singleton 클래스의 생성자로의 접근을 막았기 때문이다.이렇게 생성자를 private 으로 만들어 버리면 다른 클래스에서 Singleton 클래스를 `new` 를 이용하여 생성할 수 없게 된다.

`new`  를 이용하여 무수히 많은 객체를 생성한다면 싱글톤의 정의에 어긋나지 않겠는가? 그래서 일단 `new` 로 객체를 생성할 수 없도록 막은 것이다.

그렇다면 Singleton 클래스의 객체는 어떻게 생성할 수 있을까?

```java
class Singleton {
    private Singleton() {
    }

    public static Singleton getInstance() {
        return new Singleton();  // 같은 클래스이므로 생성자 호출이 가능하다.
    }
}

public class Sample {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
    }
}
```

위와 같이 코드를 변경하면 이제 getInstance 라는 static 메소드를 이용하여 Singleton 클래스의 객체를 생성할 수 있다. 하지만 getInstance를 호출 할 때마다 새로운 객체가 생성된다. 그렇다면 싱글톤이 아니다. 어떻게 해야 할까?

```java
class Singleton {
    private static Singleton one;
    private Singleton() {
    }

    public static Singleton getInstance() {
        if(one==null) {
            one = new Singleton();
        }
        return one;
    }
}

public class Sample {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton1 == singleton2);  // true 출력
    }
}
```

Singleton 클래스에 one 이라는 static 변수를 두고 getInstance 메소드에서 값이 null인 경우에만 객체를 생성하도록 하여 one 객체가 딱 한 번만 만들어지도록 했다.

getInstance 메소드의 동작원리를 살펴보자.

최초 getInstance가 호출 되면 one이 null 이므로 `new` 에 의해서 객체가 생성이 된다. 이렇게 한 번 생성이 되면 one은 static 변수이기 때문에 그 이후로는 null이 아니게 된다. 그런 후에 다시 getInstance 메소드가 호출되면 이제 one은 null이 아니므로 이미 만들어진 싱글톤 객체인 one을 항상 리턴한다.

main 메소드에서 getInstance를 두 번 호출하여 각각 얻은 객체가 같은 객체인지 조사해 보았다. 역시 예상대로 “true”가 출력되어 같은 객체임을 확인 할 수 있다.