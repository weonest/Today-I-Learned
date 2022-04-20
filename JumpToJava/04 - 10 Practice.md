# 04 - 10 Practice

------

## **Q1**

다음은 Calculator 클래스와 그 사용법을 담은 코드이다.

```java
class Calculator {
int value;

    Calculator() {
        this.value = 0;
    }

void add(int val) {
        this.value += val;
    }

int getValue() {
return this.value;
    }
}

public class Sample {
public static void main(String[] args) {
        Calculator cal =new Calculator();
        cal.add(10);
        System.out.println(cal.getValue());  // 10 출력
    }
}
```

Calculator 클래스를 **상속**하는 UpgradeCalculator를 만들고 값을 뺄 수 있는 minus 메서드를 추가해 보자. 즉 다음과 같이 동작하는 클래스를 만들어야 한다.

```
UpgradeCalculator cal =new UpgradeCalculator();
cal.add(10);
cal.minus(3);
System.out.println(cal.getValue());  // 10에서 7을 뺀 3을 출력
// 나의 풀이

package JumpToJava;

class Calculator {
    int value;

    Calculator() {
        this.value = 0;
    }

    void add(int val) {
        this.value += val;
    }

    int getValue() {
        return this.value;
    }
}

class UpgradeCalculator extends Calculator {
    void minus(int val){
        this.value -= val;
    }
}

public class Q1 {
    public static void main(String[] args) {
        UpgradeCalculator cal = new UpgradeCalculator();
        cal.add(10);
        cal.minus(3);
        System.out.println(cal.getValue());  // 7출력
    }
}
```

## **Q2**

객체변수 value가 100 이상의 값은 가질 수 없도록 제한하는 MaxLimitCalculator 클래스를 만들어 보자. 즉 다음과 같이 동작해야 한다.

```java
MaxLimitCalculator cal = new MaxLimitCalculator();
cal.add(50);  // 50 더하기
cal.add(60);  // 60 더하기
System.out.println(cal.getValue());  // 100 출력
```

단 MaxLimitCalculator 클래스는 반드시 다음의 Calculator 클래스를 상속해서 만들어야 한다.

```java
class Calculator {
int value;

    Calculator() {
        this.value = 0;
    }

void add(int val) {
        this.value += val;
    }

int getValue() {
return this.value;
    }
}
// 나의 풀이 
package JumpToJava;

class Calculator {
    int value;

    Calculator() {
        this.value = 0;
    }

    void add(int val) {
        this.value += val;
    }

    int getValue() {
        if(this.value >= 100) {   // 아래에서 주석 처리한 부분처럼 진행하면 여기 수정 불필요
            this.value = 100;
        }
        return this.value;
    }
}

class MaxLimitCalculator extends Calculator {
    void add (int val) {
        if (this.value >= 100) {
            return;
        } else {
            this.value += val;
        }
    }
		/* void add(int val) {
        this.value += val;
        if (this.value > 100) {
            this.value = 100;
        }
    } */
}

public class Q1 {
    public static void main(String[] args) {
        MaxLimitCalculator cal = new MaxLimitCalculator();
        cal.add(50);
        cal.add(700);
        System.out.println(cal.getValue());  // 100 출력
    }
}
```

> ※ 메서드 오버라이딩을 사용해 보자.

## **Q3**

다음의 클래스에 주어진 정수가 홀수인지 짝수인지 판별해 주는 메서드(isOdd)를 추가해 보자. (홀수이면 true, 짝수면 false를 리턴해야 한다.)

```java
class Calculator {
int value;

    Calculator() {
        this.value = 0;
    }

void add(int val) {
        this.value += val;
    }

int getValue() {
return this.value;
    }
}
package JumpToJava;

class Calculator {
    int value;

    Calculator() {
        this.value = 0;
    }

    void add(int val) {
        this.value += val;
    }

    int getValue() {
        if(this.value >= 100) {
            this.value = 100;
        }
        return this.value;
    }

    boolean isOdd() {
        if (this.value % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
		/* boolean isOdd(int num) {
        return num % 2 == 1;
    } */ 
}

public class Q1 {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        cal.add(12);
        System.out.println(cal.getValue());
        System.out.println(cal.isOdd());
    }
}
```

## **Q4**

