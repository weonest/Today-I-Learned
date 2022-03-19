# 04 - 01 객체지향 프로그래밍이란?

------

여러분 모두 계산기를 사용해 보았을 것이다. 계산기에 숫자 3을 입력하고 + 기호를 입력한 후 4를 입력하면 결괏값으로 7을 보여 준다. 다시 한 번 + 기호를 입력한 후 3을 입력하면 기존 결괏값 7에 3을 더해 10을 보여 준다. 즉 계산기는 이전에 계산한 결괏값을 항상 메모리 어딘가에 저장하고 있어야 한다.

![https://wikidocs.net/images/page/28/calc.png](https://wikidocs.net/images/page/28/calc.png)

> ※ 계산기는 이전에 계산한 결과값을 기억하고 있어야 한다.

이런 내용을 자바 코드로 구현해 보자. 계산기의 "더하기" 기능을 구현한 코드는 다음과 같다.

```java
class Calculator {
    static int result = 0;

    static int add(int num) {
        result += num;
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Calculator.add(3));
        System.out.println(Calculator.add(4));
    }
}
```

add 메소드는 매개변서 num으로 받은 값을 이전에 계산한 결과값에 더한 후 돌려주는 메소드이다. 이전에 계산한 결과값을 유지하기 위해서 result 전역 변수(static)를 사용했다.

> static 키워드는 조금 후에 자세하게 공부한다. 여기서는 변수에 저장된 값을 계속 유지하기 위해 사용되었다.

그런데 만일  Main 클래스에서 2대의 계산기가 필요한 상황이 발생하면 어떻게 해야 할까? 각 계산기는 각각의 결과값을 유지해야 하기 때문에 위와 같이 Calculator 클래스 하나만으로는 결과값을 따로 유지할 수 없다.

```java
class Calculator1 {
    static int result = 0;

    static int add(int num) {
        result += num;
        return result;
    }
}

class Calculator2 {
    static int result = 0;

    static int add(int num) {
        result += num;
        return result;
    }
}

public class Sample {
    public static void main(String[] args) {
				Calculator cal1 = new Calculator();
				Calculator cal2 = new Calculator();

        System.out.println(cal1.add(3));
        System.out.println(cal1.add(4));

        System.out.println(cal2.add(3));
        System.out.println(cal2.add(7));
    }
}
```

Calculator 클래스로 만든 별개의 계산기`cal1`, `cal2`(이것을 객체라고 부른다)가 각각의 역할을 수행한다. 그리고 계산기(cal1, cal2)의 결과값 역시 다른 계산기의 결과값과 상관없이 독립적인 값을 유지한다. 객체를 사용하면 계산기 대수가 늘어나더라도 객체를 생성만 하면 되기 때문에 클래스만을 사용하는 경우와 달리 매우 간단해진다.

만약 빼기 기능을 추가하려면 Calculator 클래스에 다음처럼 sub 메소드를 추가하면 된다.

```java
class Calculator {
    int result = 0;

    int add(int num) {
        result += num;
        return result;
    }

    int sub(int num) {
        result -= num;
        return result;
    }
}
```