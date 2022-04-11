------

자바는 웹, 모바일, GUI, 네트워크, 딥러닝 등 상당히 많은 일을 할 수 있는 언어이다. 여러분이 지금까지 배운 내용을 충분히 숙지했다면 이제 이들을 향해 첫발을 내디딜 준비를 마친 것이다. 하지만 그전에 여기에 준비한 문제들을 풀어 보면서 여러분이 얼마나 자바에 익숙해졌는지 점검해 보도록 하자.

이곳에 준비한 문제들은 조금 어려울 수 있다. 하지만 자바와 함께라면 이 문제들을 해결하는 과정 역시 또 하나의 즐거움이라는 것을 분명 느끼게 될 것이다.

그럼 아무쪼록 즐거운 시간이 되기를 바란다!!

## **Q1 문자열 바꾸기**

다음과 같은 문자열이 있다.

```
a:b:c:d
```

문자열의 split와 join 메서드를 사용하여 위 문자열을 다음과 같이 고치시오.

```java
a#b#c#d
```



```java
package JumpToJava;

public class Main {
    public static void main(String[] args) {

        // 문자열 선언
        String temp = "a:b:c:d";  
        
        // #으로 합치는데 :을 단위로 쪼개고 합침
        String tempArr = String.join("#", temp.split(":"));
        
        System.out.println(tempArr);

    }
}
```

## **Q2 맵에서 값 추출하기**

다음은 맵 a에서 "C"라는 key에 해당하는 value를 출력하는 프로그램이다.

```java
import java.util.HashMap;

public class Sample {
    public static void main(String[] args)  {
        HashMap<String, Integer> a = new HashMap<>();
        a.put("A", 90);
        a.put("B", 80);
        System.out.println(a.get("C"));  // null 출력
    }
}
```

a 맵에는 'C'라는 key가 없으므로 위처럼 null이 출력된다. 'C'에 해당하는 key 값이 없을 경우 null 대신 70을 얻을 수 있도록 수정하시오.

```java
package JumpToJava;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        HashMap<String, Integer> a = new HashMap<>();
        a.put("A", 90);
        a.put("B", 80);

        if (a.get("C") == null) {
            a.put("C", 70);
        }
        System.out.println(a.get("C"));

    }
}
```

## **Q3 50점 이상 점수의 총합 구하기**

다음은 A학급 학생의 점수를 나타내는 정수 배열이다. 다음 배열에서 50점 이상 점수의 총합을 구하시오.

```
int[] A = {20, 55, 67, 82, 45, 33, 90, 87, 100, 25};
package JumpToJava;

public class Main {
    public static void main(String[] args) {

        int[] A = {20, 55, 67, 82, 45, 33, 90, 87, 100, 25};

        int sum = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 50) {
                sum += A[i];
            }
        }
            System.out.println(sum);
    }
}
```

## **Q4 피보나치 함수**

첫 번째 항의 값이 0이고 두 번째 항의 값이 1일 때, 이후에 이어지는 항은 이전의 두 항을 더한 값으로 이루어지는 수열을 피보나치 수열이라고 한다.

```
0, 1, 1, 2, 3, 5, 8, 13, ...
```

입력을 정수 n으로 받았을 때, n 이하까지의 피보나치 수열을 출력하는 프로그램을 작성해 보자.

```java
package JumpToJava;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 피보나치 함수 0, 1, 1, 2, 3, 5, 8, 13, ....

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int sum = 0;

        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);
        list.add(1);

            for (int i = 0; i < n; i++) {
             sum = list.get(i) + list.get(i+1);
                list.add(sum);
            }
        System.out.println(sum);
    }
}
```

## **Q5 한 줄 구구단**

사용자로부터 2~9의 숫자 중 하나를 입력받아 해당 숫자의 구구단을 한 줄로 출력하는 프로그램을 작성하시오.

실행 예)

```
구구단을 출력할 숫자를 입력하세요(2~9): 2
2 4 6 8 10 12 14 16 18
package JumpToJava;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //구구단을 출력할 숫자를 입력하세요(2~9): 2
        //2 4 6 8 10 12 14 16 18
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i < 10; i++) {
            System.out.print(n * i + " ");
        }

    }
}
```

## **Q6 입력 숫자의 총합 구하기**

사용자로부터 다음과 같은 숫자를 입력받아 입력받은 숫자의 총합을 구하는 프로그램을 작성하시오. (단 숫자는 콤마로 구분하여 입력한다.)

