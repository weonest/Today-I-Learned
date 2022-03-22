------

> # 05 - 01 Console
>
> ------
>
> **콘솔이란**
>
> 콘솔은 환경에 따라 변경될 수 있다. 만약 이 프로그램을 인텔리제이에서 실행했다면 인텔리제이의 콘솔창이 콘솔될 것이고 윈도우 명령창에서 이 프로그램을 실행했다면 명령창이 콘솔이 된다. 즉, 콘솔은 사용자의 입력을 받거나 사용자에게 문자열을 출력해 주는 역할을 하는 것을 통칭하는 말이다.
>
> ## 콘솔 입력
>
> ------
>
> 다음의 예제를 작성해 보자.
>
> ```java
> import java.io.IOException;
> import java.io.InputStream;
> 
> public class Main {
>     public static void main(String[] args) throws IOException {
>         InputStream in = System.in;
> 
>         int a;
>         a = in.read();
> 
>         System.out.println(a);
>     }
> }
> ```
>
> 위에서 사용한 `InputStream`은 자바의 내장 클래스이다. 자바의 내장 클래스중에 `java.lang` 패키지에 속해 있지 않은 클래스는 위 코드처럼 필요할 때 항상 `import` 해서 사용해야 한다. 우리가 그동안 사용해 왔던 System이나 String 등의 클래스는 `java.lang` 패키지에 속해 있는 클래스이므로 별도의 `import` 과정이 필요없었다.
>
> > ※ 자바 패키지에 대한 설명은 나중에 자세하게 알아볼 것이다.
>
> 다음 문장에서 알 수 있듯이 `System.in`은 InputStream의 객체임을 알 수 있다.
>
> ```java
> InputStream in = System.in;
> ```
>
> InputStream의 read메소드는 다음처럼 1 byte의 사용자의 입력을 받아들인다.
>
> ```java
> int a;
> a = in.read();
> ```
>
> 하지만 read 메소드로 읽은 1 byte의 데이터는 byte 자료형으로 저장되는 것이 아니라 int 자료형으로 저장된다. 저장되는 int 값은 0-255 사이의 정수값으로 아스키 코드값이다.
>
> > 0 이라는 숫자에 해당되는 아스키코드값은 48, a 라는 문자에 해당되는 아스키코드값은 97이다.
>
> 이제 프로그램을 실행시켜보면 프로그램은 종료되지 않고 사용자의 입력을 대기하고 있을 것이다. 왜냐하면 InputStream의 read()메소드가 호출되면 사용자의 입력을 받을 때까지 프로그램이 대기하기 때문이다.
>
> 이제 콘솔 창에 'a' 키를 입력해 보자. 아무런 반응이 없을 것이다. 그리고 다시 "엔터"키를 입력해 보자.
>
> > 엔터키를 입력해야 사용자의 입력이 종료되고 프로그램에 전달된다.
>
> 아마도 다음과 같이 출력이 되고 프로그램은 종료될 것이다.
>
> > ※ 엔터키를 입력해야 사용자의 입력이 종료되고 프로그램에 전달된다.
>
> 아마도 다음과 같이 출력이 되고 프로그램은 종료될 것이다.
>
> ```
> 97
> ```
>
> 97은 사용자가 입력한 문자인 `a`에 해당하는 아스키 코드값이다.
>
> **IOException**
>
> 위 예제에 main 메소드를 보면 `throws IOException`을 사용한 부분이 있다. InputStream으로 부터 값을 읽어들일 때는 IOException이 발생할 수 있기 때문에 예외처리를 해야 하는데 `throws`로 그 예외처리를 뒤로 미루게 한 것이다. 예외처리는 뒤에서 자세히 다룰 예정이니 지금은 그냥 넘어가도록 하자.
>
> ### InputStream
>
> 다시 프로그램을 실행시키고 이번엔 “abc”를 연속해서 입력한 후 “엔터” 키를 다시 입력해 보자.
>
> 이번에도 97이 출력될 것이다.
>
> “abc”를 입력했지만 출력은 “a”에 해당되는 아스키 코드값만 출력되었다. 그 이유는 InputStream의 read 메소드는 1btye만 읽기 때문이다. 즉, 사용자는 “abc”라는 총 3btye의 데이터를 전달했지만 프로그램에서 1byte만 읽는 경우라고 할 수 있다. 이렇게 **사용자가 전달한** 1byte의 데이터 또는 3byte의 데이터를 다른 말로 **입력 스트림(Stream)**이라고 한다. **스트림은 이어져 있는 데이터(byte)의 형태를 의미한다.**
>
> **스트림(Stream)이란?**
>
> 스트림을 가장 쉽게 이해하려면 수도꼭지를 생각하면 된다. 수도꼭지를 틀면 물이 나오고 수도꼭지를 잠그면 물이 나오지 않는다. A라는 곳에서부터 B라는 곳까지 수도관이 연결되어 있고 A에서 계속 물을 보낸다면 B에서 수도꼭지를 틀때마다 물이 나오게 될 것이다. 여기서 스트림은 A수도관에서 B수도관으로 이동하는 **물의 흐름이라고 할 수 있다.**
>
> 프로그래밍에서는 다음과 같은 것들을 스트림이라고 할 수 있다.
>
> - 파일 데이터 (파일은 그 시작과 끝이 있는 데이터의 스트림이다.)
> - HTTP 송수신 데이터 (브라우저가 요청하고 서버가 응답하는 HTTP 형태의 데이터도 스트림이다.)
> - 키보드 입력 (사용자가 키보드로 입력하는 문자열은 스트림이다.)
>
> 그렇다면 사용자가 3byte를 입력했을 때 3byte를 전부 읽고 싶다면 어떻게 해야할까?
>
> ```java
> import java.io.IOException;
> import java.io.InputStream;
> 
> public class Sample {
>     public static void main(String[] args) throws IOException {
>         InputStream in = System.in;
> 
>         int a;
>         int b;
>         int c;
> 
>         a = in.read();
>         b = in.read();
>         c = in.read();
> 
>         System.out.println(a);
>         System.out.println(b);
>         System.out.println(c);
>     }
> }
> ```
>
> 위 예처럼 read() 메소드를 3번 실행하도록 수정하고 프로그램을 다시 실행해 보면 “abc” 입력시 총 3byte를 읽어들이는 것을 확인할 수 있을 것이다.
>
> 또는 다음과 같이 좀 더 개선된 방법을 사용할 수 있다.
>
> ```java
> import java.io.IOException;
> import java.io.InputStream;
> 
> public class Sample {
>     public static void main(String[] args) throws IOException {
>         InputStream in = System.in;
> 
>         byte[] a = new byte[3];
>         in.read(a);
> 
>         System.out.println(a[0]);
>         System.out.println(a[1]);
>         System.out.println(a[2]);
>     }
> }
> ```
>
> 길이 3짜리 byte 배열을 만든 후 read 메소드의 입력값으로 전달하면 콘솔 입력이 해당 배열에 저장이 된다. 프로그램을 실행해 보면 이전과 동일한 결과가 출력되는 것을 확인할 수 있다.
>
> ### InputStreamReader
>
> 하지만 읽어들인 값을 항상 아스키코드 값으로 해석해야 하는 이 방식은 여전히 불편하다. 우리가 입력한 문자값을 그대로 출력해 볼 수 는 없을까? 바이트 대신 문자로 입력 스트림을 읽으려면 `InputStreamReader`를 사용하면 된다.
>
> ```java
> import java.io.IOException;
> import java.io.InputStream;
> import java.io.InputStreamReader;
> 
> public class Sample {
>     public static void main(String[] args) throws IOException {
>         InputStream in = System.in;
>         InputStreamReader reader = new InputStreamReader(in);
>         char[] a = new char[3];
>         reader.read(a);
> 
>         System.out.println(a);    //abc 입력하면 아스키 코드 값이 아닌 abc 출력
>     }
> }
> ```
>
> InputStreamReader 를 사용하기 위해 import 문이 하나 더 추가되었다. 그리고 InputStreamReader 객체를 생성할 때는 다음과 같이 생성자의 입력으로 InputStreamReader 객체가 필요하다.
>
> 이전에는 읽어들일 값을 byte 배열로 선언했는데 InputStreamReader 를 이용하면 다음처럼 byte 대신 char 배열을 사용할 수 있다.
>
> ### BufferedReader
>
> 프로그램이 많이 개선되었지만 여전히 불편한 점은 남아있다. 불편한 점은 고정된 길이로만 스트림을 읽어야 한다는 점이다. 위 예제는 항상 3byte만 읽도록 고정되어 있다.
>
> 사용자가 엔터키를 입력할 때까지 사용자의 입력을 전부 받아들일 수는 없을까? `BufferedReader` 를 이용하면 가능하다!
>
> ```java
> import java.io.IOException;
> import java.io.BufferedReader;
> import java.io.InputStream;
> import java.io.InputStreamReader;
> 
> public class Sample {
>     public static void main(String[] args) throws IOException {
>         InputStream in = System.in;
>         InputStreamReader reader = new InputStreamReader(in);
>         BufferedReader br = new BufferedReader(reader);
> 
>         String a = br.readLine();
>         System.out.println(a);
>     }
> }
> ```
>
> 역시 `BufferedReader`를 이용하기 위해 import 문이 추가되었다. `BufferedReader`는 객체 생성시 생성자의 입력값으로 `InputStreamReader`의 객체가 필요하다. 이제 `BufferedReader`의 `readLine`메소드를 이용하면 사용자가 엔터키를 입력할 때까지 입력했던 문자열 전부를 읽을 수 있게 된다. 프로그램을 실행하고 "Hello World"라고 입력한 후 엔터키를 입력하면 "Hello World"라는 문자열이 그대로 Echo되어 출력되는 것을 확인할 수 있을 것이다.
>
> 초보 프로그래머, 능숙한 프로그래머 할 것 없이 이 스트림 부분만 들어오면 헷갈리기 마련이다. 감싸고 감싸고 또 감싸니 도대체 내부적으로 어떻게 돌아가는지 헷갈릴 수 밖에 없다.
>
> 다음과 같이 기억하면 좋을 것 같다.
>
> - InputStream - byte
> - InputStreamReader - character
> - BufferedReader - String
>
> ## 콘솔 출력
>
> ------
>
> 이번에는 콘솔 출력에 대해서 알아보자.
>
> 우리는 예제들에서 `System.out.println` 메서드를 계속해서 사용해 왔다. `System.out`은 PrintStream 클래스의 객체이다. PrintStream은 콘솔에 값을 출력할 때 사용되는 클래스이다. 보통 `System.out.println`은 콘솔에 문자열을 출력할 경우나 디버깅 시 많이 사용된다.
>
> `System.err`도 있는데 `System.out`과 동일한 역할을 한다. 다만 `System.err`는 오류메시지를 출력할 경우에 사용한다.
>
> **Unix 콘솔의 System.out과 System.err**
>
> Unix의 경우 콘솔 프로그램 실행시 출력 옵션을 지정하면 System.out으로 출력한 내용과 System.err로 출력한 내용을 별도의 파일로 저장할수 있다.
>
> 다음 프로그램을 보자.
>
> ```java
> public class Sample {
> public static void main(String[] args) {
> 
>         System.out.println("일반 출력");
>         System.err.println("에러 출력");
>     }
> }
> ```
>
> 위와 같이 작성한 Sample.java 소스를 컴파일하여 Sample.class 파일을 생성한 후 유닉스에서 다음처럼 실행하면 out.txt 파일에는 "일반 출력" 이라는 문자열이 저장되고 error.txt 파일에는 "에러 출력"이라는 문자열이 저장된다.
>
> ```java
> $ java Sample > out.txt 2> error.txt
> ```
>
> > ※ 유닉스에서 > 는 일반 출력, 2>는 오류 출력에 해당된다.