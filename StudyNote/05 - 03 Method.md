# 05 - 03 Method

------

다른 프로그래밍 언어에는 **함수**라는 것이 별도로 존재한다. 하지만 자바는 클래스를 떠나 존재하는 것은 있을 수 없기 때문에 자바의 함수는 다로 존재하지 않고 클래스 내에 존재한다.

자바는 이러한 클래스 내의 함수를 메소드라고 부른다.

> 보통 함수와 메소드가 공존하는 언어(파이썬)에서는 두 개를 구분하여 말하기도 하지만 자바는 보통 메소드와 함수를 구분하여 말하지 않는다. 다만 자바에서 사용되는 함수의 정확한 명칭은 메소드이다.

메소드를 설명하기 전에 믹서기를 생각해 보자. 우리는 믹서기에 과일을 넣는다. 그리고 믹서를 이용해서 과일을 갈아서 과일 쥬스를 만들어 낸다. 우리가 믹서기에 넣는 과일은 입력이 되고 과일 쥬스는 그 출력(리턴값)이 된다.

그렇다면 믹서기는 무엇인가?

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/84b829f5-8096-41dc-8f87-c4bac7cc912c/Untitled.png)

믹서기가 바로 우리가 여기서 알고자 하는 메소드이다. 입력을 가지고 어떤 일을 수행한 다음에 결과물을 내놓는 것, 이것이 메소드가 하는 일이다.

## 메소드를 사용하는 이유?

------

가끔 프로그래밍을 하다 보면 똑같은 내용을 자신이 반복해서 적고 있는 것을 발견할 때가 있다. 이 때가 바로 메소드가 필요한 때이다. 여러 번 반복해서 사용된다는 것은 언제고 **또다시 사용할 만한 가치가 있는 부분이라는 뜻이다.** 즉, 이러한 경우 이것을 한 뭉치로 묶어서 “어떤 입력값을 주었을 대 어떤 리턴값을 돌려준다.” 라는 식의 메소드를 작성하는 것이 현명한 일일 것이다.

가장 간단하지만 많은 것을 설명해 주는 다음의 메소드를 보자.

```java
int sum (int a, int b) {
	return a + b;
}
```

위 메소드의 의미는 다음과 같이 정의된다.

“sum 메소드는 입력값으로 두개의 값 (int 자료형 a, int 자료형 b)을 받으며 리턴값은 두 개의 입력값을 더한 값(int 자료형)이다.”

여기서 **return**은 메소드의 **결과 값을 돌려주는 명령어**이다. 직접 위의 메소드를 만들어 보고 사용해 보자.

```java
public class Cal {
	int sum (int a, int b) {
		return a + b;
		}

public static void main(String[] args) {
	int a = 3;
	int b = 4;
	
	Cal c1 = enw Cal();
	int c = Cal.sum(a, b);

	System.out.println(c);  // 7 출력
```

## 매개변수와 인수

------

매개변수(parameter)와 인수(arguments)는 혼용해서 사용되는 헷갈리는 용어이므로 잘 기억해 두자. 매개변수는 메소드에 입력으로 전달된 값을 받는 변수를 의미하고 인수는 메소드를 호출할 때 전달하는 입력값을 의미한다.

```java
public class Cal {
    int sum(int a, int b) {  // a, b 는 매개변수 (parameter)
        return a+b;
    }

    public static void main(String[] args) {
        Cal c1 = new Cal();
        int c = sample.sum(3, 4);  // 3, 4는 인수 (arguments)

        System.out.println(c);  // 7 출력
    }
}
```

**[같은 의미를 가진 여러 가지 용어들에 주의하자]**

프로그래밍을 공부할 때 어려운 부분 중 하나가 용어의 혼용이라고 할 수 있다. 우리는 공부하면서 원서를 보기도 하고 누군가의 번역본을 보기도 하면서 의미는 같지만 표현이 다른 용어를 자주 만나게 된다. 한 예로 입력값을 다른 말로 메소드의 인수, 매개변수 등으로 말하기도 하고 결괏값을 출력값, 반환 값, 돌려주는 값 등으로 말하기도 한다. 이렇듯 많은 용어가 여러 가지 다른 말로 표현되지만 의미는 동일한 경우가 많다. 따라서 이런 용어를 기억해 놓아야 머리가 덜 아플 것이다.

