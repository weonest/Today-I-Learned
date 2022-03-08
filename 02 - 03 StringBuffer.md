# 02 - 03 StringBuffer

------

StringBuffer는 문자열을 추가하거나 변경 할 때 주로 사용하는 자료형이다. StringBuffer의 메소드들을 살펴보면서 StringBuffer의 사용법에 대해서 알아보자.

### append

------

다음은 StringBuffer 객체를 생성하고 문자열을 생성하는 예제이다.

```java
StringBuffer sb = new StringBuffer();  // StringBuffer 객체 sb 생성
sb.append("hello");
sb.append(" ");
sb.append("jump to java");
String result = sb.toString();
System.out.println(result);           // 출력 : hello jump to java
```

StringBuffer 자료형은 append 메소드를 사용하여 계속해서 문자열을 추가해 나갈 수 있다. 그리고 위 예제와 같이 `toString()` 메소드를 이용하면 String 자료형으로 변경할 수 있다.

위 예제를 String 자료형만 가지고 표현하면 다음과 같이 작성할 수 있다.

```java
String result = "";
result += "hello";
result += " ";
result += "jump to java";           
System.out.println(result);          // 출력 hello jump to java
```

두 예제의 결과는 동일하지만 내부적으로 객체사 생성되고 메모리가 사용되는 과정은 다르다.

첫 번째 예제의 경우 StringBuffer 객체는 한번만 생성된다. 두 번째 예제는String 자료형에 `+` 연산이 있을때마다 새로운 String 객체사 생성된다(문자열 간 `+` 연산이 있는 경우 **자바는 자동으로 새로운 String 객체를 만들어 낸다**.) 두 번째 예제에서는 총 4개의 String  자료형 객체가 만들어지게 된다.

String 자료형은 **한 번 값이 생성되면 그 값을 변경할 수가 없다**. 이렇게 값을 변경할 수 없는 것을 immutable 하다고 한다. trim, toUpperCase 등의 메소드를 보면 문자열이 변경되는 것 처럼 생각 될 수도 있지만 해당 메소드 수행 시 또 다른 String 객체를 생성하여 리턴할 뿐이다. 하지만 StringBuffer는 이와 반대로 **값을 변경할 수 있다(mutable). 즉 한번 생성된 값을 언제든지 수정할 수 있다.**

하지만 StringBuffer 자료형은 String 자료형보다 무거운 편에 속한다. `newStringBuffer()`로 객체를 생성하는 것은 일반 String을 사용하는 것보다 메모리 사용량도 많고 속도도 느리다. **따라서 문자열 추가나 변경등의 작업이 많을 경우에는 StirngBuffer를, 문자열 변경 작업이 거의 없는 경우에는 그냥 String을 사용하는 것이 유리하다.**

**StringBuilder**

StringBuffer와 비슷한 자료형을 사용법은 StringBuffer와 동일하다.

```java
StringBuilder sb = new StringBuilder();
sb.append("hello");
sb.append(" ");
sb.append("jump to java");
String result = sb.toString();
System.out.println(result);         // 출력 : hello jump to java
```

StringBuffer는 **멀티 스레드 환경에서 안전하다는 장점**이 있고, StringBuilder는 StringBuffer 보다 **성능이 우수한 장점**이 있다. 따라서 동기화를 고려할 필요가 없는 상황에서는 StringBuffer 보다는 StringBuilder를 사용하는 것이 유리하다.

### insert

------

insert 메소드는 특정 위치에 원하는 문자열을 삽입할 수 있다.

```java
StringBuffer sb = new StringBuffer();
sb.append("jump to java");
sb.insert(0, "hello ");
System.out.println(sb.toString());      // 출력 : hello jump to java
```

### substring

------

String 자료형의 substring 메소드와 동일하게 사용된다. **((시작위치, 끝위치) 추출)**