```
65,45,2,3,45,8
package JumpToJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //65,45,2,3,45,8
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        String[] arr = s.split(",");

        List<Integer> list = new ArrayList<>();
        
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            list.add(Integer.parseInt(arr[i]));
        }

        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        System.out.println(sum);
    }
}
```

## **Q7 역순 저장**

다음과 같은 내용의 파일 abc.txt가 있다.

```
AAA
BBB
CCC
DDD
EEE
```

이 파일의 내용을 다음과 같이 역순으로 바꾸어 result.txt 파일에 저장하시오.

```
EEE
DDD
CCC
BBB
AAA
package JumpToJava;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        PrintWriter pw = new PrintWriter("abc.txt");
        pw.println("AAA\\nBBB\\nCCC\\nDDD\\nEEE");
        pw.close();

        ArrayList<String> list = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader("abc.txt"));
        while (true) {
            String read = br.readLine();
            if (read == null) {
                break;
            }
            list.add(read);
        }
        br.close();

        list.sort(Comparator.reverseOrder());
        System.out.println(list);

        PrintWriter pw2 = new PrintWriter("result.txt");
        for (int i = 0; i < list.size(); i++) {
            pw2.println(list.get(i));
        }
        pw2.close();
    }
}
```

## **Q8 평균값 구하기**

다음과 같이 총 10줄로 이루어진 abc.txt 파일이 있다. sample.txt 파일의 숫자 값을 모두 읽어 총합과 평균 값을 구한 후 평균 값을 result.txt 파일에 쓰는 프로그램을 작성하시오.

```
70
60
55
75
95
90
80
80
87
100
package JumpToJava;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("sample2.txt"));

        ArrayList<String> list = new ArrayList<>();

        while (true) {
            String line = br.readLine();
            if (line == null) break;
            list.add(line);
        }
        br.close();

        ArrayList<Integer> numlist = new ArrayList<>();
        int sum = 0;
        int avg = 0;

        for (int i = 0; i < list.size(); i++) {
            numlist.add(Integer.valueOf(list.get(i)));
            sum += numlist.get(i);
        }
        avg = sum / numlist.size();

        PrintWriter pw = new PrintWriter(new FileWriter("result.txt"));
        pw.println(sum + "\\n" + avg);
        pw.close();
    }
}
```

## **Q9 사칙연산 계산기**

다음과 같이 동작하는 클래스 Calculator를 작성하시오.

```java
public classSample {
	public static void main(String[] args) {
		int[] data1 = {1,2,3,4,5};
        Calculator cal1 = new Calculator(data1);
        System.out.println(cal1.sum()); // 15 출력
        System.out.println(cal1.avg()); // 3.0 출력

		int[] data2 = {6,7,8,9,10};
        Calculator cal2 = new Calculator(data2);
        System.out.println(cal2.sum()); // 40 출력
        System.out.println(cal2.avg()); // 8.0 출력
    }
}
package JumpToJava;

public class Main {
    public static class Calculator { // 이중 클래스라 static
        private int[] arr;
        private int sum = 0;
        private double avg = 0;

        public Calculator(int[] a) {
            this.arr = a;
        }

        public int sum() {
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
            }
            return sum;
        }

        public double avg() {
            this.avg = sum / arr.length;
            return avg;
        }
    }

    public static void main(String[] args) {

        int[] data1 = {1, 2, 3, 4, 5};
        Calculator cal = new Calculator(data1);
        System.out.println(cal.sum());
        System.out.println(cal.avg());

        int[] data2 = {6, 7, 8, 9, 10};
        Calculator cal2 = new Calculator(data2);
        System.out.println(cal2.sum());
        System.out.println(cal2.avg());
    }
}
```

## **Q10 오류에 상관없이 모두 수행하기**

다음은 Random 클래스를 사용하여 0~10 사이의 숫자를 무작위로 생성한 후 그 숫자로 execute 함수를 10회 호출하는 프로그램이다. execute 함수는 입력 숫자가 짝수인 경우에는 "짝수입니다." 를 출력하지만 홀수인 경우에는 OddException을 발생시킨다.

> ※ Random 클래스의 nextInt(범위) 메서드는 범위내의 정수 중 임의의 정수(난수)를 리턴한다.

