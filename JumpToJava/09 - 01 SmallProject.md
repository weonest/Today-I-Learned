# 09 - 01 SmallProject

------

대규모의 프로젝트를 진행하다보면 항상 서로 다른 시스템끼리 데이터를 주고 받아야 하는 상황이 생기게 된다. 이때 가장 많이 사용하는 것이 바로 전문을 주고 받는 방법이다. 여기에서 말하는 전문은 서로 약속한 규칙대로 주고받는 일반 텍스트 데이터를 말한다.

우리가 진행할 작은 프로젝트는 전문을 생성하고 파싱(Parsing) 하는 프로그램을 만드는 것이다. 파싱은 업계 용어로 “전문을 길이대로 자른다” 라는 의미이다.

> 아래 작성할 프로그램은 실제 한국의 모 은행에서 필자가 작성한 프로그램의 일부분이기도 하다. (간략하된 버전)

## 전문 수송신

------

가장 간단한 전문의 규칙은 다음과 같다고 한다.

- 요청 준문으로 “이름”, “전화번호”를 보내면 응답 전문으로 “생일”, “주소”를 리턴한다.
- “이름”은 20자리이다.
- “전화번호”는 11자리이다.
- “생일”은 8자리이다.
- “주소”는 50자리이다.

이러한 요건을 간단히 다음과 같이 표로 정리해 보았다.

| 구분 | 항목(길이)              |
| ---- | ----------------------- |
| 요청 | 이름(20) + 전화번호(11) |
| 응답 | 생일(8) + 주소(50)      |

요청 전문은 이름(20byte) + 전화번호(11byte)가 합쳐진 모습이다. 한글은 3byte 이므로 “홍길동” 9byte 뒤에 11byte의 여백이 필요하다. `exmaple) 홍길동           01099998888`

> UTF-8로 인코딩된 한글은 한 글자에 3바이트 씩의 자리를 차지한다. 만약 ECU-KR과 같은 인코딩 방식을 사용한다면 한글은 한 글자에 2바이트를 갖게 된다.

응답전문의 예는 다음과 같다.

```
example) 19801215서울시 송파구 잠실동 123-3
```

응답전문은 생일(8byte) + 주소(50byte)가 합쳐진 모습이다.

> 전문을 보내고 수신하는 네트워크 프로그래밍 부분은 작은 프로젝트의 범위가 아니다. 우리는 단지 전문을 생성하고 수신받는 전문을 파싱하는 프로그램만 작성하도록 하자.

## 전문 생성

------

우선 전문을 만들어 보자. 송신 전문에는 “이름”, “전화번호”라는 항목이 있다.

이 항목을 나타낼 수 있는 클래스를 다음처럼 작성해 보자.

```java
public class Item {
}
```

이제 이 Item 클래스가 가져야 할 속성에 대해서 생각해 보자. Item 은 “이름”, “전화번호”, 와 같은  `이름`, 20자리, 11자리 등의  `길이` 그리고 “홍길동”, “01099998888”과 같은 해당 항목의  `값` 이 필요하다.

- 이름
- 길이
- 값

이렇게 필요한 속성을 클래스에 적용해 보자.

```java
public class Item {
	String name;
	int length;
	String value;
```

그리고 name, length, value 변수에 직접 접근하지 못하도록 접근 속성을 private로 바꾸고 대신 속성의 값을 저장하고 읽기 위한 getter, setter 메소드를 다음과 같이 만들자.

```java
public class Item {
	private String name;
	private int length;
	private String value;

		public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
```

보통 이렇게 데이터 성격의 클래스를 만들 때는 필요한 속성들을 private로 선언한 후에 Getter와 Setter를 만들어 사용한다.

이제 한 개의 항목을 생성하고 값을 저장한 뒤 그 전문을 출력해 보자.

