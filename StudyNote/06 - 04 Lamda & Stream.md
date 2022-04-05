# 06 - 04 Lamda & Stream

------

Java 8 버전부터 함수형 프로그래밍을 지원하기 위해 람다와 스트림이 도입되었다. 람다와 스트림을 사용하면 요새 유행하는 함수형 프로그래밍 스타일로 자바 코드를 작성할 수 있다.

물론 람다와 스트림을 사용하여 작성한 코드를 일반 스타일의 자바코드로 바꾸어 작성하는 것이 불가능하지는 않다. 달리 말하면 람다와 스트림 없이도 자바 코드를 작성하는데 어려움이 없다는 뜻이다. 하지만 그럼에도 불구하고 람다와 스트림을 사용하는 이유는 작성하는 코드의 양이 줄어들고 읽기 쉬운 코드를 만드는데 유리하기 때문이다.

## Lamda

------

람다는 익명 함수 (Anonymous functions)를 의미한다.

### 일반적인 코드

먼저 다음과 같은 인터페이스를 보자.

```java
interface Caculaotr {
	int sum (int a, int b);
}
```

두 개의 정수를 입력으로 받아 정수의 결과값을 리턴하는 sum 함수의 정의한 인터페이스이다. Caculator 인터페이스를 사용하려면 다음처럼 Calculator 인터페이스를 구현해야 한다.

```java
class Mycalculator implements Caculator {
	public int sum (int a , int ) {
		return a + b;
	}
}
```

Calculator 인터페이스를 구현한 MyCalculaotr 클래스를 생성하였다. 그러면 이제 MyCalculator 클래스는 다음처럼 사용할 수 있다.

```java
interface Caculator {
		int sum (int a, int b);
		}
class MyCalculator implements Caculator {
	public int sum(int a, int b) {
		return a + b;
	}
}

public class Main {
	public static void main(Stinrg[] args) {
		MyCalculator mc = new MyCalculator();
		int result = mc.sum(3, 4);
		System.out.println(result);  // 7 출력
	}
}
```

### 람다를 적용한 코드

이제 위에서 작성한 코드를 다음처럼 람다를 적용한 코드로 바꾸어 보자.

```java
interface Calculator {
	int sum(int a, int b);
}

public class Main {
		public static void main(String[] args) {
			Calculator cal = (int a, int b) -> a + b;
			int result = cal.sum(3, 4);
			System.out.println(result);
		}
}
```

`( int a , int b ) -> a + b` 괄호 사이의 int a, int b 는 Caculator 인터페이스 sum 함수의 입력항목에 해당하고 `->` 뒤의 a + b 가 리턴값에 해당한다. 이렇게 람다함수를 사용하면 MyCalculator 와 같은 실제 클래스 없이도 Calculator 객체를 생성할 수 있다.

### 인터페이스 사용시 주의사항

여기서 주의해야 할 점은 Calculator 인터페이스의 메소드가 1개 이상이면 람다 함수를 사용할 수 없다는 점이다.

```java
interface Caculator {
	int sum ( int a, int b );
	int mul ( int a, int b );  // mul 메소드를 추가하면 컴파일 에러가 발생한다.
}
```

그래서 람다 함수로 사용할 인터페이스는 다음처럼 `@FunctionalInterface` 어노테이션을 사용하는 것이 좋다. `@FunctionalInterface` 어노테이션을 사용하면 다음처럼 2개 이상의 메소드를 가진 인터페이스를 작성하는 것이 불가능해 진다.

```java
@FunctionalInterface
interface Calculator {
    int sum(int a, int b);
    int mul(int a, int b);  // @FunctionalInterface 는 두번 째 메서드를 허용하지 않는다.
}
```

### 람다 축약

람다 함수를 조금 더 축약하는 것이 가능하다.

```java
(int a , int b) -> a + b
```

인터페이스에 이미 입력값의 타입인 `int` 가 정의되어 있으므로 int는 생략이 가능.

**Interger.sum**

그리고 두 수를 더하여 그 결과를 티런하는 함수 `(a, b) -> a + b` 는 `Interger.sum(int a,int b)` 와 동일하기 때문에 다음과 같이 더 축약이 가능하다.

```java
Integer::sum
```

어떤 클래스의 메소드를 사용할 때는 위와 같이 `::` 기호를 사용하여 클래스와 메소드를 구분하여 표기한다.

```java
@FunctionalInterface
interface Calculator {
    int sum(int a, int b);
}

public class Main {
    public static void main(String[] args) {
        Calculator cal = Integer::sum;
        int result = cal.sum(3, 4);
        System.out.println(result);  // 7 출력
    }
}
```

### 람다 함수 인터페이스

이번에는 인터페이스를 생성하는 대신 함수형 프로그래밍을 위해 제공되는 인터페이스들을 사용하여 위 코드를 좀 더 축약해 보자. 자바가 제공하는 BiFunction 인터페이스를 사용하면 Calculator 인터페이스를 대신하여 다음과 같이 작성할 수 있다.

```java
import java.util.function.BiFunction;

public class Main {
	public static void main(String[] args) {
		BiFunciton<Intger, Integer, Integer> mc = (a, b) -> a + b;
		int result = mc.apply(3, 4); // sum이 아닌 applyt 메소드를 사용해야 한다.
		System.out.println(result); // 7 출력
	}
}
```

