# 07 - 04 Practice test 4

------

이번에는 어떠한 문자열을 입력받았을 때 공백을 제외한 글자수만을 리턴하는 코드를 작성해 보자. 즉, 어떤 문자열이 “공백을 제외한 글자수”라면 띄어쓰기를 위해 필요한 공백 문자 2개를 제외하고 9라는 숫자를 리턴해야 한다.

```java
public class Problem4 {
	public static void main(String[] args) {
		String a = "공백을 제외한 글자수";
		System.out.println("["+ a.charat(0) + "]");  // [공] 출력
		System.out.println("["+ a.charat(3) + "]");  // [  ] 출력
	}
}
```

a 문자열의 첫번째 문자는 `a.charAt(0)`와 같이 구할 수 있다. 첫번째 문자는 "공" 이므로 좌우에 대괄호를 포함하여 출력했으므로 `[공]`을 출력할 것이다. `a.charAt(3)`는 a 문자열의 네번째 문자이므로 공백을 의미하는 `[ ]`을 출력한다.

이러한 내용을 기반으로 공백을 제외한 글자수를 구하는 프로그램은 다음과 같이 작성할 수 있다.

```java
public class Problem4 {
    static int getExcludeSpaceCount(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {  // 공백이 아닌 경우에만 결괏값을 증가
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getExcludeSpaceCount("공백을 제외한 글자수"));  // 9 출력
        System.out.println(getExcludeSpaceCount("점프 투 자바의 연습문제 풀이"));  // 12 출력
    }
}
```

getExcludeSpaceCount 메소드는 총 문자열 길이만큼 루프를 돌며 공백을 제외한 문자만 카운트하여 리턴하는 메소드이다.