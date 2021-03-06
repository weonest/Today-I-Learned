# 09 - 02 SmallProject 2

------

## TDD 자세히 알기

------

TDD는 테스트코드를 먼저 작성하고 그 테스트코드를 통과하는 실제코드를 나중에 만든다.

### TDD의 흐름

TDD에 절대적인 방법이 있는 것은 아니지만, 일반적인 흐름은 있다. 그 흐름은 다음과 같다.

![https://wikidocs.net/images/page/224/tdd_flow.jpg](https://wikidocs.net/images/page/224/tdd_flow.jpg)

1. 무엇을 테스트할 것인가 생각한다.
2. 실패하는 테스트를 작성한다.
3. 테스트를 통과하는 코드를 작성한다.
4. 코드를 리팩토링한다. (테스트코드 또한 리팩토링 한다)
5. 구현해야 할 것이 있을 때까지 위의 작업을 반복한다.

### TDD의 목표

Simple Code는 TDD의 궁극적인 목표이다. 코드가 단순하다는 의미가 아니라 중복이 없고 누가 봐도 명확한 코드를 말한다. 가끔 프로젝트를 하다보면 정말 뛰어난 프로그래머들을 보게 된다.

## 어디서부터 시작할 것인가?

------

TDD가 무엇인지 확실하게 아는 방법은 단 한 가지, 실제로 TDD를 해보는 것이다.

다음과 같은 두 날짜(YYYYMMDD)의 일 수 차이를 구하는 프로그램을 TDD로 작성해 보자.

> 20070515 sub 20070501 = 14
>
> 20070501 sub 20075015 = 14
>
> 20070301 sub 20070515 = 31 + 30

이 문제는 아주 쉬워 보이지만 만만하지는 않을 듯하다. 일단 가장 걸림돌이 될만한 것은 윤달에 대한 것이다.

*결과 = 절대값(첫 번째 날짜의 총 일수 - 두 번째 날짜의 총 일수)*

그렇다, 해당 날짜의 0년부터 그 날짜의 지나온 총 일수를 구한다면 문제가 쉽게 해결될 듯 하다.

- 두 날짜의 차이일자를 구한다.
- 특정일자의 총 일수를 구한다.

조금 더 세분화하여 특정일자의 총 일수를 구하기 위해서 다음의 세 가지 항목을 추가하였다.

- 전년도까지의 총 일수를 구한다.
- 전월까지의 총 일수를 구한다.
- 해당일자까지의 총 일수를 구한다.

즉, 20070515라는 날짜의 총 일수를 구하고 싶다면

2007년 5월 15일의 총 일수 = 0년부텨 2006년 까지의 총 일수 + 2007년 1월부터 4월까지의 총 일수 + 15 가 된다는 생각이다.

## TDD Start!

------

- 두 날짜(YYYYMMDD)의 차이일자를 구한다.

- 특정일자의 총 일 수를 구한다.

- > 전년도까지의 총 일 수를 구한다.

- 전달까지의 총 일 수를 구한다.

- 해당일자까지의 총 일 수를 구한다.

위의 TODO 리스트를 기반으로 TDD를 시작해 보자. Todd 리스트 중 전년도까지의 총 일수를 구하는 것을 먼저 테스트해 보기로 하자.

## Junit

------

잠시 Junit에 대해 알아보도록 하자.

```jsx
import junit.framework.TestCase;

public class SubDateTest extends TestCase {
	public static void main(String[] args) {
		junit.textui.TestRunner.run(SubDateTest.class);
	}
public void test1() {
	..
	}
}
```

- 테스트 코드는 위처럼 junit 프레임워크에 포함되어있는 TestCase라는 클래스를 extends 하여 작성한다.
- 위 샘플코드의 “test1”메소드 명처럼 “test”로 시작하는 메소드는 자동으로 실행이 된다.

우리는 앞으로 테스트코드를 작성하기 위해서 TestCase에 있는 assertEquals, assertFalse, assertTrue 라는 세 개의 메소드를 이용할 것이다.

- assertEquals(a, b) - a와 b가 같은지를 조사
- assertTrue(a) - a가 참인지 조사
- assertFalse(a) - a가 거짓인지를 조사

## 테스트 코드로 실제 코드를 디자인

------

첫 번째 테스트 코드는 다음과 같다.

```jsx
public void testGetYearDay() {
	assertEquals(0, SubDate.getYearDay(1));
	assertEqauls(365, SubDate.getYearDay(2));
}
```

위 테스트 코드의 의도는 다음과 같다.

- 0년이란 것은 존재하기 않기 때문에 1년까지의 총 일수는 0이 되어야 한다.(최초 일자를 1년 1월 1일이라고 설정한 기준)
- 2년 까지의 총 일수는 1년 1월 1일부터 2년 1월 1일까지이므로 365일이 될 것이다.

위 테스트 코드를 작성하는 순간 SubDate라는 클래스는 아직 존재하지 않는다. SubDate라는 클래스는 테스트코드에 의해서 만들어진 가상의 클래스이다. 즉, 테스트 코드에 의해서 SubDate라는 클래스가 디자인되고 있는 것이다. 위처럼 테스트 코드를 작성하고 저장하면 컴파일이 되지 않는다. 컴파일이 되기 위한 가장 빠른 방법은 다음과 같다.

```jsx
public class SubDate {
	public static int getYearDay(int year) {
		return 1;
	}
}
```

위와 같이 SubDate라는 클래스를 작성하면 컴파일은 되지만 테스트 코드 실행 시 실패하는 것을 볼 수 있다. 테스트가 실패한다고 낙담할 필요는 없다. 테스트를 실패하게 만드는 것은 TDD의 중요한 과정 중 하나이다. TDD는 “테스트가 실패할 경우에만 실제코드를 작성 한다”는 간단한 법칙을 따른다.

## 테스트 통과

------

테스트가 실패하므로 이젠 테스트를 통과하는 코드를 작성해야 한다.

```jsx
public class SubDate {
	public static int getYearDay(int year) {
		if (year == 1) return 0;
		else return 365;
	}
}
```

테스트를 통과하기 위한 급급한 방법을 찾는 것. 이 또한 TDD의 당연한 과정이다. TDD 싸이클에 의해 결국에는 당연한 코드로 변경될 것이기 때문이다.

## TDD의 보폭

------

우리는 getYearDay 라는 메소드가 완전하지 않다는 것을 알고 있다. 실패하는 테스트 코드를 작성할 차례인 것이다. 테스트 코드에 5년 미만의 총 일수를 구하는 다음의 테스트를 한 줄 삽입해 보자.

```jsx
assertEquals(365+365+365+366, SubDAte.getYearDay(5));
```

이것을 통과하기 위해서는 1년부터 4년까지 중 윤년이 있는지 조사하는 로직이 필요하다.

Todo 리스트에 “윤년체크”라는 항목을 추가 하였다.

- 윤년체크

윤년인지 아닌지를 확인할 수 있는 테스트 코드를 다음과 같이 만들었다.

```jsx
public void testLeapYear() {
	assertTrue(SubDate.isLeapYear(0));
	assertFasle(SubDate.isLeapYear(1));
	assertTrue(SubDate.isLeapYear(4));
}
```

4로 나누어 떨어지는 년도가 윤년이므로 이와 같은 코드를 작성하였다.

```jsx
public static boolean isLeapYear(int year) {
	if(year == 0) return true;
	if(year == 1) return false;
	if(year == 4) return true;
	return false;
}
```

## 리팩토링

------

테스트 코드와 실제코드를 잘 살펴보면 “데이터의 중복”을 발견할 수 있다. 그것은 바로 0, 1, 4 라는 숫자이다. 이 숫자를 유심히 관찰하면 다음과 같이 리팩토링 할 수 있다.

```jsx
public static boolean isLeapYear(int year) {
	if (year % 4 == 0) return true;
	return false;
}
```

4라는 중복 숫자가 남아 있긴 하지만 4라는 숫자는 의미가 있는 숫자이므로 일단은 그대로 놔두기로한다. TDD의 흐름은 지금까지 진행해 온 것처럼 “테스트 > 코드 > 리팩토링” 의 순서로 자연스럽게 진행되고 있음에 주목하자.

## 테스트 코드로 밝히는 진실

------

테스트를 계속 하기 전에 먼저 윤년이 무엇인지 개념을 확실히 해보자.

- 서력 기원 연수가 4로 나누어 떨어지는 해는 우선 윤년으로 하고,
- 그 중에서 100으로 나누어 떨어지는 해는 평년으로 하며,
- 다만 400으로 나누어 떨어지는 해는 다시 윤년으로 정한다

즉, 120년은 400으로 나누어 떨어지고 100으로도 나누어 떨어지지만 400을 먼저 생각하기 때문에 윤년이다. 700년은 100으로 나누어 떨어지기 때문에 윤년이 아니다. 즉 400, 100, 4 라는 우선순위를 적용시켜야 한다는 점이다.

```jsx
public void testLeapYear() {
	assertTrue(SubDate.isLeapYear(0));
	assertFalse(SubDate.isLeapYear(1));
    assertTrue(SubDate.isLeapYear(4));
    assertTrue(SubDate.isLeapYear(1200));
    assertFalse(SubDate.isLeapYear(700));
}
```

위 테스트 코드는 테스트 실행 시 assertFalse(SubDate.isLeapYear(700));에서 실패한다. 테스트를 통과하기 위해서는 다음과 같이 실제코드를 수정해야만 한다.

```jsx
public static boolean isLeapYear(int year) {
	if (year % 100 == 0) return false;
	if (year % 4 == 0) return ture;
	return false;
}
```

실제 코드를 위와 같이 수정하니 이번에는 assertTrue(SubDate.isLeapYear(1200)); 에서 실패한다.

```jsx
public static boolean isLeapYear(int year) {
	if (year % 400 == 0) return ture;
	if (year % 100 == 0) return false;
	if (year % 4 == 0) return treu;
	retrun false;
}
```

- 윤년체크

- > 전년도까지의 총 일수를 구한다.

다음 테스트로 넘어가기 전에 한 가지 유념해야 할 것은 “윤년을 체크하는 테스트코드가 믿음을 주는가?”이다. 완벽하지 않다고 느낀다면 확신할 수 있는 테스트 코드를 작성해야 한다.

```
assertEquals(365+365+365+366, SubDate.getYearDay(5));
public static int getYearDay(int year) {
	int resulut = 0l
	for (int i = 1; i < year; i++) {
		if (isLeapYear(i)) result += 366;
		else resulut += 365;
	}
	return result;
}
```

## TDD의 흐름을 알아보자

------

이전에 단순히 테스트를 통과하기 급급한 메소드가 “당연한” 코드로 바뀌는 모습에 주목. 이젠 전월까지의 총 일수를 구해보도록 하자.

```java
public void testGetMonthDay() {
	asserEquals(0, SubDate.getMonthDay(1));
	assertEquals(31, SubDate.getMonthDay(2));
}
public static int getMonthDay(int month) {
    if (month == 1) return 0;
    else return 31;
}
```

구하려는 일수에 포함되는 2월이 29일까지 있는지, 28일까지 있는지 어떻게 알까?

2월, 즉 윤달에 대한 처리를 어떻게 할 것인가? 하는 점이다. 20070515라는 날짜의 총 일수를 구하려 할 때 다음과 같은 전략을 세웠던 것을 기억해 보자.

`2007년 5월 15일의 총 일수 = 0년 부터 2006년 까지의 총 일수 + 2007년 1월 부터 4월 까지의 총 일수 + 15` 즉, 2007년 1월 부터 4월까지의 총 일수는 31 + 28 (2007년이 윤년이 아니기 때문) + 31 + 30 이 되는 것을 알 수 있다. 테스트 코드에 이러한 의도를 담아 다음과 같이 작성할 수 있다.

```java
public void testGetMonthDay() {
    assertEquals(0, SubDate.getMonthDay(1, true));
    assertEquals(31, SubDate.getMonthDay(2, false));
}
```

2월이 윤달인지 아닌지를 두 번째 파라미터로 보내겠다는 의도이다. (총 일수를 구하려는 일자의 연도가 윤년인 경우는 true, 윤년이 아닌 경우는 false 이다) 컴파일이 되기 위한 실제 코드는 다음과 같이 변해야 한다.

```java
public static int getMonthDay(int month, boolean isLeap) {
    if (month == 1) return 0;
    else return 31;
}
```

이제 테스트 코드에 윤달 부분을 테스트할 수 있도록 추가해보 자.

```java
assertEquals(31+28, SubDate.getMonthDay(3, false));
assertEquals(31+29, SubDate.getMonthDay(3, true));
```

3월 전달까지의 총일수를 윤달이 낀 경우와 아닌 경우를 테스트하는 것이다. 테스트를 통과하기 위해서 실제코드는 다음과 같이 변할 것이다.

```java
static final int[] monthDays = {
    31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
public static int getMonthDay(int month, boolean isLeap) {
    int result = 0;
    for(int i=1; i< month; i++) {
        result += monthDays[i-1];
    }

    if (isLeap && month > 2) result += 1;
    return result;
}
```

- 전월까지의 총 일수를 구한다.

- > 해당일자까지의 총 일수를 구한다.

자 이젠 전월까지의 총 일수를 구했으므로 해당일자의 총 일수를 구하면 될 것이다. 하지만 해당일자의 총 일수는 일자 값 그자체이므로 테스트가 필요 없다고 생각된다.

- 해당일자까지의 총 일수를 구한다.

- > 특정 일자의 총 일수를 구한다.

이제 특정 일자의 총 일수를 구해보도록 하자.

```java
public void testGetTotalDay() {
    assertEquals(1, SubDate.getTotalDay("00010101"));
    assertEquals(366, SubDate.getTotalDay("00020101"));
}
```

1년 1월 1일의 총 일수는 1일이 될 것이고, 2년 1월 1일까지의 총 일수는 366일이 되어야 한다. 테스트를 통과하기 위한 실제코드를 작성하면 다음과 같다.

```java
public static int getTotalDay(String date) {
    int year = Integer.parseInt(date.substring(0, 4));
    int month = Integer.parseInt(date.substring(4, 6));
    int day = Integer.parseInt(date.substring(6, 8));
    return getYearDay(year)
        + getMonthDay(month, isLeapYear(year))
        + day;
}
```

- 두 날짜(YYYYMMDD)의 차이일자를 구한다.
- 특정일자의 총 일수를 구한다.

자 이제 마지막 두 날짜의 차이 일자를 구하는 우리의 마지막 테스트가 남아 있다. 테스트 코드는 아래와 같다.

```java
public void testSubDate() {
    assertEquals(1, SubDate.sub("20061231", "20070101"));
    assertEquals(31+28+30+31+14, 
            SubDate.sub("20070101", "20070515"));
    assertEquals(31+29+30+31+14, 
            SubDate.sub("20080101", "20080515"));
}
```

테스트를 통과하려면

```java
public static int sub(String date1, String date2) {
    return Math.abs(getTotalDay(date1) - getTotalDay(date2));
}
```

## 마치며

------

TDD에 대한 모든 것을 다 설명하기엔 부족한 예제이지만 TDD가 무엇인지 감을 잡을 수 있는 예제였으리라 생각한다. 독자 중에는 "이렇게 쉬운 문제를 뭐 하러 귀찮게 TDD로 해야 하나?"라고 반문할 수도 있겠지만 TDD가 숙달되면 이 정도의 쉬운 문제라도 TDD를 사용하는 것이 더 빠르고 즐거운 길이 된다는 것을 곧 깨닫게 될 것이다. 당연히 프로그램이 복잡해지고 어려워질수록 TDD는 더욱더 큰 힘을 발휘하게 된다.

TDD는 자바 언어를 배우거나 XML-RPC등의 개념을 배우는 것과는 매우 다르다. 지식 기반이 아니라 경험에서 우러나오는 것이기 때문이다. XML-RPC의 개념에 대해서 알게 되면 그것을 바로 써먹을 수 있지만 TDD는 사뭇 다르다. TDD가 무엇을 하는 것인지 알게 되어도 능숙해지려면 꽤나 시간이 걸리기 때문이다. 무협지를 보라. 내공이 하루아침에 쌓이는 경우가 있는가? TDD의 가능성을 본 독자라면 꼭 "용기와 끈기"를 가지고 부단히 노력해 볼 것을 다시한번 당부한다. 마지막으로 다음의 책을 꼭 한번 일독할 것을 추천하며 이 글을 마무리할까 한다.

- Test Driven Development By Example (By Kent Beck)

**참고자료**

- Test Driven Development By Example (By Kent Beck)
- 한국 XP 사용자 모임, http://xper.org