BiFunciton의 `<Integer, Integer, Integer>` 제네릭스는 순서대로 입력항목 2개, 출력항목 1개를 의미한다. 그리고 BiFunction 인터페이스의 apply 메소드를 호출하면 람다함수 `(a, b) -> a + b` 가 실행된다.

> BiFunction은 입출력 항목의 타입을 다양하게 사용할 수 있다.

그런데 우리가 작성한 코드를 자세히 보면 입출력 항목의 타입이 모두 Integer로 동일하다는 것을 알 수 있다. 이렇게 입출력 항목이 모두 동일할 경우에는 다음의 `BinaryOperator` 를 사용하여 더 간단하게 표현할 수 있다.

```java
import java.util.function.BinaryOperator;

public class Main {
	public static void main(String[] args) {
		BinaryOperator<Integer> mc = (a, b) -> a + b;
		int result = mc.apply(3, 4);
		System.out.println(result);
	}
}
```

> 자바가 람다 함수를 위해 제공하는 인터페이스는 이 외에도 상당히 많지만 여기서는 람다 함수의 이해를 목적으로 BiFunciton과 BinaryOperator에 대해서만 알아보았다.

## Stream

------

데이터가 물결처럼 흘러가면서 필터링 과정을 통해 여러 번 변경되어 반환되기 때문에 이러한 이름을 갖게 되었다.

다음의 문제를 풀어보자

**문제**

다음과 같은 정수 배열이 있다.

```java
int[] data = {5, 6, 4, 2, 3, 1, 1, 2, 2, 4, 8};
```

이 배열에서 짝수만 찾아 중복을 제거한 후에 역순으로 정렬하는 프로그램을 작성하시오.

즉, 프로그램의 수행 결과는 다음과 같아야 한다.

```java
int[] result = {8, 6, 4, 2};
```

위 문제를 해결하기 위해서는 다음처럼 코드를 작성해야 한다.

```java
package JumpToJava;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[] data = {5, 6, 4, 2, 3, 1, 1, 2, 2, 4, 8};

        ArrayList<Integer> dat = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            if (data[i] % 2 == 0) {
                dat.add(data[i]);
            }
        }
        HashSet<Integer> hasDat = new HashSet<>(dat);

        ArrayList<Integer> arrDat = new ArrayList<>(hasDat);

        arrDat.sort(Comparator.reverseOrder());

        System.out.println(arrDat);

//        // Integer 리스트를 정수 배열로 변환???
//        int[] result = new int[arrDat.size()];
//        for (int i = 0; i < arrDat.size(); i++) {
//            result[i] = arrDat.get(i);
    }
}
```

이 문제를 Sream을 사용하면 다음과 같이 해결할 수 있다.

```java
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) {
		int[] data = {5, 6, 4, 2, 3, 1, 1, 2, 2, 4, 8};
    int[] result = Arrays.stream(data)
			.boxed()  // IntStream을 Stream<Integer>로 변경한다.
      .filter((a) -> a % 2 == 0)  //  짝수만 걸러낸다.
      .distinct()  // 중복을 제거한다.
      .sorted(Comparator.reverseOrder())  // 역순으로 정렬한다.
      .mapToInt(Integer::intValue)  // Stream<Integer>를 IntStream으로 변경한다.
      .toArray()  // int[] 배열로 반환한다.
                ;
    }
}
```

위 코드는 다음과 같은 순서로 동작한다.

1. `Arrays.stream(data)`으로 정수 배열을 IntStream으로 생성한다.
2. `.boxed()` 로 IntStream을 Integer의 Stream으로 변경한다. 이렇게 하는 이유는 뒤에서 사용할 `Comparator.reverseOrder` 와 같은 메서드는 원시타입인 int 대신 Integer를 사용해야 하기 때문이다.
3. `.filter((a) -> a % 2 == 0)`로 짝수만 필터링한다. 이 때 사용한 `(a) -> a % 2 == 0` 구문은 위에서 공부한 람다 함수이다. 입력 a가 짝수인지를 조사하는 람다함수로 짝수에 해당되는 데이터만 필터링한다.
4. `.distinct()`로 스트림에서 중복을 제거한다.
5. `.sorted(Comparator.reverseOrder())`로 역순 정렬한다.
6. `.mapToInt(Integer::intValue)`로 Integer의 Stream을 IntStream으로 변경한다. 왜냐하면 최종적으로 `int[]` 타입의 배열을 리턴해야 하기 때문이다.
7. `.toArray()`를 호출하여 IntStream의 배열인 `int[]` 배열을 리턴한다.

스트림 방식은 일반적인 코드보다 확실히 간결하고 가독성이 좋다는 것을 확인할 수 있을 것이다.

> Arrays.stream 처럼 스트림을 생성하고 boxed, filter, distinct, sorted, mapToInt 처럼 스트림을 가공하고 toArray 처럼 스트림을 원하는 형태로 반환하는 방법에는 여러가지가 있다. 이 책에서는 스트림을 이해하기 위한 목적으로 몇 가지에 대해서만 알아보았다.