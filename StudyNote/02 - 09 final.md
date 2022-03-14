# 02 - 09 형변환과 final

------

자바에서 사용하는 주요 자료형에 대해서 공부했다. 이번에는 자료형간의 타입을 변환하는 방법과 한번 설정한 값을 변경하지 못하게 하는 방법에 대해서 알아보자.

### 형변환

------

다음과 같은 문자열을 보자.

```java
String num = "123";
```

자료형은 문자열이지만 그 내용은 숫자로 이루어진 값이다. 이럴 경우에 문자열을 정수 (Integer)로 바꿀수 있다. 문자열을 정수로 바꾸려면 다음과 같이 Integer 클래스를 사용해야 한다.

> Integer는 int 자로형의 Wrapper 클래스이다.

```java
public class Main {
	public static void main(String[] args] {
		String num = "123";
		int n = Integer.parseInt(num);
		System.out.println(n);  // 123 출력
	}
}
```

이번에는 반대로 정수 123을 문자열 “123”으로 바꾸는 방법에 대해서 알아보자. 정수를 문자열로 바꾸는 가장 쉬운 방법은 정수 앞에 빈문자열(`""`)을 더해주는 것이다.

```java
public class Sample {
    public static void main(String[] args) {
        int n = 123;
        String num = "" + n;
        System.out.println(num);  // 123 출력
    }
}
```

또는 다음과 같이 변환할 수도 있다.

```java
public class Main {
	public static void main(String[] args) {
		int n = 123;
		String num1 = String.valueOf(n);
		String num2 = Integer.toString(n);
		System.out.println(num1);  // 123 출력
		System.out.println(num2);  // 123 출력
	}
}
```

실제 프로젝트에서 정수와 문자열 사이의 변환은 매우 자주 사용한다.

그리고 소숫점이 포함되어 있는 숫자형태의 문자열은 마찬가지 방법으로

`Double.parseDouble` 또는 `Float.parseFloat` 를 사용하여 형변환할 수 있다.

```java
public class Main {
    public static void main(String[] args) {
        int n1 = 123;
        double d1 = n1;.  // 정수를 실수로 바꿀때에는 캐스팅이 필요없다.
        System.out.println(d1);  // 123.0 출력

        double d2 = 123.456;
        int n2 = (int) d2;. // 실수를 정수로 바꿀때에는 반드시 정수형으로 캐스팅해 주어야 한다.
        System.out.println(n2);  // 소숫점이 생략된 123 출력
    }
}
```

실수를 정수로 변환하면 실수의 소숫점은 제거된다.

그리고 실수 형태의 문자열을 정수로 변경하려고 하면 NumberFormatException이 발생하므로 주의해야 한다.

```java
public class Main {
	public static void main(String[] args) {
		String num = "123.456";
		int n = Integer.parseInt(num);  // 실수 형태의 문자열을 정수로 변환할 경우 NumberFormatException이 발생
		}
}
```

### final

------

자바의 final은 자료형에 값을 단 한 번만 설정할 수 있게 강제하는 키워드이다. 즉, 값을 한 번 설정하면 그 값을 다시 설정할 수 없다.

```java
public class Sample {
    public static void main(String[] args) {
        final int n = 123;  // final 로 설정하면 값을 바꿀수 없다.
        n = 456;  // 컴파일 에러 발생
    }
}
```

리스트의 경우도 final로 선언시 재할당은 불가능하다.

```java
import java.util.ArrayList;
import java.util.Arrays;

public class Sample {
    public static void main(String[] args) {
        final ArrayList<String> a = new ArrayList<>(Arrays.asList("a", "b"));
        a = new ArrayList<>(Arrays.asList("c", "d"));  // 컴파일 에러 발생
    }
}
```

final은 프로그램 수행 도중 그 값이 변경되면 안되는 상황에 사용한다.

Unmodifiable List

리스트의 경우 final로 선언시 리스트에 값을 더하거나 빼는 것은 가능하다. 다만 재할당만 불가능할 뿐이다. 만약 그 값을 더하거나 빼는 것도 불가능하게 하고 싶은 경우에는 `List.of` 로 수정이 불가능한 리스트(Unmodifiable List)를 생성해야 한다.