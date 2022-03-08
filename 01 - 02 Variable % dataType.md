# 01 - 02 변수와 자료형

### 변수명

------

변수의 이름은 프로그래머가 마음대로 지을 수 있다.

```java
String geonhee;
String mirim;
String bandal;
```

단, 변수의 이름을 지을 때는 다음과 같이 지켜야 할 몇가지 규칙이 있다.

- 변수명은 숫자로 시작할 수 없다.
- _ (underscore) 와 $ 문자 이외의 특수문자는 사용할 수 없다.
- 자바의 키워드는 변수명으로 사용할 수 없다. (ex : int, class, return 등)

> 참고 : 자바 키워드

```java
abstract  continue  for         new        switch
assert    default   goto        package    synchronized
boolean   do        if          private    this
break     double    implements  protected  throw
byte      else      import      public     throws
case      enum      instanceof  return     transient
catch     extends   int         short      try
char      final     interface   static     void
class     finally   long        strictfp   volatile
const     float     native      super      while
```

다음은 변수명을 잘못 사용한 예이다.

```java
int 1st;          // 변수명은 숫자로 시작할 수 없다.
int a#;           // 변수명에 특수문자를 사용할 수 없다.
int class;        // 자바 키워드를 변수명으로 사용할 수 없다.
```

### 자료형 (Type)

------

변수명 앞의 int, String 등은 변수의 자료형을 뜻한다.

`int a;` 라는 문장은 다음과 같이 해석된다.

“변수 a는 int 자료형 변수이다.” 즉, a라는 변수에는 int 자료형 값( 예 : 1, 3, 5, 7 등의 정수)만 담을 수 있다.

`String b;` 라는 문장은 다음과 같이 해석된다.

“변수 b는 String 자료형 변수이다.” 즉, b라는 변수에는 String 자료형 값(예 : “a”, “hello” 등의 문자열)만 담을 수 있다.

> 자주 쓰이는 자료형

```java
int
long
double
boolean
char
String
StringBuffer
List
Map
Set
```

### 사용자 정의 자료형

------

뒤에서 자세하게 공부하겠지만 사용자가 직접 자료형을 만들 수도 있다.

예를 들어 다음과 같이 Car 라는 클래스를 만들면,

```java
class Car {
	Car benz;
}
```

위와 같이 Car 자료형 변수를 만들 수 있다.

위 코드는 다음과 같이 해석된다.

“benz 라는 변수는 Car 자료형 변수이다. benz라는 변수에는 Car 자료형에 해당되는 값만 담을 수 있다.”