## 메소드의 입력값과 리턴값

------

메소드는 들어온 입력값을 가지고 어떤 처리를 하여 적절한 리턴값을 돌려주는 블랙박스와 같다.

```java
입력값 ----> 메소드 (블랙박스) -----> 리턴값
```

메소드에 들어오는 입력값과 리턴값에 대해서 자세히 알아보도록 하자

### 메소드의 구조

자바의 메소드 구조는 아래와 같다.

```java
리턴자료형 메소드명(입력자료형1 매개변수1, 입력자료형2, 매개변수2, ...) {
...
return 리턴값; // 리턴자료형이 void 인 경우에는 return 문이 필요없다.
}
```

리턴자료형은 메소드 수행 후 돌려줄 값의 자료형을 의미한다. 메소드의 리턴값은 return 이라는 명령을 사용한다.

메소드는 입출력 유무에 따라 다음과 같이 4가지로 분류할 수 있다.

- 입력과 출력이 **모두** 있는 메소드
- 입력과 출력이 **모두 없는** 메소드
- 입력은 **없고** 출력은 있는 메소드
- 입력은 **있고** 출력은 없는 메소드

이것들에 대해서 자세히 알아보도록 하자.

### 일반적인 메소드

입력 값이 있고 리턴값이 있는 메소드가 일반적인 메소드이다.

```java
int sum(int a, int b) {
    return a+b;
}
```

- 입력값 : int 자료형 a, int 자료형 b
- 리턴값 : int 자료형

sum 메소드는 두 개의 입력값을 받아서 서로 더한 결과값을 돌려주는 메소드이다.

위처럼 입력값과 리턴값이 있는 메소드는 다음처럼 사용된다.

```java
리턴값을 받을 변수 = 객체.메소드명(입력인수1, 입력인수2, ...)
Cal c1 = new Cal();
int result = c1.sum(3,4);
```

위에서 보듯이 `c1.sum(3, 4)` 호출 후 리턴값을 저장하는 result의 자료형은 int로 해야만 한다. 왜냐하면 sum 메소드의 리턴타입이 int로 되어 있기 때문이다. sum 메소드의 리턴타입은 `int sum (int a, int b) {...` 에서 보듯이 메소드명(sum) 바로 좌측에 표기하도록 되어 있다.

### 입력값이 없는 메소드

```java
String say() {
		return "Hi";
}
```

- 입력값 - 없음
- 리턴값 - String 자료형

이 메소드는 어떻게 쓸 수 있을까?

```java
public class Main {
    String say() {
        return "Hi";
    }

    public static void main(String[] args) {
        Main m = new Main();
        String a = m.say();
        System.out.println(a);  // "Hi" 출력
    }
}
```

say 메소드를 쓰기 위해서는 `say()`처럼 괄호 안에 아무런 값도 넣지 않고 써야 한다. say 메소드는 입력값은 없지만 리턴값으로 'Hi'라는 문자열을 돌려준다. 따라서 `String a = m.say()` 처럼 하면 a에는 "Hi"라는 문자열이 대입될 것이다.

즉, 입력값이 없고 리턴값만 있는 메소드는 다음과 같이 사용된다.

```java
리턴값 받을 변수 = 객체.메소드명()
```

### 리턴값이 없는 메소드

```java
void sum(int a, int b) {
    System.out.println(a+"과 "+b+"의 합은 "+(a+b)+"입니다.");
}
```

- 입력값 - int 자료형 a, int 자료형 b
- 리턴값 - void (없음)

리턴값이 없는 메소드는 명시적으로 리턴타입 부분에 void 라고 표혀기한다. 리턴값이 없는 메소드는 돌려주는 값이 없기 때문에 다음과 같이 사용한다.

```java
public class Main {
    void sum(int a, int b) {
        System.out.println(a+"과 "+b+"의 합은 "+(a+b)+"입니다.");
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.sum(3, 4);   // 3과 4의 합은 7입니다. 출력
    }
}
```

즉, 리턴값이 없는 메소드는 다음과 같이 사용된다.

```java
객체.메소드명(입력인수1, 입력인수2, ...)
```

