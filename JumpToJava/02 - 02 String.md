# 02 - 02 문자열 (String)

------

자바에서 문자열을 나타내는 자료형은 String 이다.

```java
String a = "Happy Java";   // 리터럴 표기
String b = "a";
String c = "123";

String a = new String("Happy Java");   // 객체 표기?
String b = new String("a");  
String c = new String("123");
```

`new` 키워드는 객체를 만들 때 사용한다.

> “객체”에 대해서는 우선 “새로 생성된 자료형” 정도의 의미라고만 알고 있도록 하자.

보통 문자열을 표현할 때는 가급적 리터럴 표기를 사용하는 것이 좋다. **가독성에 이점이 있고 컴파일 시 최적화에 도움을 주기 때문이다.**

> **리터럴 표기**

> `String a = "happy java"` 와 `String a = new String("happy java")`는 같은 값을 갖게 되지만 완전히 동일하지는 않다. 첫번째 방식을 리터럴(literal) 표기라고 하는데 객체 생성없이 고정된 값을 그대로 대입하는 방법을 말한다. 위 예에서 리터럴 표기법은 "happy java" 라는 문자열을 intern pool 이라는 곳에 저장하고 다음에 다시 동일한 문자열이 선언될때는 cache 된 문자열을 리턴한다. 두번째 방식은 항상 새로운 String 객체를 만든다.

## 원시(Primitive) 자료형

------

이전에 살펴보았던 int, long, double, float, boolean, char 등을 자바는 원시 자료형이라고 부른다. 이런 primitive 자료형은 `new` 키워드로 그 값을 생성할 수 있다.

primitive 자료형은 다음과 같이 리터럴(literal)로만 값을 세팅할 수 있다.

```java
boolean result = true;
char capitalC = 'C';
int num = 123124;
```

여기서 기억해 둘 것이 있다. String 은 “Happy Java”와 같이 리터럴로 표기가 가능하지만 primitive 자료형은 아니다. **String은 리터럴 표현식을 사용할 수 있도록 자바에서 특별 대우 해주는 자료형**이다.

> **원시 자료형의 Wrapper 클래스**

> int, long, double, float, boolean, char 등의 원시 자료형은 다음처럼 각각에 대응하는 Wrapper 클래스들이 존재한다.

| 원시자료형 | Wrapper 클래스 |
| ---------- | -------------- |
| int        | Integer        |
| long       | Long           |
| double     | Double         |
| float      | Float          |
| boolean    | Boolean        |
| char       | Char           |

앞으로 공부할 ArrayList, HashMap, HashSet 등은 데이터 저장 시 **원시 자료형 대신 그에 상응하는 Wrapper 클래스들을 사용**해야 한다. 원시 자료형 대신 Wrapper 클래스를 사용하면서 **값 대신 객체를 주고 받을 수 있어 코드를 객체 중심적으로 작성하는데 유리**하다. 또한 멀티스레딩 환경에서 동기화를 지원하기 위해서는 Wrapper 클래스가 반드시 필요하다.

## 문자열 내장 메소드

------

String 자료형의 내장 메소드 중에서 자주 사용되는 것들에 대해서 알아보자.

### **equals**

두개의 문자열이 동일한지를 비교하여 결과값을 리턴한다.

다음의 예를 보자.

```java
String a = "ha";
String b = "ho";
System.out.println(a.equals(b)); // false 출력
```

문자열 a와 문자열 b는 “ha”와 “ho”로 서로 같지 않다. 따라서 equals 메소드 호출 시 false 를 리턴한다.

문자열의 값을 비교할 때는 반드시 equals를 사용해야 한다. `==` 를 사용해서 비교할 경우 다음과 같은 경우가 발생할 수 있다.

```java
String a = "hello";
String b = new String("hello");
System.out.println(a.equals(b)); // true
System.out.println(a == b);     // false 
```

모두 “hello”로 같은 값이지만 a와 b는 서로 다른 객체이다. `==` 는 두개의 자료형이 동일한 객체인지를 판별할 때 사용하는 연산자이기 때문에 false를 리턴한다.