다음 클래스에 정수 배열 또는 정수의 리스트 입력시 그 평균값을 구해 정수로 리턴하는 avg 메서드를 추가해 보자.

```java
class Calculator {
int value;

    Calculator() {
        this.value = 0;
    }

void add(int val) {
        this.value += val;
    }

int getValue() {
return this.value;
    }
}
```

정수 배열을 사용한 예는 다음과 같다.

```java
int[] data = {1, 3, 5, 7, 9};
Calculator cal = new Calculator();
int result = cal.avg(data);
System.out.println(result);  // 5 출력
```

정수 리스트를 사용한 예는 다음과 같다.

```java
ArrayList<Integer> data =new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9));
Calculator cal = new Calculator();
int result = cal.avg(data);
System.out.println(result);  // 5 출력
```

> ※ 메서드 오버로딩을 사용해 보자.

```java
//나의 풀이 
package JumpToJava;

import java.util.ArrayList;
import java.util.Arrays;

class Calculator {

    int value;

    Calculator() {
        this.value = 0;
    }

    void add(int val) {
        this.value += val;
    }

    int getValue() {
        if(this.value >= 100) {
            this.value = 100;
        }
        return this.value;
    }

    boolean isOdd() {
        if (this.value % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    int avg(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum / a.length;
    }
		
    int avg(ArrayList arrayList) {
        int sum = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            sum += (int) arrayList.get(i);
        }
        return sum / arrayList.size();
    }

		/* int avg(int[] data) {
        int total = 0;
        for (int num : data) {
            total += num;
        }
        return total / data.length;
    }

    int avg(ArrayList<Integer> data) {
        int total = 0;
        for (int num : data) {
            total += num;
        }
        return total / data.size();
    } */

}

public class Q1 {
    public static void main(String[] args) {

        int[] data = {1, 3, 5, 7, 9};
        Calculator cal = new Calculator();
        int result = cal.avg(data);
        System.out.println(result);    // 5 출력

        ArrayList<Integer> data2 = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9));
        int result2 = cal.avg(data2);
        System.out.println(result2);  // 5 출력
    }
}
```

## **Q5**

다음 프로그램의 출력결과를 예측하고 그 이유에 대해서 설명하시오.

```java
import java.util.ArrayList;
import java.util.Arrays;

public class Sample {
public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> b = a;
        a.add(4);
        System.out.println(b.size());
    }
}        !!   4가 출력 b가 a를 받았으니까   !!
					System.out.println(a==b); 로 확인도 가능
```

만약 b객체를 a객체와 동일한 값을 가지지만 독립적으로 생성하고 싶다면 다음과 같이 해야한다.

```java
import java.util.ArrayList;
import java.util.Arrays;

public class Sample {
public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> b = new ArrayList<>(a);
        a.add(4);
        System.out.println(b.size());  // 3 출력
        System.out.println(a == b);  // false 출력
    }
}
```

b 객체를 생성할때 a객체의 데이터를 기반으로 신규 객체로 생성했다. 이렇게 하면 a객체에 요소를 추가해도 b 객체에는 변화가 없고 `a == b` 로 동일한 객체인지 검사를 해보더라도 다르다는 것을 확인할 수 있다.

## **Q6**

다음은 Calculator 객체를 생성하고 값을 더한 후에 그 결과값을 출력하는 예제이다. 하지만 코드를 실행하면 오류가 발생한다. Calculator 클래스를 수정하여 다음의 코드에서 오류가 발생하지 않도록 하시오.

```java
class Calculator {
    Integer value;
void add(int val) {
        this.value += val;
    }

public Integer getValue() {
return this.value;
    }
}

public class Sample {
public static void main(String[] args) {
        Calculator cal =new Calculator();
				cal.add(3);  // 여기서 NullPointerException 이 발생한다.
        System.out.println(cal.getValue());
    }
}
// 나의 풀이
class Calculator {

    int value;
    void add(int val) {
        this.value += val;
    }

    public int getValue() {
        return this.value;
    }
}

public class Q1 {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        cal.add(3);  // 여기서 NullPointerException 이 발생한다.
        System.out.println(cal.getValue());
    }
}
```

