# 03 - 01 while

------

while문 안의 문장을 수행할 때 어떤 조건을 검사해서 조건에 맞지 않는 경우 while문을 빠져나가는 대신 while문의 맨 처음(조건문)으로로 돌아가게 하고 싶은 경우도도 있다.

만약 1 ~ 10 까지의 숫자에서 홀수만을 출력하는 것을 while문을 이용해서 작성한다고 생각해 보자. 어떤 방법이 좋을까?

```java
public class Main {
	public static void main(String[] args) {
		int a = 0;
		while ( a  < 10 ) {
			a++;
			if ( a % 2 == 0 ) {
				continue;  // 짝수인 경우 조건으로 돌아간다.
			}
			System.out.println(a);  // 홀수만 출력한다.
		}
```

이 while문 안에서 a 를 2 로 나눈 나머지가 0이 되면 `continue`를 만나 출력문을 실행하지 않고 다시시 조건문으로 넘어간다. (한 바퀴 돌긴 한 것이다.)