### **indexOf**

문자열에서 특정 문자가 시작되는 위치(index)를 리턴한다.

```java
String a = "Hello Java";
```

위와 같은 문자열에서 “Java”라는 문자열이 시작되는 위치를 알고 싶은 경우 indexOf를 다음과 같이 사용할 수 있다.

```java
String a ="Hello Java";
System.out.println(a.indexOf("Java")); // 6출력 (자바는 0부터 index를 세기 때문)
```

### contains

contains는 문자열에서 특정 문자열이 포함되어 있는지의 여부를 리턴한다.

```java
String a = "Hello Java"l
System.out.println(a.contains("Java"));  // true 출력
```

### charAt

charAt은 문자열에서 특정 위치의 문자(char)를 리턴한다.

```java
String a = "Hello Java";
System.out.println(a.charAt(6));  // "J" 출력
```

위와 같은 a 문자열에서 “J”는 6번째 인덱스에 위치한 문자이므로  `a.charAt(6)` 을 통해 “J”를 출력할 수 있다.

### replaceAll

replaceAll은 문자열 중 특정 문자열을 다른 문자열로 바꾸고자 할 때 사용한다.

```java
String a = "Hello Java";
System.out.println(a.replaceAll("Java", "World");  // Hello World 출력
```

### substring

substring 은 문자열 중 특정 부분을 뽑아낼 경우에 사용한다.

```java
String a = "Hello Java";
System.out.println(a.bubstring(0, 4)); // Hell 출력
```

위처럼 substring(시작위치, 끝위치)와 같이 사용하여 문자를 뽑아내게 된다. 단 끝위치는 포함되지 않는 다는 점을 주의하자.

### toUpperCase

toUpperCase는 문자열을 모두 대문자로 변경할 때 사용한다. (모두 소문자로 변경할 때는 toLowerCase를 사용한다.)

```java
String a = "Hello Java";
System.out.println(a.toUpperCase()); // HELLO JAVA 출력
```

### split

split 메소드는 문자열을 특정 구분자로 분리하는 메소드이다.

```java
String a = "a : b : c: d";
String[] result = a.split(":"); // result는 {"a", "b", "c", "d"}
```

## 문자열 포매팅

------

문자열에서 또 하나 알아야 할 것으로는 문자열 포매팅(Formatting)이 있다. 문자열 안의 특정한 값을 바꿔야 할 경우가 있을 때 이것을 가능하게 해주는 것이 바로 문자열 포매팅 기법이다.

쉽게 말하면 문자열 포매팅이란 문자열 안에 어떤 값을 삽입하는 방법이다. 다음 예를 직접 실해해 보면서 그 사용법을 알아보자.

**1.숫자 바로대입**

```java
System.out.println(String.format("I eat %d apples.", 3));
```

문자열 포매팅은 `String.format` 메소드를 사용한다. 위 예제의 결과값을 보면 알겠지만 위 예제는 문자열 안에 정수 3을 삽입하는 방법을 보여준다. 여기서 `%d` 를 문자열 포맷 코드라고 부른다.

**2.문자열 바로 대입**

```java
System.out.println(String.format("I eat %s apples.", "five"));
```

**3.숫자 값을 나타내는 변수로 대입**

```java
int num = 3;
System.out.println(String.format("I eat %d apples.", num));
```

**4.여러가지 값 넣기**

```java
int num = 3;
String day = "five";
System.out.println(String.format("I ate %d apples. so I was sick for %s days.", num, day));
```

### 문자열 포맷 코드

