### **문제**

> - 9개의 서로 다른 자연수가 주어질 때, 이들 중 최댓값을 찾고 그 최댓값이 몇 번째 수인지를 구하는 프로그램을 작성하시오.
>
>   예를 들어, 서로 다른 9개의 자연수
>
>   3, 29, 38, 12, 57, 74, 40, 85, 61
>
>   이 주어지면, 이들 중 최댓값은 85이고, 이 값은 8번째 수이다.
>
> - 출력 예시)
>
>   85
>
>   8

### **풀이과정**

```java
import java.util.Scanner;

public class ArrayWithFor_2562 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = new int[9];
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
    }
}  
```

우선 배열의 입력을 Scanner와  for문을 활용하여 정해진 배열의 길이(9) 만큼 입력을 받을 수 있도록 하였다.  이후, 입력받은 배열 안에서 각 index들의 크기를 비교한 후에 가장 큰 값을 가진 index를 출력 하면 된다. 

이를 위한 식은 다음과 같다

```java
import java.util.Scanner;

public class ArrayWithFor_2562 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = new int[9];

        int index = 0;
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        for (int j = 0; j < arr.length; j++) {
            if (max < arr[j]) {
                max = arr[j]; // 최대값으로 지정해서 저장
//                #1 System.out.printf("max = arr[%d] = %d\n", j, arr[j]);

                index = j; // 저장된 최대값을 바탕으로 몇번째 인덱스인지 저장
//                #2 System.out.printf("index = %d\n", j);
//                	 System.out.println(arr[0] + " " + arr[1] + " " + arr[2] + " " + arr[3] + " " + arr[4] + " " + arr[5] + " " + arr[6] + " " + arr[7] + " " + arr[8]);
//             #공백으로 구분 System.out.println(" "); // 정렬된 배열 출력하기
            }
        }
        System.out.println(arr[index]);
        System.out.println(index + 1);
    }
}
```

변수 <u>index와</u> <u>max를</u> 선언하고 값을 0으로 둔 이유는 후에 for문 #<u>1과</u> #<u>2의</u> 과정을 위한 것인데 max 값보다 <u>arr</u>[j]의 값이 클 경우 *max* 값에 arr[j]의 값을 저장하고 index 값에 <u>j</u> 값을 저장하여 확인하기 위함이다. 위 식을 통해 예제와 같이 85와 8이 출력됨을 알 수 있었다.

2562번 문제를 풀면서 이전에 친구와 같이 풀었던 for문을 활용한 배열 정렬 문제가 떠올랐고 위 예제를 활용하여 만들어 보기로 하였다.

우선 첫 번째로 만들어 낸 정렬은 **삽입정렬**이다. 삽입정렬을 의도하고 만든 것은 아니지만 이전에 친구와 같이 풀었던 문제를 떠올리며 만들다보니 삽입정렬이 만들어졌다.



### **삽입 정렬(Insertion Sort) **

> - 이미 정렬되어 있는 자료구조에 자료를 하나씩 삽입하는 경우, 오버헤드가 적기 때문에 최선의 알고리즘이 된다.
> - 개념 (오름차순 정렬 기준)
>   - 아직 작업하지 않은 원소를 이미 정렬 완료된 앞의 원소보단 크고, 뒤에 원소보단 작은 위치에 삽입하는 방법이다.



 **예제 (오름차순 정렬 기준)**

