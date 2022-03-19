> # 04 - 07 Interface
>
> ------
>
> 인터페이스는 초보 개발자를 괴롭히는 단골손님이다. 인터페이스에 대한 개념없이 코드로만 이해하려고 하면 곧 미궁에 빠지게 된다. 이렇게 이해하기 힘든 인터페이스는 도대체 왜 필요하게 된 걸까?
>
> ### 인터페이스는 왜 필요한가?
>
> ------
>
> 다음은 어떤 동물원 사육사가 하는 일이다.
>
> > 난 동물원의 사육사이다.
>
> > 육식동물이 들어오면 난 먹이를 던져준다.
>
> > 호랑이가 오면 사과를 던져준다.
>
> > 사자가 오면 바나나를 던져준다.
>
> 이런 케이스를 코드로 담아보자. 다음과 같이 Animal, Tiger, Lion, Zookeeper 클래스를 작성하자
>
> ```java
> class Animal {
>   String name;
> 	void setName(String name) {
> 		this.name = name;
> 	}
> }
> 
> class Tiger extends Animal {
> }
> 
> class Lion extends Animal {
> }
> 
> class ZooKeeper {
> 	void feed (Tiger tiger) { // 호랑이가 오면 사과를 던져 준다.
> 		System.out.println("feed apple");
> }
> 
> 	void feed (Lion lion) { //사자가 오면 바나나를 던져 준다.
> 		System.out.println("feed banana");
> 	}
> }
> 
> public class Main {
> 	public static void main(String[] args) {
> 		ZooKeeper zk = new ZooKeeper();
> 		Tiger tiger = new Tiger();
> 		Lion lion = new Lion();
> 		zk.feed(tiger);
> 		zk.feed(lion);
> 	}
> }
> ```
>
> 이전 챕터에서 보았던 Dog 클래스와 마찬가지로 Animal을 상속한 Tiger와 Lion이 등장했다. 그리고 사육사 클래스인 Zookeeper 클래스를 위처럼 정의 하였다.
>
> Zookeeper 클래스는 호랑이가 왔을 때와 사자가 왔을 때 각각 다른 feed 메소드가 호출된다.
>
> > ※ ZooKeeper 클래스의 feed 메소드처럼 입력값의 자료형 타입이 다를 경우(위에서는 Tiger, Lion으로 서로 다르다) **메소드 명을 동일하게(여기서는 메소드명이 feed로 동일하다) 사용할 수 있다. 이런것을 메소드 오버로딩(Method overloading) 이라고 한다.**
>
> 자, 이제 다음을 생각해 보자.
>
> 동물원에 호랑이와 사자뿐이라면 Zookeeper 클래스는 더 이상 할 일이 없겠지만 악어, 표범 등이 계속 추가된다면 Zookeeper는 육식동물이 추가될 때마다 매번 다음과 같은 feed 메소드를 추가해야 한다.
>
> ```java
> class ZooKeeper {
>     void feed(Tiger tiger) {
>         System.out.println("feed apple");
>     }
> 
>     void feed(Lion lion) {
>         System.out.println("feed banana");
>     }
> 
>     public void feed(Crocodile crocodile) {
>         System.out.println("feed strawberry");
>     }
> 
>     public void feed(Leopard leopard) {
>         System.out.println("feed orange");
>     }
> }
> 
> ... (생략) ...
> ```
>
> 이렇게 매번 feed 메소드를 추가해야 한다면 사육사가 얼마나 귀찮겠는가? 이런 어려움을 극복하기 위해서는 인터페이스의 도움이 필요하다.
>
> ### 인터페이스 작성하기
>
> ------
>
> 다음과 같이 코드 상단에 육식동물(predator) 인터페이스를 추가하자.
>
> ```java
> interface Predator {
> }
> 
> class Animal {
>     String name;
> 
>     void setName(String name) {
>         this.name = name;
>     }
> }
> 
> ... (생략) ...
> ```
>
> 위 코드와 같이 인터페이스는 class가 아닌 `interface` 라는 키워드를 이용하여 작성한다.
>
> > 인터페이스는 클래스와 마찬가지로 Predator.java와 같은 단독 파일로 저장하는 것이 일반적인 방법이다. 여기서는 설명의 편의를 위해 Sample.java 파일의 최상단에 작성하였다.
>
> 그리고 Tiger, Lion 클래스는 작성한 인터페이스를 구현하도록(Implements) 수정하자.
>
> ```java
> ... (생략) ...
> 
> class Tiger extends Animal implements Predator {
> }
> 
> class Lion extends Animal implements Predator {    
> }
> 
> ... (생략) ...
> ```
>
> 인터페이스 구현은 위와같이 **implements** 라는 키워드를 사용한다.
>
> 이렇게 Tiger, Lion 클래스가 Predator 인터페이스를 구현하게 되면 Zookeeper 클래스의 feed 메소드를 다음과 같이 변경할 수 있다.
>
> ```java
> ... (생략) ...
> 
> class ZooKeeper {
>     void feed(Predator predator) {
>         System.out.println("feed apple");
>     }
> }
> 
> ... (생략) ...
> ```
>
> feed 메소드의 입력으로 Tiger, Lion을 각각 필요로 했지만 이제 이것을 Predator 라는 인터페이스로 대체할 수 있게 되었다. tiger, lion은 각각 Tiger, Lion의 객체이기도 하지만 Predator 인터페이스의 객체이기도 하기 때문에 위와 같이 Predator 자료형의 타입으로 사용할 수 있는 것이다. 상속에서 공부했던 IS-A 관계가 인터페이스에도 마찬가지로 적용된다. “Tiger (Lion) is a Predaor”가 성립된다.
>
> > 이와같이 객체가 한 개 이상의 자료형 타입을 갖게되는 특성을 다형성(폴리모피즘)이라고 하는데 이것에 대해서는 "다형성" 챕터에서 자세히 다루도록 한다.
>
> 이제 어떤 육식동물이 추가되더라도 Zookeeper는 feed 메소드를 추가할 필요가 없다. 다만 육식동물이 추가 될 때마다 다음과 같이 Predator 인터페이스를 구현한 클래스를 작성하기만 하면 되는 것이다.
>
> ### 인터페이스의 메소드
>
> ------
>
> 자, 그런데 위 ZooKeeper 클래스에 약간의 문제가 발생했다. 아래의 ZooKeeper클래스의 feed 메소드를 보면 호랑이가 오던지, 사자가 오던지 무조건 "feed apple" 이라는 문자열을 출력한다. 사자가 오면 "feed banana" 를 출력해야 하지 않겠는가!
>
> ```java
> ... (생략) ...
> 
> class ZooKeeper {
>     public void feed(Predator predator) {
>         System.out.println("feed apple");  // 항상 feed apple 만을 출력한다.
>     }
> }
> 
> ... (생략) ...
> ```
>
> 이번에도 인터페이스를 사용해 보자.
>
> Predator 인터페이스에 다음과 같은 메소드를 추가해 보자.
>
> ```java
> interface Predator {
>     String getFood();
> }
> 
> ... (생략) ...
> ```
>
> getFood 라는 메소드를 추가했다. 그런데 좀 이상하다. 메소드에 몸통이 없다.
>
> 인터페이스의 메소드는 메소드의 이름과 입출력에 대한 정의만 있고 그 내용은 없다. 그 이유는 인터페이스는 규칙이기 때문이다. 위에서 설정한 getFood 라는 메소드는 인터페이스를 implements 한 클래스들이 구현해야만 하는 것이다.
>
> 인터페이스에 위처럼 메소드를 추가하면 Tgier, Lion 등의 Predator 인터페이스를 구현한 클래슫르에서 컴파일 오류가 발생할 것이다. 오류를 해결하려면 다음처럼 Tiger, Lion 클래스에 getFood 메소드를 구현해야 한다.
>
> ```java
> ... (생략) ...
> 
> class Tiger extends Animal implements Predator {
>     public String getFood() {
>         return "apple";
>     }
> }
> 
> class Lion extends Animal implements Predator {
>     public String getFood() {
>         return "banana";
>     }
> }
> 
> ... (생략) ...
> ```
>
> > 인터페이스의 메소드는 **항상 public 으로 구현애야 한다.**
>
> Tiger, Lion 클래스의 getFood 메소드에 육식동물의 먹이인 “apple”, “banana”를 각각 리턴하도록 작성했다. 이렇게 getFood 메소드를 추가하면 컴파일 오류가 해결될 것이다.
>
> 이제 Zookeeper 클래스도 다음과 같이 변경이 가능하다.
>
> ```java
> ... (생략) ...
> 
> class ZooKeeper {
>     void feed(Predator predator) {
>         System.out.println("feed "+ predator.getFood());
>     }
> }
> 
> ... (생략) ...
> ```
>
> feed 메소드가 “feed apple”을 출력하던 것에서 `"feed" + predator.getFood()` 를 출력하도록 변경했다. predator.getFodd() 를 호출하면 Predaotr 인터페이스를 구현한 구현체(Tgier, Lion)의 getFood() 메소드가 호출된다.
>
> ### 인터페이스의 핵심과 개념
>
> ------
>
> 이번 장에서 가장 중요한 부분은 왜 인터페이스가 필요한지에 대해서 이해하는 것이다.
>
> 육식 동물들의 종류만큼 feed 메소드가 필요했던 Zookeeper 클래스를 Predator 인터페이스를 이용하여 구현했더니 단 한개의 feed 메소드로 구현이 가능해졌다. 여기서 중요한 점은 메소드의 갯수가 줄어들었다는 점이 아니라 **Zookeeper 클래스가 동물들의 종류에 의존적인 클래스에서 동물들의 종류와 상관없는 독립적인 클래스가 되었다는 점이다. 바로 이 점이 인터페이스의 핵심이다.**
>
> 이번에는 좀 더 개념적으로 인터페이스를 생각해 보자. 아마도 여러분은 컴퓨터의 USB 포트에 대해서 알고 있을 것이다. USB 포트에 연결할 수 있는 기기는 하드디스크, 메모리스틱, 스마트폰 등 무척 많다. 바로 이 USB 포트가 물리적 세계의 인터페이스라고 할 수 있다. USB 포트의 규격만 알면 어떤 기기도 만들 수 있다. 또 컴퓨터는 USB 포트만 제공하고 어떤 기기가 만들어지는 지 신경쓸 필요가 없다. 바로 이 점이 인터페이스와 매우 비슷하다. 위에서 만든 사육사가 어떤 육식동물이던지 상관하지 않고 먹이를 주는 것처럼 말이다.
>
> **상속과 인터페이스**
>
> 위에서 작성한 Predator 인터페이스 대신 Animal 클래스에 getFood 메소드를 추가하고 Tgier, Lion 등에서 getFood 메소드를 오버라이딩 한 후 Zookeeper의 feed 메소드가 Predator 대신 Animal을 입력 자료형으로 사용해도 동일한 효과를 거둘 수 있다. 하지만 상속은 자식 클래스가 부모 클래스의 메소드를 오버라이딩하지 않고 사용할 수 있기 때문에 해당 메소드를 반드시 구현해야 한다는 “강제성”을 갖지 못한다. 상황에 맞게 상속을 사용할 것인지 인터페이스를 사용해야 할 것인지를 결정해야 겠지만, 인터페이스는 인터페이스의 메소드를 반드시 구현해야 하는 “강제성”을 갖는다는 점을 반드시 기억하자.
>
> ### 디폴트 메서드
>
> ------
>
> 자바8 버전 이후부터는 디폴트 메서든(default method)를 사용할 수 있다. 인터페이스의 메서드는 몸통(구현체)을 가질 수 없지만 디폴트 메서드를 사용하면 실제 구현된 형태의 메서드를 가질 수 있다.
>
> 예를들어 Predator 인터페이스에 다음과 같은 디폴트 메서드를 추가할 수 있다.
>
> ```java
> interface Predator {
>     String getFood();
> 
> default void printFood() {
>         System.out.printf("my food is %s\\n", getFood());
>     }
> }
> ```
>
> 디폴트 메서드는 메소드명 가장 앞에 "default" 라고 표기해야 한다. 이렇게 Predator 인터페이스에 printFood 디폴트 메서드를 구현하면 Predator 인터페이스를 구현한 Tiger, Lion 등의 실제 클래스는 printFood 메서드를 구현하지 않아도 사용할 수 있다. 그리고 디폴트 메스드는 오버라이딩이 가능하다. 즉, printFood 메서드를 실제 클래스에서 다르게 구현하여 사용할수 있다.
>
> ## **스태틱 메서드**
>
> ------
>
> 자바8 버전 이후부터는 인터페이스에 스태틱 메서드(static method)를 사용할 수 있다. 인터페이스에 스태틱 메서드를 구현하면 `인터페이스명.스태틱메서드명` 과 같이 사용하여 일반 클래스의 스태틱 메서드를 사용하는 것과 동일하게 사용할 수 있다.
>
> 예를들어 Predator 인터페이스에 다음과 같은 스태틱 메서드를 추가할 수 있다.
>
> ```java
> interface Predator {
>     String getFood();
> 
> default void printFood() {
>         System.out.printf("my food is %s\\n", getFood());
>     }
> 
> int LEG_COUNT = 4;  // 인터페이스 상수
> 
> static int speed() {
> return LEG_COUNT * 30;
>     }
> }
> ```
>
> 이렇게 스태틱 메서드를 추가하면 다음과 같이 사용할수 있다.
>
> ```java
> Predator.speed();
> ```
>
> **인터페이스 상수**
>
> 위 코드에서 사용한 `int LEG_COUNT = 4;` 문장은 인터페이스에 정의한 상수이다. 인터페이스에 정의한 상수는 `int LEG_COUNT=4;` 처럼 `public static final`을 생략해도 자동으로 `public static final`이 적용된다. (다른 형태의 상수 정의는 불가능하다.)
>
> > public, static, final 키워드는 6장에서 자세히 알아본다.