아마도 여러분은 다음과 같은 질문을 할지도 모른다. "3과 4의 합은 7입니다." 라는 문장을 출력해 주었는데 왜 리턴값이 없다는 것인가? 이 부분이 초보자들이 혼동스러워 하는 부분이기도 한데 `System.out.println`문은 메소드내에서 사용되어지는 문장일 뿐이다. 돌려주는 값은 당연히 없다. 돌려주는 값은 return 명령어로만 가능하다.

### 입력값도 리턴값도 없는 메소드

```java
void say() {
    System.out.println("Hi");
}
```

- 입력값 - 없음
- 리턴값 - void (없음)

입력값을 받는 곳도 없고 return문도 없으니 입력값도 리턴값도 없는 메소드이다.

이 메소드를 사용하는 방법은 **단 한가지이다.**

```java
public class Main {
    void say() {
        System.out.println("Hi");
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.say();
    }
}
```

즉, 입력값도 리턴값도 없는 메소드는 다음과 같이 사용된다.

```java
객체.메소드명()
```

## return의 또 다른 쓰임새

------

특별한 경우에 메소드를 빠져나가기를 원할 때 return을 단독으로 사용하여 메소드를 즉시 빠져나갈 수 있다. 다음 예를 보자.

```java
public class Main {
    void sayNick(String nick) {
        if ("fool".equals(nick)) {
            return;
        }
        System.out.println("나의 별명은 "+nick+" 입니다.");
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.sayNick("angel");
        m.sayNick("fool");  // 출력되지 않는다.
    }
}
```

sayNick 메소드는 입력으로 받은 문자열 값을 받아서 출력하는 메소드이다. 이 메소드 역시 리턴값은 없다. **문자열을 출력한다는 것과 리턴값이 있다는 것은 전혀 다른 말이다**. 혼동하지 말도록 하자. 메소드의 리턴값은 오로지 **return문에 의해서만 생성된다.** 이 메소드는 입력값으로 "fool" 이라는 값이 들어오면 문자열을 출력하지 않고 메소드를 즉시 빠져나간다. 이렇게 메소드 수행 시 **특정 조건에 따라 메소드를 즉시 빠져나가고 싶은 경우 return 문을 이용하면 된다**. 이 방법은 실제 프로그래밍에서 자주 쓰인다.

> return 문만을 써서 메소드를 빠져나가는 이 방법은 **리턴자료형이 void인 메소드에만 해당된다.** 리턴자료형이 명시되어 있는 메소드에서 return 문만 작성하면 **컴파일 오류가 발생**한다.

## 메소드 내에서 선언된 변수의 효력 범위

------

메소드 안에서 사용하는 변수의 이름을 메소드 밖에서 사용한 이름과 동일하게 사용한다면 어떻게 될까?

```java
public class Main {
    void varTest(int a) {
        a++;
    }

    public static void main(String[] args) {
        int a = 1;
        Main m = new Maiun()
        m.varTest(a);
        System.out.println(a);
    }
}
```

위 예제의 varTest 메소드는 입력으로 들어온 int 자료형의 값을 1만큼 증가시키는 역할을 한다.

main 메소드를 순서대로 분석해 보자.

먼저 main메소드에서 a라는 int 자료형의 변수를 생성하고 1을 대입했다. 그리고 varTest 메소드를 입력 값 a를 주어 호출했다. 그 다음에 a의 값을 출력하게 하였다. 당연히 varTest 메소드에서 a의 값을 1만큼 증가시켰으니 2가 출력되어야 할 것 같지만 프로그램을 실행시켜 보면 1이라는 결과 값이 나온다.

**그 이유는 메소드 내에서 사용되는 변수는 메소드 안에서만 쓰여지는 변수이기 때문이다**. 즉 `public void varTest(int a) {`라는 문장에서 입력 인수를 뜻하는 변수 a는 메소드 안에서만 쓰이는 변수이지 메소드 밖의 변수 a가 아니라는 말이다.

위에서 변수이름을 a로 사용한 varTest메소드는 다음처럼 변수이름을 b로 사용한 varTest와 기능적으로 완전히 동일하다.

```java
public void varTest(int b) {
    b++;
}
```

