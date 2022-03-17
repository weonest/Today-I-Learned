# 04 - 04 Call by value

------

메소드에 값(primitive type)을 전달하는 것과 객체(reference type)를 전달하는 것에는 큰 차이가 있다. 이것은 매우 중요하기 때문에 이전에 잠깐 언급했지만 다시 한 번 자세히 알아보자.

결론부터 얘기한다면 메소드로 객체를 전달할 경우 메소드에서 객체의 객체 변수(속성) 값을 변경할 수 있다.

```java
class Updater {
	void update (int count) {
		count++;
	}
}

class Counter {
	int count = 0; // 객체 변수
}

public class Main {
	public static void main(String[] args) {
		Counter myCounter = new Counter();
		System.out.println("before update:" + myCounter.count);  // 0 출력
		Updater myUpdater = new Updater();
		myUpdater.update(myCounter.count);
		System.out.println("after update:" + myCounter.count);   // 0 출력
	}
}
```

Updater 클래스는 전달받은 숫자를 1만큼 증가시키는 updater라는 메소드를 가지고 있다. Counter 클래스는 count 라는 객체 변수를 가지고 있다. Main 클래스의 main 메소드는 Couner 클래스에 의해 생성된 객체의 객체 변수 count의 값을 Updater 클래스를 이용하여 증가시키려고 시도하는 예제이다.

하지만 실행하면 두 출력문 모두 0이 출력된다.

객체 변수 count의 값을 update메소드에 넘겨서 변경시키더라도 값에 변화가 없다. 그 이유는 이전 챕터에서 알아본 것과 같이 update 메소드는 값(int 자료형)을 전달받았기 때문이다.

이제 예제를 다음과 같이 변경해 보자.

```java
class Updater {
    void update(Counter counter) {
        counter.count++;
    }
}

class Counter {
    int count = 0;  // 객체변수
}

public class Main{
    public static void main(String[] args) {
        Counter myCounter = new Counter();
        System.out.println("before update:"+myCounter.count);   // 0 출력
        Updater myUpdater = new Updater();
        myUpdater.update(myCounter);
        System.out.println("after update:"+myCounter.count);    // 1 출력
    }
}
```

이전 예제와의 차이점은 update 메소드의 입력항목이다. 이전에는 `int count` 와 같이 값을 전달받았다면 지금은 `Counter counter` 와 같이 객체를 전달받도록 변경한 것이다.

update 메소드를 호출하는 부분도 바뀌었다.

**이렇게 메소드의 입력으로 전달받는 경우에는 메소드가 입력받은 객체를 그대로 사용하기 때문에 메소드가 객체의 속성값을 변경하면 메소드 수행 후에도 객체의 변경된 속성값이 유지된다.**