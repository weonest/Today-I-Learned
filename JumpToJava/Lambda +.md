# Lambda 보충

## 람다식의 장점

- 코드의 라인수가 줄어듦
  - 메소드로 표현된 코드에 비해 확연히 라인 수가 줄어든다
- 병렬 프로그래밍이 가능
  - Iteration 방식은 반복 대상을 일일히 루프에서 지정하는 반면에, 함수형 프로그래밍에서는 반복 대상을 사용자 코드에서 직접 지정하지 않음
- 람다식으로 바로 실행문을 전달할 수 있음
  - 자바 메소드로 값이나 객체를 생성하여 전달하던 예전 방식과 달리, 람다식에서는 실행문 자체를 람다식으로 전달하여 구현
- 의도의 명확성
  - 가독성이 높음

## 람다식의 단점

- 람다식은 재사용이 불가
  - 일회용 함수 정의가 목적 (하나의 변수처럼 사용하게 된다)
- 불필요하게 너무 사용하게 되면 가독성이 떨어짐
  - 같은 기능의 함수를 여러 번 정의하는 상황이 발생할 수 있음

### 함수형 인터페이스 API

| 인터페이스명      | 반환 자료형 | 메서드           | 매개 변수 |
| ----------------- | ----------- | ---------------- | --------- |
| Runnable          | void        | run()            | 없음      |
| Supplier          | T           | get()            | 없음      |
| Consumer          | void        | accept(T t)      | 1개       |
| Function<T,R>     | R           | apply(T t)       | 1개       |
| Predicate         | boolean     | test(T t)        | 1개       |
| UnaryOperator     | T           | apply(T t)       | 1개       |
| BiConsumer<T,U>   | void        | accept(T t, U u) | 2개       |
| BiFunction<T,U,R> | R           | apply(T t, U u)  | 2개       |
| Bipredicate<T,U>  | boolean     | test(T t, U u)   | 2개       |
| BinaryOperator    | T           | apply(T t, U u)  | 2개       |

d