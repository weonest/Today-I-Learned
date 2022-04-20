# 07 - 03 Practice test 3

------

이번에는 양의 정수를 입력 받아 그 자리수를 출력하는 프로그램을 작성해 보자.

| 숫자 | 숫자의 자릿수 |
| ---- | ------------- |
| 3    | 1             |
| 25   | 2             |
| 333  | 3             |
| 2344 | 4             |

위 예의 숫자와 자리수를 잘 관찰하면 숫자의 개수와 자리수의 개수는 일치한다는 것을 알 수 있다. 이러한 관계를 이용하여 자리수를 구할 수 있는 방법이 있을지 생각해 보자.

다음처럼 123이라는 숫자를 10으로 나누어 보자.

```java
public class Problem3 {
    public static void main(String[] args) {
        int n = 123;
        System.out.println(123 / 10);  // 12 출력
    }
}
```

123을 10으로 나누면 끝자리 숫자 3이 제거되고 몫 12만 남는다. 즉, 10으로 나눌때마다 끝자리 숫자가 1개씩 제거되는 것을 알 수 있다. 이런 아이디어를 적용하면 이 문제를 풀 수 있을것 같다.

즉, 123을 10으로 나누면(1회) 12가 되고, 다시 12를 10으로 나누면(2회) 1이 되고, 다시 1을 10으로 나누면(3회) 0이 된다. 0이 되면 나누기를 멈추고 지금까지 나눈 횟수를 더하면 123의 자리수를 구할 수 있다.

이런 생각을 바탕으로 풀이한 해법은 다음과 같다.

```java
public class Problem3 {
    static int getDigitCount(int n) {
        int count = 0;
        while (true) {
            if (n == 0) {
                break;
            }
            n = n / 10;  // 숫자 n을 10으로 나누고 그 값을 다시 숫자 n에 대입한다.
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(getDigitCount(3));  // 1 출력
        System.out.println(getDigitCount(25));  // 2 출력
        System.out.println(getDigitCount(333));  // 3 출력
        System.out.println(getDigitCount(7876));  // 4 출력
    }
}
```

getDigitCount 메소드는 숫자를 입력으로 받아 숫자가 0이 될 때까지 10으로 계속 나누고, 그 나눈 횟수를 리턴하는 메소드이다.

사실 이 문제는 숫자를 문자열로 바꾸고 그 문자열의 갯수를 세는 방법을 사용하면 더 간단하다. 다음은 문자열로 변환하여 그 갯수를 세는 풀이이다.

```java
public class Problem3 {
    static int getDigitCount(int n) {
        String s = "" +n;  // 숫자를 문자열로 바꾼다.
        return s.length();
    }

    public static void main(String[] args) {
        System.out.println(getDigitCount(3));  // 1 출력
        System.out.println(getDigitCount(25));  // 2 출력
        System.out.println(getDigitCount(333));  // 3 출력
        System.out.println(getDigitCount(7876));  // 4 출력
    }
}
```

숫자를 문자열로 바꾸고 그 갯수를 리턴하게 수정하였다. 숫자를 문자열로 바꾸는 방법은 숫자에 빈문자열을 더해주면 된다.