# 02 - 10 연습문제

## **Q1**

홍길동 씨의 과목별 점수는 다음과 같다. 홍길동 씨의 평균 점수를 구해 보자.

[제목 없음](https://www.notion.so/d90a2f969e564ed0848a1a824f71d412)

```java
public class Test {
	public static void main(String[] args) {
		int a = 80
		int b = 75;
		int c = 55;
		System.out.println((a + b + c) /3 ); // 70 출력
	}
}
```

## **Q2**

자연수 13이 홀수인지 짝수인지 판별할 수 있는 방법에 대해 말해 보자.

```java
public class Test {
	public static void main(Sting[] args) {
		if((13 % 2 ) == 1) {
			System.out.println("홀 수");
			} else {
				System.out.println("짝 수");
			}
	}
}
```

## **Q3**

홍길동 씨의 주민등록번호는 881120-1068234이다. 홍길동 씨의 주민등록번호를 연월일(YYYYMMDD) 부분과 그 뒤의 숫자 부분으로 나누어 출력해 보자.

> ※ 문자열의 substring을 사용해 보자.

```java
public class Main {
    public static void main(String[] args) {

        String Hid = "881120-1068234";
        System.out.println("19" + Hid.substring(0, 2) + Hid.substring(2));
        
    }
}
```

## **Q4**

주민등록번호 뒷자리의 맨 첫 번째 숫자는 성별을 나타낸다. 주민등록번호에서 성별을 나타내는 숫자를 출력해 보자.

```
>>> pin = "881120-1068234"
public class Main {
    public static void main(String[] args) {

        String Hid = "881120-1068234";
        System.out.println(Hid.charAt(7));
    }
}
```

> ※ 문자열 인덱싱을 사용해 보자.

## **Q5**

다음과 같은 문자열 a:b:c:d가 있다. 문자열의 replace 함수를 사용하여 a#b#c#d로 바꿔서 출력해 보자.

```
>>> a = "a:b:c:d"
public class Main {
    public static void main(String[] args) {

        String a = "a:b:c:d";
        System.out.println(a.replace(':', '#'));
// replace와 replaceAll의 차이를 좀 더 알아보자.
    }
}
```

## **Q6**

다음과 같은 `[1, 3, 5, 4, 2]` 리스트를 `[5, 4, 3, 2, 1]`로 만들어 보자.

```
import java.util.ArrayList;
import java.util.Arrays;

publicclassSample {
publicstaticvoid main(String[] args) {
        ArrayList<Integer> myList =new ArrayList<>(Arrays.asList(1, 3, 5, 4, 2));
        System.out.println(myList); // [1, 3, 5, 4, 2] 출력
    }
}
import java.util.*;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> myList = new ArrayList<>(Arrays.asList(1, 3, 5, 4, 2));
        System.out.println(myList);

        myList.sort(Comparator.reverseOrder());
        System.out.println(myList);
    }
}
```

> ※ 리스트의 sort 메소드를 사용해 보자.

## **Q7**

다음과 같은 ['Life', 'is', 'too', 'short'] 리스트를 "Life is too short" 문자열로 만들어 출력해 보자.

```
import java.util.ArrayList;
import java.util.Arrays;

publicclassSample {
publicstaticvoid main(String[] args) {
        ArrayList<String> myList =new ArrayList<>(Arrays.asList("Life", "is", "too", "short"));
        System.out.println(myList); // [Life, is, too, short] 출력
    }
}
`import java.util.*;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> myList =new ArrayList<>(Arrays.asList("Life", "is", "too", "short"));
        System.out.println(myList); // [Life, is, too, short] 출력
        String join = String.join(" ", myList);
        System.out.println(join);
    }
}
```

> ※ 문자열의 join 메소드를 사용해 보자.

## **Q8**

다음의 맵 grade에서 "B'에 해당되는 값을 추출해 보자. (추출하고 나면 grade에는 "B"에 해당하는 아이템이 사라져야 한다.)

```
import java.util.HashMap;

publicclassSample {
publicstaticvoid main(String[] args) {
        HashMap<String, Integer> grade =new HashMap<>();
        grade.put("A", 90);
        grade.put("B", 80);
        grade.put("C", 70);
    }
}
`import java.util.*;

public class Main {
    public static void main(String[] args) {

        HashMap<String, Integer> grade = new HashMap<>();
        grade.put("A", 90);
        grade.put("B", 80);
        grade.put("C", 70);
				int result = grade.remove("B");
				System.out.println(result);
        System.out.println(grade);
    }
}
```

> ※ 맵의 remove 메소드를 사용해 보자.

## **Q9**

다음의 numbers 리스트에서 중복 숫자를 제거해 보자.

```
import java.util.ArrayList;
import java.util.Arrays;

publicclassSample {
publicstaticvoid main(String[] args) {
        ArrayList<Integer> numbers =new ArrayList<>(Arrays.asList(1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 5));
        System.out.println(numbers);  // [1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 5] 출력
    }
}
import java.util.*;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 5));
        System.out.println(numbers);  // [1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 5] 출력
        TreeSet<Integer> numbers2 = new TreeSet<>(numbers);
        System.out.println(numbers2);
    }
}
```

> ※ 집합 자료형의 요솟값이 중복될 수 없다는 특징을 사용해 보자.

## **Q10**

다음은 커피의 종류(1: 아메리카노, 2:아이스 아메리카노, 3:카페라떼)를 입력하면 커피의 가격을 알려주는 프로그램이다.

```
import java.util.HashMap;

publicclassSample {
staticvoid printCoffeePrice(int type) {
        HashMap<Integer, Integer> priceMap =new HashMap<>();
        priceMap.put(1, 3000);  // 1: 아메리카노
        priceMap.put(2, 4000);  // 2: 아이스 아메리카노
        priceMap.put(3, 5000);  // 3: 카페라떼
int price = priceMap.get(type);
        System.out.println(String.format("가격은 %d원 입니다.", price));
    }

publicstaticvoid main(String[] args) {
        printCoffeePrice(1);  // "가격은 3000원 입니다." 출력
        printCoffeePrice(99);  // NullPointerException 발생
    }
}
```

위 메소드에서 1, 2, 3과 같은 매직넘버를 제거하여 프로그램을 개선해보자.

> ※ Enum을 사용해 보자.

```java
import java.util.*;

public class Test {

    enum CoffeeType{
        Americano,
        IceAmericano,
        CafeLatte
    };
    public static void printCoffeePrice(CoffeeType type) {

        HashMap<CoffeeType, Integer> priceMap =new HashMap<>();
        priceMap.put(CoffeeType.Americano, 3000);  // 1: 아메리카노
        priceMap.put(CoffeeType.IceAmericano, 4000);  // 2: 아이스 아메리카노
        priceMap.put(CoffeeType.CafeLatte, 5000);  // 3: 카페라떼
        int price = priceMap.get(type); // ### 여기서 왜 type로 부르는지? ###
        System.out.println(String.format("가격은 %d원 입니다.", price));
    }

    public static void main(String[] args) {
        printCoffeePrice(CoffeeType.Americano);  // "가격은 3000원 입니다." 출력
    }
}
```