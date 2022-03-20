------

**Q1**

다음 코드의 출력 결과는 무엇일까? (눈으로 해석하고 풀어보자.)

```java
public class Sample {
    public static void main(String[] args) {
        String a = "write once, run anywhere";
        if (a.contains("wife")) {
            System.out.println("wife");
        } else if (a.contains("once") && !a.contains("run")) {
            System.out.println("once");
        } else if (!a.contains("everywhere")) {
            System.out.println("everywhere");
        } else if (a.contains("anywhere")) {
            System.out.println("anywhere");
        } else {
            System.out.println("none");
        }
    }
}
everywhere 출력
```

## **Q2**

while문을 사용해 1부터 1000까지의 자연수 중 3의 배수의 합을 구해 보자.

```java
public class Main {
    public static void main(String[] args) {
        int sum = 0;
        int i = 1;

        while (i <= 1000) {
            i++;
            if (i % 3 == 0) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
```

## **Q3**

while문 또는 for 문을 사용하여 다음과 같이 별(`*`)을 표시하는 프로그램을 작성해 보자.

```
*
**
***
****
*****
`public class Main {
    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }
    }
}
```

## **Q4**

for문을 사용해 1부터 100까지의 숫자를 출력해 보자.

```java
public class Main {
	public static void main(String[] args) {
			for (int i = 1; i <= 100; i++) {
				System.out.println(i);
	}
}
```

## **Q5**

A 학급에 총 10명의 학생이 있다. 이 학생들의 중간고사 점수는 다음과 같다.

```
int[] marks = {70, 60, 55, 75, 95, 90, 80, 80, 85, 100};
```

for each 문을 사용하여 A 학급의 평균 점수를 구해 보자.

```java
public class Main {
    public static void main(String[] args) {
        int sum = 0;
        int[] marks = {70, 60, 55, 75, 95, 90, 80, 80, 85, 100};
        for (int avg : marks) {
            sum += avg;
        }
        float average = (float) sum / marks.length;
        System.out.println(average);
    }
}
```