`Integer` 자료형은 값을 대입하지 않을 경우 null이기 때문에 add 메서드에서 null에 값을 더하려고 하기 때문에 오류가 발생한다. 따라서 다음처럼 Calculator 클래스의 생성자를 만들고 초기값을 설정해야 한다.

```java
class Calculator {
    Integer value;

Calculator() {
        this.value = 0;
    }

void add(int val) {
        this.value += val;
    }

public Integer getValue() {
return this.value;
    }
}

public class Sample {
public static void main(String[] args) {
        Calculator cal =new Calculator();
        cal.add(3);
        System.out.println(cal.getValue());
    }
}
```

## **Q7**

다음은 광물의 가치를 계산하는 MineralCalculator 클래스와 그 사용법이 담긴 코드이다. 광물 계산기는 금인 경우 100, 은인 경우 90, 구리의 경우는 80의 가치를 더하는 기능(add 메스드)이 있다.

```java
class Gold {
}

class Silver {
}

class Bronze {
}

class MineralCalculator {
int value = 0;

public void add(Gold gold) {
        this.value += 100;
    }

public void add(Silver silver) {
        this.value += 90;
    }

public void add(Bronze bronze) {
        this.value += 80;
    }

public int getValue() {
return this.value;
    }
}

public class Sample {
public static void main(String[] args) {
        MineralCalculator cal =new MineralCalculator();
        cal.add(new Gold());
        cal.add(new Silver());
        cal.add(new Bronze());
        System.out.println(cal.getValue());  // 270 출력
    }
}
```

하지만 이 광물 계산기는 광물이 추가될 때마다 add 메서드를 추가해야 한다는 단점이 있다. 광물이 추가되더라도 MineralCalculator 클래스를 변경할 필요가 없도록 코드를 수정하시오.

> ※ Mineral 인터페이스를 생성하고 광물 클래스에 적용해 보자.

```java
interface Mineral{
    int add();
}

class Gold implements Mineral{
    public int add(){
        return 100;
    }
}

class Silver implements Mineral{
    public int add(){
        return 90;
    }
}

class Bronze implements Mineral{
    public int add(){
        return 80;
    }
}

class MineralCalculator {
    int value = 0;

    public void add(Mineral mineral) {
        this.value += mineral.add();
    }

    public int getValue() {
        return this.value;
    }
}

public class Q1 {
    public static void main(String[] args) {
        MineralCalculator cal =new MineralCalculator();
        cal.add(new Gold());
        cal.add(new Silver());
        cal.add(new Bronze());
        System.out.println(cal.getValue());  // 270 출력
    }
}
```

## **Q8**

다음의 코드를 보고 1번, 2번, 3번, 4번, 5번 문장 중에서 오류가 발생하는 문장을 모두 찾고 오류의 원인에 대해서 설명하시오.

```java
interface Predator {
}

class Animal {
}

class Dog extends Animal {
}

class Lion extends Animal implements Predator {
}

public class Sample {
public static void main(String[] args) {
        Animal a = new Animal();  // 1번
        Animal b = new Dog();  // 2번
        Animal c = new Lion();  // 3번
        Dog d = new Animal();  // 4번
        Predator e = new Lion();  // 5번
    }
}                
//  4번 자식 클래스가 부모 클래스를 선언하고 있기 때문에 IS-A 관계가 성립x
```

## **Q9**

다음의 코드를 보고 1번, 2번, 3번, 4번, 5번, 6번 문장 중에서 오류가 발생하는 문장을 모두 찾고 오류의 원인에 대해서 설명하시오.

```java
interface Predator {
    String bark();
}

abstract class Animal {
public String hello() {
return "hello";
    }
}

class Dog extends Animal {
}

class Lion extends Animal implements Predator {
public String bark() {
return "Bark bark!!";
    }
}

public class Sample {
public static void main(String[] args) {
        Animal a = new Lion();
        Lion b = new Lion();
        Predator c = new Lion();

        System.out.println(a.hello());  // 1번  x 
        System.out.println(a.bark());   // 2번  o Animal은 Predator와 별개
        System.out.println(b.hello());  // 3번  x
        System.out.println(b.bark());   // 4번  x
        System.out.println(c.hello());  // 5번  o Lion은 Predator만 참조여서
        System.out.println(c.bark());   // 6번  x
    }
}
```

ㅇ