```java
public class Item {
	private String name;
	private int length;
	private String value;

    (... 생략 ...)

public String raw() {
	return this.value;
    }

public static void main(String[] args) {
        Item item = new Item();
        item.setName("이름");
        item.setLength(20);
        item.setValue("홍길동");
        System.out.println("[" + item.raw() + "]"); 
					// [홍길동]
    }
}
```

raw 메소드는 Item의 value를 그대로 리턴했기 때문에 위와 같은 결과값이 출력되었다. 공백을 확인하기 위해 출력값 좌우에 `[]` 을 포함하도록 했다. 하지만 출력된 값은 우리가 원하는 값이 아니다. 우리가 원하는 값은 길이에 맞게 공백이 채워져 있어야 한다. "홍길동"이 9바이트이므로 뒤로 11바이트의 공백이 추가 되어야 하는 것이다.

이제 길이에 맞게끔 이름 뒷 부분에 공백을 추가해야 한다. 다음과 같이 raw 메소드를 변경해 보자.

```java
public String raw() {
	StringBuffer padded = new StringBuffer(this.value);
	while(padded.toString().getBytes().length < this.length) {
		padded.append(' ');
	}
	return padded.toString();
}
```

StringBuffer에 먼저 값(value)을 담고 해당 값이 아이템의 길이보다 작은 동안에는 공백`' '`문자를 뒷부분에 추가하여 리턴하도록 변경했다. 여기서 눈여겨 볼 곳은 `padded.toString().getBytes().length` 부분으로 문자열을 다시 바이트로 변환하여 길이를 체크한 부분이다. 간단하게 문자열의 길이를 체크하는 방법은 `padded.length()` 를 사용하면 된다. 하지만 한글때문에 바이트로 변환 후 길이를 다시 세어야 한다.

```java
"홍길동".length(); // 3
"홍길동".getByte().length; // 9
```

자바는 한글 한글자의 길이를 1로 계산한다. 이러한 이유로 전문 송수신 시 한글이 섞여 있을 때 바이트로 변환하지 않고, 그냥 length를 이용하여 길이를 세면 바이트의 실제 길이와 다르기 때문에 오류가 발생하게 된다. 전문 송수신 시 길이 체크는 항상 바이트 단위로 변환한 후 길이를 체크하는 것이 가장 안전하다.

이제  `이름 + 전화번호` 처럼 여러개의 아이템이 합쳐진 완전한 송신전문을 만들어야 한다. 여러개의 아이템을 포함하는 Packet 클래스를 다음과 같이 작성해 보자.

```java
import java.util.Arraylist;

public class Packet {
	private ArraysList<Item> items = new ArrayList<Item>();
}
```

Packet 클래스에는 Item 객체를 포함하는 items 속성을 추가했다. Item의 갯수는 가변이기 때문에 ArrayList를 이용하여 Item객체를 담을 수 있도록 했다.

이제 해야 할 일은 Item을 Packet에 넣고 빼오는 일이다.

```java
import java.util.ArrayList;

Public class Packet {
	private ArrayList<Item> items = new ArraysList<Item>();
	
	public void addItem(Item item) {
		this.items.add(item);
	}
		
	public Item getItem(int index) {
		return this.items.get(index);
	}
}
```

아이템을 추가하고 가져올 수 있도록 위와같이 addItem, getItem 메소드를 추가했다.

이제 Packet의 전문을 출력하는 raw 메소드를 추가해 보자.

```java
import java.util.ArrayList;

public class Packet {
    private ArrayList<Item> items = new ArrayList<Item>();

    public void addItem(Item item) {
        this.items.add(item);
    }

    public Item getItem(int index) {
        return this.items.get(index);
    }

    public String raw() {
        StringBuffer result = new StringBuffer();
        for (Item item : items) {
            result.append(item.raw());
        }
        return result.toString();
    }
}
```

raw 메소드는 Item 항목들의 값들(raw메소드로 길이에 맞게 변환된)을 모두 더하여 리턴한다. 이렇게 작성한 raw 메소드가 정상적으로 동작하는지 확인해 보자.