| 코드 | 설명                     |
| ---- | ------------------------ |
| %s   | 문자열(String)           |
| %c   | 문자 1개(character       |
| %d   | 정수(Integer)            |
| %f   | 부동소수(floating-point) |
| %o   | 8진수                    |
| %x   | 16진수                   |
| %%   | Literal % (문자 % 자체)  |

여기서 재밌는 것은 %s 포맷 코드인데, 이 코드는 어떤 형태의 값이든 변환해 넣을 수 있다. 무슨 말인지 예를 통해 확인해 보자.

```java
System.out.println(String.format("I have %s apples",  3));  // "I have 3 apples" 출력
System.out.println(String.format("rate is %s", 3.234));  // "rate is 3.234" 출력
```

3을 문자열 안에 삽입하려면 `%d`를 사용하고, 3.234를 삽입하려면 `%f`를 사용해야 한다. 하지만 %s를 사용하면 이런 것을 생각하지 않아도 된다. **왜냐하면 `%s` 는 자동으로 % 뒤에 있는 값을 문자열로 바꾸기 때문**이다.

**[포매팅 연산자 `%d`와 `%`를 같이 쓸 때는 `%%`를 사용한다]**

```java
System.out.println(String.format("Error is %d%.", 98));
```

위 예문의 결과값으로 당연히 “Error is 98%.” 가 출력될 것이라고 예상하겠지만 오류가 발생한다.

이유는 문자열 포맷 코드인 `%d`와 `%`가 같은 문자열 안에 존재하는 경우, `%`를 나타내려면 반드시 `%%`로 써야 하는 법칙이 있기 때문이다. 이 점은 꼭 기억해 두어야 한다. 하지만 문자열 안에 `%d` 같은 포매팅 연산자가 없으면 `%`는 홀로 쓰여도 상관이 없다.

따라서 위 예를 제대로 실행하려면 다음과 같이 해야 한다.

```java
System.out.println(String.format("Error is %d%%.", 98));  // "Error is 98%." 출력
```

### 포맷 코드와 숫자 함께 사용하기

위에서 보았듯이 `%d`, `%s` 등의 포맷 코드는 문자열 안에 어떤 값을 삽입하기 위해 사용한다. 하지만 포맷 코드를 숫자와 함께 사용하면 더 유용하게 사용할 수 있다. 다음 예를 보고 따라해 보자.

**1.정렬과 공백**

```java
System.out.println(String.format("%10s", "hi"));  // "        hi" 출력 
```

앞의 예문에서`%10s` 는 **전체 길이가 10개인 문자열 공간**에서 대입되는 값을 **오른쪽으로 정렬**하고 그 앞의 나머지는 공백으로 남겨 두라는 의미이다.

그렇다면 반대쪽인 왼쪽 정렬은`%-10s`가 될 것이다. 확인해 보자.

```java
System.out.println(String.format("%-10sjane.", "hi"));  // "hi        jane." 출력
```

**2.소수점 표현하기**

```java
System.out.println(String.format("%.4f", 3.42134234));  // 3.4213 출력
```

3.42134234를 소수점 네 번째 자리까지만 나타내고 싶은 경우에는 위와 같이 사용한다. 즉 여기서 **'`.`'**의 의미는 소수점 포인트를 말하고 그 뒤의 숫자 `4`는 소수점 뒤에 나올 숫자의 개수를 말한다. 다음 예를 살펴보자.

```java
System.out.println(String.format("%10.4f", 3.42134234));  // '    3.4213' 출력
```

위 예는 숫자 3.42134234를 소수점 네 번째 자리까지만 표시하고 전체 길이가 10개인 문자열 공간에서 오른쪽으로 정렬하는 예를 보여 준다.

**System.out.printf**

`String.format` 메소드는 포매팅된 문자열을 리턴한다. 따라서 포매팅 된 문자열을 출력하려면 다음처럼`System.out.println` 메소드를 함께 사용해야 한다.

```java
System.out.println(String.format("I eat %d apples.", 3));  // "I eat 3 apples." 출력
```

하지만 `System.out.printf` 메소드를 사용하면 `String.format` 메소드 없이도 동일한 형식으로 포매팅된 문자열을 출력할 수 있다.

```java
System.out.printf("I eat %d apples.", 3);  // "I eat 3 apples." 출력
```

`String.format` 과 `System.out.printf` 의 차이는 **전자는 문자열을 리턴하는 메소드**이고 **후자는 문자열을 출력하는 메소드**라는 점이다. 상황에 맞게 선택하여 사용하자.