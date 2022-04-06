# 07 - 02 Practice test 2

------

A 씨는 게시판 프로그램을 작성하고 있다. 그런데 게시물의 총 건수와 한 페이지에 보여줄 게시물 수를 입력으로 주었을 때 총 페이지 수를 출력하는 프로그램이 필요하다고 한다.

> 이렇게 게시판의 페이지 수를 보여 주는 것을 “페이징”한다고 부른다.

- 메소드 이름은 ? getTotalPage
- 입력 받는 값은? 게시물의 총 건수(m), 한 페이지에 보여줄 게시물 수(n)
- 출력하는 값은? 총 페이지수

A 씨가 필요한 프로그램을 만들기 위해 입력값과 결과값이 어떻게 나와야 하는지 먼저 살펴보자. 게시물의 총 건수가 5이고 한 페이지에서 보여줄 게시물 수가 10이면 총 페이지 수는 당연히 1이 된다. 만약 게시물의 총 건수가 15이고 한 페이지에서 보여줄 게시물 수가 10이라면 총 페이지 수는 2가 될 것이다.

| 게시물의 총 건수(m) | 페이지당 보여줄 게시물 수 (n) | 총 페이지 수 |
| ------------------- | ----------------------------- | ------------ |
| 5                   | 10                            | 1            |
| 15                  | 10                            | 2            |
| 25                  | 10                            | 3            |
| 30                  | 10                            | 3            |

이 문제는 게시판 프로그램을 만들 때 가장 처음 마주치는 난관이라고 할 수 있는 총 페이지 수를 구하는 문제이다. 사실 실제 업무에서 사용하는 페이징 기술은 훨씬 복잡한데 여기에서는 그 중 가장 간단한 총 페이지 수를 구하는 방법에 대해서만 알아보겠다.

1. 다음과 같이 총 건수(m)를 한 페이지에 보여 줄 게시물 수(n)로 나누고 1을 더하면 총 페이지 수를 얻을 수 있다.

> 총 페이지 수 = (총 건수 / 한 페이지당 보여 줄 건수) + 1

2. 이러한 공식을 적용했을 경우 총 페이지 수가 표의 값처럼 구해지는지 확인해 보자.

```java
public class Problem2 {
    static int getTotalPage(int m, int n) {
        return m / n + 1;
    }

    public static void main(String[] args) {
        System.out.println(getTotalPage(5, 10));  // 1 출력
        System.out.println(getTotalPage(15, 10));  // 2 출력
        System.out.println(getTotalPage(25, 10));  // 3 출력
        System.out.println(getTotalPage(30, 10));  // 4 출력
    }
}
```

첫 번째, 두 번째, 세 번째 케이스는 공식에 맞게 결과가 출력된다. 하지만 네 번째 케이스는 총 건수가 30이고 한 페이지에 보여줄 건수가 10인데 4가 출력되어 실패해 버렸다.

3. 실패 케이스는 총 게시물 수와 한 페이지에 보여 줄 게시물 수를 나눈 나머지 값이 0이 될 때 발생함을 알 수 있다.

```java
public class Problem2 {
    static int getTotalPage(int m, int n) {
        if (m % n == 0) {
            return m / n;
        } else {
            return m / n + 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(getTotalPage(5, 10));  // 1 출력
        System.out.println(getTotalPage(15, 10));  // 2 출력
        System.out.println(getTotalPage(25, 10));  // 3 출력
        System.out.println(getTotalPage(30, 10));  // 3 출력
    }
}
```