![img](https://media.vlpt.us/images/hwamoc/post/4baaa2bc-d48a-4f3b-a063-6538f6f59971/%EC%82%BD%EC%9E%851.gif)[이미지출처](https://gfycat.com/ko/densebaggyibis)

> - 단점으로는 배열의 크기가 커질수록 효율이 떨어진다



위 예제와 내가 만든 식을 비교해보자.

```java
// 삽 입 정 렬

import java.util.Scanner;

public class ArrayWithFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[9];

        int temp = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    temp = arr[i]; // temp값에 [i]값 저장      스와핑
//                 #1 System.out.printf("temp = arr[%d] : %d\n", i, temp);

                    arr[i] = arr[j]; // [i]값에 [j]값 저장       스와핑
//                 #2 System.out.printf("arr[i = %d] : ", i);
//                    System.out.println(arr[i]);
                    arr[j] = temp; // [j]값에 temp값 저장        스와핑
//                 #3 System.out.printf("arr[j = %d] : ", j);
//                    System.out.println(arr[j]);

//                 #4 System.out.println(arr[0] + " " + arr[1] + " " + arr[2] + " " + arr[3] + " " + arr[4] + " " + arr[5] + " " + arr[6] + " " + arr[7] + " " + arr[8]);
//                    System.out.println(" "); // 정렬된 배열 출력하기
                    // 3 29 38 12 57 74 40 85 61
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}

```

> 안쪽 for문이 돌아가면서 temp, arr[i], arr[j]의 값들이 스와핑 된다. 이를통해
>
> { 3 29 38 12 57 74 40 85 61 }
>
> temp = arr[0] : 3
> arr[i = 0] : 29
> arr[j = 1] : 3
> 29 3 38 12 57 74 40 85 61
>
> temp = arr[0] : 29
> arr[i = 0] : 38
> arr[j = 2] : 29
> 38 3 29 12 57 74 40 85 61
>
> temp = arr[0] : 38
> arr[i = 0] : 57
> arr[j = 4] : 38
> 57 3 29 12 38 74 40 85 61
>
> .	.	.
>
> temp = arr[7] : 74
> arr[i = 7] : 85
> arr[j = 6] : 74
> 3 12 29 38 40 57 74 85 61
>
> temp = arr[8] : 61
> arr[i = 8] : 74
> arr[j = 6] : 61
> 3 12 29 38 40 57 61 85 74
>
> temp = arr[8] : 74
> arr[i = 8] : 85
> arr[j = 7] : 74
> 3 12 29 38 40 57 61 74 85

이와 같이 앞과 뒤를 비교해가며 지속적으로 위치를 변환시켜 결국에는 오름차순으로 정렬이 완료된다. 위 학습을 통해서 삽입정렬의 기본적인 개념과 작동 원리를 어느정도는 이해할 수 있게 되었지만, 아직은 완벽하게 이해하기가 어려운 것 같다.

다음으로 만들어 낸 것은 **선택정렬**이다. 



### **선택정렬(Selection Sort)**

> - 개념 (오름차순 정렬 기준)
>
>   - 수열을 선형 탐색해서 최솟값을 찾는다.
>
>     최솟값을 열의 왼쪽 끝에 있는 값과 교환하고 정렬을 완료한다.
>
>     (최솟값이 이미 왼쪽 끝에 있으면 아무런 작업도 하지 않는다)
>
>     동일한 작업을 모든 값이 정렬을 마칠 때까지 반복한다.



**예제** (오름차순 정렬 기준)

![img](https://media.vlpt.us/images/hwamoc/post/4adce14a-bb45-4c39-8253-ae5665991156/%EC%84%A0%ED%83%9D1.gif)[이미지출처](https://hudi.kr/%EC%A0%95%EB%A0%AC-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-1-%EC%84%A0%ED%83%9D-%EC%A0%95%EB%A0%AC-selection-sort/selectionsort/)



내가 만든 선택정렬은 다음과 같다.

```java
// 선 택 정 렬

import java.util.Scanner;

public class ArrayWithFor2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = new int[9];

        int tmp = 0;
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        for (int i = 0; i < arr.length; i++) {
            int min = 9999;
            for (int j = i; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j]; // 최소값으로 지정해서 저장
//                    System.out.printf("min = arr[%d] = %d\n", j, arr[j]);

                    index = j; // 저장된 최소값을 바탕으로 몇번째 인덱스인지 저장
//                    System.out.printf("index = %d\n", j);
//                    System.out.println(arr[0] + " " + arr[1] + " " + arr[2] + " " + arr[3] + " " + arr[4] + " " + arr[5] + " " + arr[6] + " " + arr[7] + " " + arr[8]);
//                    System.out.println(" "); // 정렬된 배열 출력하기
                }
            }
            tmp = arr[i]; // jFor문을 통해 찾은 min 값과의 스와핑 과정
//            System.out.printf("tmp = arr[%d] = %d\n", i, arr[i]);

            arr[i] = arr[index];
//            System.out.printf("arr[%d] = arr[%d] = %d\n", i, index, arr[index]);

            arr[index] = tmp;
//            System.out.printf("arr[%d] = tmp = %d\n", index, tmp);
//            System.out.println(arr[0] + " " + arr[1] + " " + arr[2] + " " + arr[3] + " " + arr[4] + " " + arr[5] + " " + arr[6] + " " + arr[7] + " " + arr[8]);
//            System.out.println(" "); // 정렬된 배열 출력하기
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
```

> 이중 for문 중 안쪽 for문이 돌아가면서 min, arr[i], index 값을 저장하고 저장된 값을 바탕으로 바깥 for문에서 tmp, arr[i], arr[index] 값을 스와핑하여 예제와 같이 지정된 값을 배열의 왼쪽 끝으로 오름차순으로 정렬한다. (삽입정렬도 마찬가지지만 내림차순으로 변경하고 싶은 경우에는  if의 조건을 변경해주면 된다. )
>
> 
>
> { 3 29 38 12 57 74 40 85 61 }
>
> min = arr[0] = 3
> index = 0
> 3 29 38 12 57 74 40 85 61
>
> tmp = arr[0] = 3
> arr[0] = arr[0] = 3
> arr[0] = tmp = 3
> 3 29 38 12 57 74 40 85 61
>
> min = arr[1] = 29
> index = 1
> 3 29 38 12 57 74 40 85 61
>
> min = arr[3] = 12
> index = 3
> 3 29 38 12 57 74 40 85 61
>
> tmp = arr[1] = 29
> arr[1] = arr[3] = 12
> arr[3] = tmp = 29
> 3 12 38 29 57 74 40 85 61
>
> .	.	.
>
> min = arr[8] = 85
> index = 8
> 3 12 29 38 40 57 61 74 85
>
> tmp = arr[8] = 85
> arr[8] = arr[8] = 85
> arr[8] = tmp = 85
> 3 12 29 38 40 57 61 74 85

위에서 보는 바와 같이 선택정렬은 삽입정렬과 다르게 처음부터 끝까지 맨 왼쪽의 값 (3)이 변하지 않고 고정된채로 오름차순으로 정렬되고 있음을 확인할 수 있었다. 

이번 배열 정렬에 관한 학습을 통해 좀 더 수학적 사고에 대한 이해와 학습이 필요하다는 것을 알게 되었으며, 삽입, 선택 정렬에 대한 개념과 원리에 대해서 보다 자세하게 알 수 있게 되었다!