```java
import java.util.ArrayList;

public class Packet {
    (... 생략 ...)

    public static void main(String[] args) {
        Packet packet = new Packet();

        Item item1 = new Item();
        item1.setName("이름");
        item1.setLength(20);
        item1.setValue("홍길동");

        Item item2 = new Item();
        item2.setName("전화번호");
        item2.setLength(11);
        item2.setValue("01099998888");

        packet.addItem(item1);
        packet.addItem(item2);

        System.out.println("[" + packet.raw() + "]");
    }
}
```

그런데 잠깐, main 메소드에서 Item 객체를 생성하는 과정이 좀 복잡하다. Item을 보다 손쉽게 만들 수 있도록 Item 클래스에 다음과 같이 create 라는 static 메소드를 추가하자.

```java
public class Item {
	private String namel
	private int lenght;
	private String value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;	
	}
	
public String raw() {
	StringBuffer padded = new StringBuffer(this.value);
	while (padded.toString().getBytes().length < this.length) {
		padded.append(' ');
	}
	return padded.toString();
  }

public static Item create(String name, int length, String value) {
		Item item = new Item();
		item.setName(name);
		item.setLength(length);
		item.setValue(value);
		return item;
	}

public static void main(String[] args) {
	Packet packet = new Packet();

        Item item1 = Item.create("이름", 20, "홍길동");
        Item item2 = Item.create("전화번호", 11, "01099998888");

        packet.addItem(item1);
        packet.addItem(item2);

        System.out.println("[" + packet.raw() + "]");
    }
}
```

## 전문 파싱

------

수신받은 전문이 다음과 같다고 가정해보자.

`19980729수원시 장안구 연무동 419 -5` 수신 전문은  `생일(8) + 주소(50)` 형태의 전문이다.

전문을 파싱하기 위해서는 항목과 그 길이를 알아야 한다. 우리는 이미 송수신 전문 규칙을 알고 있기 때문에 다음과 같은 Packet 을 만들 수 있다. 값은 파싱해야 알 수 있는 정보이므로 null로 세팅하자

```java
Packet recvPacket = new Packet();
recvPacket.addItem(Item.create("생일", 8 , null));
recvPacket.addItem(Item.create("주소", 50, null));
```

recvPacket 을 사용하여 수신 전문을 다음처럼 파싱하면 좋을 것 같다.

```java
recvPacket.parse("19980729수원시 장안구 연무동 419-5             ");
```

위와 같이 파싱할 수 있도록 Packet 클래스에 다음과 같은 parse 메소드를 추가하자.

```java
(...생략...)
	public void parse(String data) {
		byte[] bdata = data.getBytes();
		int pos = 0;
		for (Item item : items) {
			byte[] temp = new byte[item.getLength()];
			System.arraycopy(bdata, pos, temp, 0, item.getLength());
			pos += item.getLength();
			item.setValue(new String(temp));
	}
}
(...생략...)
```

parse 메소드는 수신받은 전문을 먼저 바이트 배열로 바꾼다. 그런 후에 아이템을(수신전문 규격에 의해서 이미 만들어진 recvPacket의 아이템들)을 순차적으로 돌면서 아이템의 길이만큼 먼저 temp라는 바이트 배열을 생성한 후에 `System.arraycopy` 를 이용하여 값을 복사한다.

```java
System.arraycopy(소스, 소스시작위치, 대상, 대상시작위치, 복사할길이)
```

소스시작위치는 아이템의 길이만큼 계속 증가해야 하기 때문에 다음과 같이 소스시작위치인 pos 값을 계속 증가시켜야 한다.

```java
pos += item.getLength();
```

그리고 temp에 값이 복사되면 temp 값을 item에 다음과 같이 세팅한다.

```java
item.setValue(new String(temp));
```

이러한 과정을 거치면 Packet 클래스에 추가한 아이템들(생일, 주소)의 값이 모두 세팅이 될 것이다. 이제 작성한 parse 메소드가 정상적으로 잘 동작하는지 확인해 보자.

