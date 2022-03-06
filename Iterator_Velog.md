### **이터레이터 (Iterator) 란?**

> - Iterator는 **자바의** **컬렉션 프레임워크** (JCF)에서 컬렉션에 저장되어 있는 요소들을 읽어오는 방법을 표준화한 것이다. 
>
> - Iterator는 반복자로서 객체 지향적 프로그래밍에서 **배열이나 그와 유사한 자료구조의 내부요소를 순회하는 객체**다.
>
>   컬렉션 프레임워크란 데이터를 저장하는 클래스들을 표준화한 설계이다.
>
>   컬렉션에 프레임워크는 아래 그림과 같이 데이터를 저장하는 구조에 따라 **3가지 인터페이스**로 구성된다.



### **Java Collection Framework (JCF)**

> - Java에서 데이터를 저장하는 기본적인 자료구조들을 한 곳에 모아 관리 및 편하게 사용하기 위해서 제공하는 것을 의미한다.
>
>   다음은 JCF의 상속 구조이며 사용 용도에 따라 List, Set, Map 3가지로 요약할 수 있다.



![img](https://k.kakaocdn.net/dn/kBiGg/btqvRHqrCsc/nLsgMXBHArIcj0tdJ8ZRpK/img.png)

[이미지출처](![img](https://k.kakaocdn.net/dn/kBiGg/btqvRHqrCsc/nLsgMXBHArIcj0tdJ8ZRpK/img.png))

- **각 인터페이스의 특징**

| 인터페이스 |                   구현 클래스                    |                             특징                             |
| :--------: | :----------------------------------------------: | :----------------------------------------------------------: |
|    List    |   LinkedList<br>Stack<br/>Vector<br/>ArrayList   | **순서가 있는** 데이터의 집합, 데이터의 **중복을 허용**한다  |
|    Set     |               HashSet<br/>TreeSet                | 순서를 유지하지 않는 데이터의 집합, 데이터의 중복을 허용하지 않는다. |
|    Map     | HashMap<br/>TreeMap<br/>HashTable<br/>Properties | **키(key)와 값(value)**의 쌍으로 이루어진 데이터의 집합이다.<br/>순서는 유지되지 않고, 키는 중복을 허용하지 않으며 값의 중복을 허용한다. |

- **구현 클래스 세부 특징**

  

> **List Interface** : Collection 인터페이스를 확장한 자료형으로 요소들의 순서를 저장하여 색인(index)를 사용하여 특정 위치에 요소를 삽입하거나 접근할 수 있으며 중복 요소 허용
>
> - ArrayList
>
>   - 상당히 빠르고 크기를 마음대로 조절할 수 있는 배열
>   - 단방향 포인터 구조로 자료에 대한 순차적인 접근에 강점이 있음
>
> - Vector
>
>   - ArrayList의 구형버전이며, 모든 메소드가 동기화 되어있음, 잘 쓰이지 않음
>
> - LinkedList
>
>   - 양방향 포인터 구조로 데이터의 삽입, 삭제가 빈번할 경우 빠른 성능을 보장
>
>   - Stack, Queue, 양방향 Queue 등을 만들기 위한 용도로 쓰임
>
>     
>
> **Set Interface** : 집합을 정의하며 요소의 중복을 허용하지 않음. 상위 메소드만 사용함
>
> - HashSet
>   - 가장 빠른 임의 접근 속도, 순서를 전혀 예측할 수 없음
> - LinkedHashSet
>   - 추가된 순서, 또는 가장 최근에 접근한 순서대로 접근 가능
> - TreeSet
>   - 정렬된 순서대로 보관하여 정렬 방법을 지정할 수 있음
>
> 
>
> **Map Interface** : Key와 Value의 쌍으로 연관지어 저장하는 객체
>
> - HashMap
>   - Map 인터페이스를 구현하기 위해 해시테이블을 사용한 ㅡㅋㄹ래스
>   - 중복을 허용하지 않고 순서를 보장하지 않음
>   - 키와 값으로 null이 허용
> - Hashtable
>   - HashMap보다는 느리지만 동기화가 지원
>   - 키와 값으로 null이 허용되지 않음
> - TreeMap
>   - 이진검색트리의 형태로 키와 값의 쌍으로 이루어진 데이터를 저장
>   - 정렬된 순서로 키 & 값 쌍을 저장하므로 빠른 검색이 가능
>   - 저장시 정렬(오름차순)을 하기 때문에 저장시간이 다소 오래 걸림
> - LinkedHashMap
>   - 기본적으로 HashMap을 상속받아 HashMap과 매우 흡사
>   - Map에 있는 엔트리들의 연결 리스트가 유지되므로 입력한 순서대로 반복 가능



Iterator는 이런 집합체로부터 정보를 얻어낸다고 볼 수 있다. 집합체를 다룰 때는 개별적인 클래스에 대해 **데이터를 읽는 방법을 알아야 하기 때문에 각 컬렉션에 접근이 힘들어진다**. Iterator를 쓰게 되면 어떤 컬렉션이라도 동일한 방식으로 접근이 가능하기에 그 안에 있는 항목들에 접근할 수 있는 방법을 보다 쉽게 제공한다. (다형성) 

Iterator 메소드에는 

**hasNext()** : 읽어올 요소가 남아있는지 확인하는 메소드. 요소가 있으면 true, 없으면 false

**next()** : 다음 데이터를 반환

**remove()** : next()로 읽어온 요소를 삭제한다.

위 3가지가 있으며, 호출 순서는 hasNext() - > next() - > remove()이다.



다음은 Iterator를 사용하여 List에 들어있는 "자바", "파이썬", "자바스크립트" 중에서 "자바"를 삭제하는 예제이다.



```java
import java.util.ArrayList;
import java.util.Iterator;

public class IterPrac {
    public static void main(String[] args){
        
        System.out.println("List 생성");
        
        ArrayList list = new ArrayList();
        list.add("자바");
        list.add("파이썬");
        list.add("자바스크립트");
        
        Iterator iter = list.iterator();
        while(iter.hasNext() == true){
            String lan = (String) iter.next();
            if (lan == "자바") {
                iter.remove();                  
            }
            System.out.println("Lan : " + lan);
        }
        System.out.println("-------------------");
        iter = list.iterator();
        while(iter.hasNext() == true){
            String lan = (String) iter.next();
            System.out.println("Lan : " + lan);
        }
    }
}
```

![image-20220306231214425](C:\Users\WEON\AppData\Roaming\Typora\typora-user-images\image-20220306231214425.png)



다음과 같이 "자바"가 List에서 정상적으로 삭제 되었음을 알 수 있었다.

자료구조중 Set의 경우 idnex가 없기 때문에 일반 for문을 사용할 수 없지만, for-each문은 사용할 수 있다. 그러므로 Iterator 와 for-each 문을 활용한 예제들을 몇 가지 더 확인해 보고자 한다.



- ArrayList에 대한 예제

```java
import java.util.ArrayList;
import java.util.Iterator;

public class Main
{
    public static void main(String[] args)
    {
        //컬렉션 생성
        ArrayList<String> cars = new ArrayList<>();
        cars.add("벤츠");
        cars.add("아우디");
        cars.add("폭스바겐");
        cars.add("람보르기니");

        // iterator 획득
        Iterator<String> iter = cars.iterator();

        // While문을 사용한 경우
        while (iter.hasNext()){
            String str = iter.next();
            System.out.println(str);
        }

        // for-each 문을 사용한 경우
        for (String str : cars){
            System.out.println(str);

        }
    }
}

```

![image-20220306233201989](C:\Users\WEON\AppData\Roaming\Typora\typora-user-images\image-20220306233201989.png)

Iterator 와 for-each 모두 정상적으로 작동 되었다. 



- Set에 대한 예제

```java
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main{
    public static void main(String[] args){
        
        Set<String> cars = new HashSet<>();
        cars.add("벤츠");
        cars.add("아우디");
        cars.add("폭스바겐");
        cars.add("람보르기니");

        // while문을 사용한 경우
        Iterator<String> iter = cars.iterator();
        while(iter.hasNext()){
            System.out.println("cars : " + iter.next());
        }

        // for-each문을 사용한 경우
        for (String car : cars){
            System.out.println("cars : " + car);
        }
    }
}
```

![image-20220306233511354](C:\Users\WEON\AppData\Roaming\Typora\typora-user-images\image-20220306233511354.png)

순서를 유지하지 않으며 중복을 허용하지 않는 Set을 사용했기 때문에 출력 시 넣은 순서와 상관없이 값이 출력되는 것을 볼 수 있었다.

마지막으로 Iterator를 이용해 값을 수정하는 심화 예제를 확인해보자!

```java
import java.sql.Array;
import java.util.ArrayList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {

        // 컬렉션 생성
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("F");
        System.out.println("while문을 지나기 전 리스트에 들어있던 값 : " + list);

        // 리스트에 들어있는 각각의 값에 '+' 붙이기
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            Object element = listIterator.next();
            listIterator.set(element + "+");
        }
        System.out.println("while문을 지난 후 수정된 결과 : " + list);

        // 리스트에 들어있는 값을 역순으로 표시
        System.out.print("역순 출력 결과 : ");
        while (listIterator.hasPrevious()) {
            Object element = listIterator.previous();
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
```

![image-20220306234212975](C:\Users\WEON\AppData\Roaming\Typora\typora-user-images\image-20220306234212975.png)



ListIterator와 Object에 대한 추가적인 공부를 해봐야겠다.



### **Reference**

- https://thefif19wlsvy.tistory.com/m/41
- https://hackersstudy.tistory.com/26
- https://onlyfor-me-blog.tistory.com/319