```java
import java.util.Random;

class OddException extends Exception {
}

public class Sample {
		static void execute(int n)throws OddException {
        System.out.printf("입력 숫자: %d\\n", n);
				if (n % 2 == 1) {  // 홀수이면 OddException이 발생한다.
					throw new OddException();
        }
        System.out.println("짝수입니다.");
    }

public static void main(String[] args) {
        Random r = new Random();
						try {
								for (int i = 0; i < 10; i++) {
	                execute(r.nextInt(10));
	            }
	        }catch (OddException e) {
	            e.printStackTrace();
        }
    }
}
```

이 프로그램은 10회의 execute 메서드 호출 시 입력 숫자가 홀수인 경우 프로그램이 즉시 종료된다. OddException이 발생하더라도 프로그램이 종료되지 않고 10회 모두 호출될 수 있도록 프로그램을 수정하시오.

```java
package JumpToJava;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

class OddException extends Exception {
}

public class Main {
    static void execute(int n) throws OddException {
        System.out.printf("입력 숫자: %d\\n", n);

        if (n % 2 == 1) {  // 홀수이면 OddException이 발생한다.
            throw new OddException();

        }
        System.out.println("짝수입니다.");
    }

    public static void main(String[] args) {
        Random r = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        try {
            for (int i = 0; i < 10; i++) {
                int temp =  list.get(r.nextInt(10));
                execute(temp);
                list.remove(temp);
                System.out.println(list + " test");
            }
        } catch (OddException e) {
            e.printStackTrace();
        }
        finally {

        }
    }
}
```

## **Q11 DashInsert 함수**

DashInsert 메서드 숫자로 구성된 문자열을 입력받은 뒤 문자열 안에서 홀수가 연속되면 두 수 사이에 `-` 를 추가하고, 짝수가 연속되면 `*` 를 추가하는 기능을 갖고 있다. DashInsert 메서드를 완성하시오.

```
입력 예시: 4546793
출력 예시: 454*67-9-3
```

## **Q12 문자열 압축하기**

문자열을 입력받아 같은 문자가 연속적으로 반복되는 경우에 그 반복 횟수를 표시해 문자열을 압축하여 표시하시오.

```
입력 예시: aaabbcccccca
출력 예시: a3b2c6a1
```

## **Q13 Duplicate Numbers**

0~9의 문자로 된 숫자를 입력받았을 때, 이 입력값이 0~9의 모든 숫자를 각각 한 번씩만 사용한 것인지 확인하는 프로그램을 작성하시오.

```
입력 예시: 0123456789 01234 01234567890 6789012345 012322456789
출력 예시: true false false true false
```

## **Q14 모스 부호 해독**

문자열 형식으로 입력받은 모스 부호(dot:`.` dash:`-`)를 해독하여 영어 문장으로 출력하는 프로그램을 작성하시오.

- 글자와 글자 사이는 공백 1개, 단어와 단어 사이는 공백 2개로 구분한다.
- 예를 들어 다음 모스 부호는 "HE SLEEPS EARLY"로 해석해야 한다.

```
.... .  ... .-.. . . .--. ...  . .- .-. .-.. -.--
```

*모스부호 규칙 표*

| 문자 | 부호 | 문자 1 | 부호 1 |
| ---- | ---- | ------ | ------ |
| A    | .-   | N      | -.     |
| B    | -... | O      | ---    |
| C    | -.-. | P      | .--.   |
| D    | -..  | Q      | --.-   |
| E    | .    | R      | .-.    |
| F    | ..-. | S      | ...    |
| G    | --.  | T      | -      |
| H    | .... | U      | ..-    |
| I    | ..   | V      | ...-   |
| J    | .--- | W      | .--    |
| K    | -.-  | X      | -..-   |
| L    | .-.. | Y      | -.--   |
| M    | --   | Z      | --..   |

## **Q15 시저 암호 풀기**

시저 암호는, 고대 로마의 황제 줄리어스 시저가 만들어 낸 암호인데, 예를 들어 알파벳 A를 입력했을 때, 그 알파벳의 n개 뒤에 오는 알파벳이 출력되는 것이다. 예를 들어 바꾸려는 단어가 "CAT"고, n을 5로 지정하였을 때 "HFY"가 되는 것이다.

어떠한 암호를 만들 문장과 n을 입력했을 때 암호를 만들어 출력하는 프로그램을 작성하시오.

> ※ 알파벳은 A~Z 까지의 대문자만 사용한다.