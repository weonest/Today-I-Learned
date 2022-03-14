# 03 - 02 for each

------

for each 라는 키워드가 따로 있는 것은 아니고 동일한 for를 이용한다.

하지만 조건식 부분의 문법이 조금 다르다.

```java
public class Main {
	public static void main(String[] args) {
		String[] nums = {"one", "two", "three"};
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);

		}
		for(String number: numbers) {
	    System.out.println(number);
		}
  }
}
```

> for each 문은 보기에에 매우 직관적이다.

```java
for (type(형태) var(변수) : iterate(반복) {
		body of loop
}
```

위에서 `iterate`는 루프를 돌릴 객체이고 `iterate` 객체에서 한개씩 순차적으로 var에 대입되어 for문이 수행된다. `iterate`로 사용할 수 있는 자료형은 루프를 돌릴 수 있는 자료형(배열 및 `ArrayList` 등)만 가능하다.

다음은 위 예제를 `ArrayList`로 구현한 예제이다. for문의 사용법은 String[] 배열을 사용했을 때와 완전히 동일하다