*Packet.java*

```java
(... 생략 ...)
public static void main(String[] args) {
        Packet recvPacket =newPacket();
        recvPacket.addItem(Item.create("생일", 8, null));
        recvPacket.addItem(Item.create("주소", 50, null));
        recvPacket.parse("19801215서울시 송파구 잠실동 123-3               ");

        System.out.println(recvPacket.getItem(1).raw());
    }
(... 생략 ...)
```

main 메소드를 위와 같이 작성하고 실행해 보자.

```
서울시 송파구 잠실동 123-3
```

두번째 항목인 "주소"가 정상적으로 파싱되어 출력된 것을 확인할 수 있다. 그런데 recvPacket에서 사용한 getItem 메소드는 사용법이 조금 불편해 보인다.

```java
recvPacket.getItem(1)
```

“주소”에 해당하는 값을 얻기 위해서는 “주소”가 몇번 째 항목인지 기억해야 하기 때문이다. 위와 같이 항목이 2개인 경우는 알기 쉽지만 항목이 50개 이상된다면 모든 항목들의 위치를 기억하고 있어야 하기 때문에 매우 불편한 방법이다.

Packet 클래스에서 한 개의 Item 을 Access 하는 가장 좋은 방법은 Item 의 이름으로 Access 하는 것이다.

다음과 같이 Packet 클래스를 변경해 보자.

```java
import java.util.ArrayList;
import java.util.HashMap;

public class Packet {
    private ArrayList<Item> items = new ArrayList<Item>();
    private HashMap<String, Item> nameAccess = new HashMap<String, Item>();

    public void addItem(Item item) {
        this.items.add(item);
        nameAccess.put(item.getName(), item);
    }

    public Item getItem(String name) {
        return nameAccess.get(name);
    }

    public Item getItem(int index) {
        return this.items.get(index);
    }

    public String raw() {
        StringBuffer result = new StringBuffer();
        for (Item item : items) {
            result.append(item.raw());
        }
        return result.toString();
    }

    public void parse(String data) {
        byte[] bdata = data.getBytes();
        int pos = 0;
        for (Item item : items) {
            byte[] temp = new byte[item.getLength()];
            System.arraycopy(bdata, pos, temp, 0, item.getLength());
            pos += item.getLength();
            item.setValue(new String(temp));
        }
    }

    public static void main(String[] args) {
        Packet recvPacket = new Packet();
        recvPacket.addItem(Item.create("생일", 8, null));
        recvPacket.addItem(Item.create("주소", 50, null));
        recvPacket.parse("19801215서울시 송파구 잠실동 123-3               ");

        System.out.println(recvPacket.getItem(1).raw());
    }
}
```

이름으로 아이템을 찾기 위해서 다음처럼 nameAccess 라는 HashMap 객체를 추가했다. nameAccess 의 Key는 아이템의 이름이고 Value는 Item 이다.

```java
private HashMap<String, Item> nameAccess = new HashMap<String, Item>();
```

addItem 메소드로 아이템 추가시 nameAccess 에도 동일하게 아이템이 추가되게 하기 위해서 addItem 메소드에 다음과 같은 라인을 추가했다.

```java
nameAccess.put(item.getName(), item);
```

그리고 이름으로 Item 을 가져오는 메소드인 `getItem(String, name)` 을 다음처럼 추가하였다.

```java
public Item getItem(String name) {
	return nameAccess.get(name);
}
```

이제 getITem(String name) 메소드를 이용하면 이름으로 아이템을 가져올 수 있게 되었다.

그런데 잠깐, 여기서 주의해야 할 부분이 있다. 그것은 각각의 Item 이 동일한 이름을 사용할 수도 있다는 점이다. 이럴 경우 nameAccess 의 키가 중복될 수 있기 때문에 문제의 소지가 있다. 따라서 전문 생성시 동일한 이름으로 항목을 설정할 수 없다는 규칙을 만들어야 한다.