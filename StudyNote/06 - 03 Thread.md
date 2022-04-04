# 06 - 03 Thread

------

동작하고 있는 프로그램을 프로세스라고 한다. 보통 한 개의 프로세스는 한 가지의 일을 하지만, 쓰레드를 이용하면 한 프로세스 내에서 두 가지 또는 그 이상의 일을 동시에 할 수 있다.

### Thread

------

```java
public class Main extends Thread {
	public void run() { // Thread 를 상속하면 run 메소드를 구현해야 한다.
		System.out.println("Thread run.");
}
	public static void main(String[] args) {
		Main main = new Main();
		main.start();  //start() 로 쓰레드를 실행한다.
	}
}
```

Main 클래스가 Thread 클래스를 상속했다. Thread 클래스의 run 메소드를 구현하면 위 예제와 같이 `sample.start()` 실행 시 Main 객체의 run 메소드가 수행된다.

> Thread 클래스를 extends 했기 때문에 start 메소드 실행시 run 메소드가 수행된다. Thread 클래스는 start 실행시 run 메소드가 수행되도록 내부적으로 동작한다.

위 예제를 실행하면 “Thread run” 이라는 문장이 출력 될 것이다. 하지만 위의 예처럼 쓰레드가 하나인 경우에는 도대체 쓰레드가 어떻게 동작되고 있는지 명확하지가 않다.

다음의 예제를 수정해 보자.

```java
public class Main extends Thread {
	int seq;

	public Main(int seq) {
		this.seq = seq;
}

public void run() {
	System.out.println(this.seq + " thread start. ");
	try {
				Thread.sleep(1000); // 1초 대기한다
	} catch (Exception e) {
	}
	System.out.println(this.seq + " thread ends. ");
}

public static void main(String[] args) {
	for(int i = 0; i < 10; i++) {
		Thread t = new Main(i);
		t.start();
	}
	System.out.println("main end.");
}
}
```

총 10개의 쓰레드를 실행시키는 예제이다. 어떤 쓰레드인지 확인하기 위해서 쓰레드마다 생성자에 순번을 부여했다. 그리고 쓰레드 메소드(run) 수행 시 시작과 종료를 출력하게 했고 시작과 종료 사이에 1초의 간격이 생기도록 (`Thread.sleep(1000)`) 작성했다.

결과는 다음과 비슷하게 나올 것이다.

```java
0 thread start. 
main end.
1 thread start. 
2 thread start. 
3 thread start. 
4 thread start. 
5 thread start. 
6 thread start. 
7 thread start. 
8 thread start. 
9 thread start. 
0 thread ends. 
1 thread ends. 
2 thread ends. 
3 thread ends. 
4 thread ends. 
5 thread ends. 
6 thread ends. 
7 thread ends. 
8 thread ends. 
9 thread ends.
```

0번 쓰레드부터 9번 쓰레드까지 순서대로 실행이 되지 않고 그 순서가 일정치 않은 것을 보면 쓰레드는 순서에 상관없이 동시에 실행된다는 사실을 알 수 있다. 더욱 재밌는 사실은 쓰레드가 종료되기 전에 main 메소드가 종료되었다는 사실이다. main 메소드 종료 시 “main end” 라는 문자열이 출력되는데 위 결과를 보면 중간쯤에 출력되어 있다.

### Join

------

위 예제를 보면 쓰레드가 모두 수행되고 종료되기 전에 main 메소드가 먼저 종료되어 버렸다. 그렇다면 모든 쓰레드가 종료된 후에 main 메소드를 종료시키고 싶은 경우에는 어떻게 해야 할까?

```java
import java.util.ArrayList;

public class Main extends Thread {
    int seq;
    public Main(int seq) {
        this.seq = seq;
    }

    public void run() {
        System.out.println(this.seq+" thread start.");
        try {
            Thread.sleep(1000);
        }catch(Exception e) {
        }
        System.out.println(this.seq+" thread end.");
    }

    public static void main(String[] args) {
        ArrayList<Thread> threads = new ArrayList<>();
        for(int i=0; i<10; i++) {
            Thread t = new Main(i);
            t.start();
            threads.add(t);
        }

        for(int i=0; i<threads.size(); i++) {
            Thread t = threads.get(i);
            try {
                t.join(); // t 쓰레드가 종료할 때까지 기다린다.
            }catch(Exception e) {
            }
        }
        System.out.println("main end.");
    }
}
```

생성된 쓰레드를 담기 위해서 ArryaList 객체인 threads를 만든 후 쓰레드 생성 시 생성된 객체를 threads 에 저장했다. 그리고 main 메소드가 종료되기 전에 threads에 담긴 각각의 thread에 join 메소드를 호출하여 쓰레드가 종료될 때까지 대기하도록 했다. 쓰레드의 join 메소드는 **쓰레드가 종료될 때까지 기다리게 하는 메소드이다.**

```java
0 thread start.
5 thread start.
2 thread start.
6 thread start.
9 thread start.
1 thread start.
7 thread start.
3 thread start.
8 thread start.
4 thread start.
0 thread end.
5 thread end.
2 thread end.
9 thread end.
6 thread end.
1 thread end.
7 thread end.
4 thread end.
8 thread end.
3 thread end.
main end.
```

“main end” 라는 문자열이 가장 마지막에 출력되는 것을 확인할 수 있다.

쓰레드 프로그래밍시 가장 많이 실수하는 부분이 바로 쓰레드가 종료되지 않았는데 쓰레드가 종료된 줄 알고 그 다음 로직을 수행하게 만드는 일이다. 쓰레드가 종료된 후 그 다음 로직을 수행해야 할 때 꼭 필요한 join 메소드를 꼭 기억하자.

### Runnable

------

보통 쓰레드 객체를 만들 때 위의 예처럼 Thread를 상속하여 만들기도 하지만 보통은 Runnable 인터페이스를 구현하도록 하는 방법을 주로 사용한다. 왜냐하면 Thread 클래스를 상속하면 다른 클래스를 상속할 수 없기 때문이다.

위에서 만든 예제를 Runnable 인터페이스를 사용하는 방식으로 변경해 보자.

```java
import java.util.ArrayList;

public class Main implements Runnable {
    int seq;
    public Main(int seq) {
        this.seq = seq;
    }

    public void run() {
        System.out.println(this.seq+" thread start.");
        try {
            Thread.sleep(1000);
        }catch(Exception e) {
        }
        System.out.println(this.seq+" thread end.");
    }

    public static void main(String[] args) {
        ArrayList<Thread> threads = new ArrayList<>();
        for(int i=0; i<10; i++) {
            Thread t = new Thread(new Main(i));
            t.start();
            threads.add(t);
        }

        for(int i=0; i<threads.size(); i++) {
            Thread t = threads.get(i);
            try {
                t.join();
            }catch(Exception e) {
            }
        }
        System.out.println("main end.");
    }
}
```

Thread를 extends 하던 것에서 Runnable을 implements 하도록 변경되었다.

> ※ Runnable 인터페이스는 run 메소드를 구현하도록 강제한다.

그리고 Thread 를 생성하는 부분을 다음과 같이 변경했다.

```java
Thread t = new Thread(new Sample(i));
```

Thread의 생성자로 Runnable 인터페이스를 구현한 객체를 넘길 수 있는데 이 방법을 사용한 것이다. 이렇게 변경된 코드는 이 전에 만들었던 예제와 완전히 동일하게 동작한다. 다만 인터페이스를 이용했으니 상속 및 기타 등등에서 좀 더 유연한 프로그램으로 발전했다고 볼 수 있겠다.