즉, 메소드에서 쓰이는 변수는 메소드 밖의 변수 이름들과는 전혀 상관 없다. 그래서 이렇게 메소드 내에서만 쓰이는 변수를 **로컬 변수**(local variable)라고도 말한다.

> ※ 만약 varTest 입력값이 int 자료형이 아닌 객체였다면 얘기가 다르다. 객체를 메소드의 입력으로 넘기고 메소드가 객체의 속성값(객체변수 값)을 변경한다면 메소드 수행 이후에도 객체는 변경된 속성값을 유지한다. 이러한 차이가 나는 이유는 메소드에 전달하는 입력 자료형의 형태 때문인데 메소드에 값을 전달하느냐 아니면 객체를 전달하느냐에 따라 차이가 난다.

그렇다면 varTest라는 메소드를 이용해서 메소드 외부의 a를 1만큼 증가시킬 수 있는 방법은 없을까?

다음과 같이 varTest 메소드와 main 메소드를 변경해 보자.

```java
public class Main {
    int varTest(int a) {
        a++;
        return a;
    }

    public static void main(String[] args) {
        int a = 1;
	      Main m = new Main();
        a = m.varTest(a);
        System.out.println(a);
    }
}
```

해법은 위 예처럼 varTest메소드에 return문을 이용하는 방법이다. varTest 메소드는 입력으로 들어온 값을 1만큼 증가시켜 리턴한다. 따라서 `a = m.varTest(a)`처럼 하면 a의 값은 다시 varTest 메소드의 리턴값으로 대입된다. (1만큼 증가된 값으로 a의 값이 변경된다.)

이번에는 아까 잠깐 언급한 객체를 넘기는 방법에 대해서 알아보자.

다음의 예를 보자.

```java
public class Sample {

    int a;  // 객체변수 a

    void varTest(Sample sample) {
        sample.a++;
    }

    public static void main(String[] args) {
        Sample sample = new Sample();
        sample.a = 1;
        sample.varTest(sample);
        System.out.println(sample.a);
    }
}
```

이전 예제에서는 a 라는 int 자료형 변수를 main 메서드에 선언했는데 위 예제에는 Sample 클래스의 객체변수로 선언했다. 그리고 varTest 메소드는 Sample 클래스의 객체를 입력받아 해당 객체의 객체변수 a의 값을 1만큼 증가시키는 역할을 하도록 수정했다. 그리고 main메소드에서는 varTest메소드에 1이라는 값을 전달하던것을 Sample 클래스의 객체인 sample을 넘기도록 수정했다.

이렇게 수정하고 프로그램을 실행시켜보면 sample객체의 객체변수 a의 값이 원래는 1이었는데 varTest 메소드 실행 후 1만큼 증가되어 2가 출력되는 것을 확인할 수 있다.

여기서 주목해야 하는 부분은 varTest 메소드의 입력 파라미터가 **값이 아닌 Sample 클래스의 객체라는데 있다**. 이렇게 메소드가 객체를 전달 받으면 메소드 내의 객체는 전달받은 객체 그 자체로 수행된다. 따라서 입력으로 전달받은 **sample 객체의 객체변수 a**의 값이 증가하게 되는 것이다.

메소드의 입력항목이 값인지 객체인지를 구별하는 기준은 입력항목의 자료형이 **primitive 자료형인지 아닌지에 따라 나뉜다.** int 자료형과 같은 primitive 자료형인 경우 값이 전달되고 그 이외의 경우**(reference 자료형)는 객체가 전달된다.**

**this 활용하기**

위 예제에는 다음과 같은 문장이 있다.

```java
sample.varTest(sample);
```

sample 객체를 이용하여 varTest라는 메소드를 호출할 경우 굳이 sample 객체를 전달할 필요가 없다. 왜냐하면 전달하지 않더라도 varTest 메소드는 this라는 키워드를 이용하여 객체에 접근할 수 있기 때문이다. this를 이용하여 varTest메소드를 수정한 버전은 다음과 같다.

```java
public class Sample {

int a;  // 객체변수 a

void varTest() {
this.a++;
    }

public static void main(String[] args) {
        Sample sample =new Sample();
        sample.a = 1;
        sample.varTest();
        System.out.println(sample.a);  // 2 출력
    }
```