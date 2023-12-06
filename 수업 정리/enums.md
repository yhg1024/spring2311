# 열거형(enums)
1. 열거형이란?
- 상수만을 위한 클래스
- JDK5

2. 열거형 정의와 사용
   enum 클래스명 {
   상수, 상수, ....
   }
- 정적 상수(public static final)

public class Transportation extends java.lang.Enum {
    
}

1) 
    - name() : 문자열 상수
    - ordinal() : 열거 순서, bus가 가장 먼저 열어되서 0번

2) 컴파일러가 자동 추가해주는 메서드
    valueof(...) : 변환 메서드

3. 모든 열거형의 상위 클래스 - java.lang.Enum
    - public abstract Transportation extends java.lang.Enum{<br>
        public static final Transportation BuS<br>
        public static final Transportation SUBWAY<br>
        public static final Transportation TAXI<br>
        
        private Transportation() {} <br>
      }

1) Enum 클래스에 정의된 메서드
    - int ordinal() : 상수가 정의된 위치 번호(0부터 시작)
    - String name() : 상수명을 문자열로 변경 / toString()
    - static valueOf : 변환 메서드 (문자열 -> Enum 상수)

2) 컴파일러가 자동으로 추가해주는 메서드
   valueOf : 변환 메서드 (문자열 -> Enum 상수 )

4. 열거형에 멤버 추가하기
   1) 열거형 상수의 값이 불연속적인 경우, 이때는 다음과 같이 열거형 상수의 이름 옆에 원하는 값을 괄호()와 함께 적어준다.
        ```java
        enum Direction { EAST(1), SOUTH(5), WEST(-1), NORTH(10) }
        ```
   2) 그리고 지정된 값을 저장할 수 있는 인스턴스 변수와 생성자를 추가해야 한다. 
   3) 우선 열거형 상수를 모두 정의한 후에 다른 멤버들을 추가해야 한다. 그리고 열거형 상수의 마지막에 세미콜론이 필수다.
   4) 새로 추가된 열거형의 생성자는 제어자가 묵시적으로 private이다.
   
5. 열거형에 추상메서드 추가하기
   1) 열거형에 추상 메서드를 선언하면 각 열거형 상수가 이 추상 메서드를 반드시 구현해야한다.
   2) 추상클래스나 인터페이스를 가지고 추상 메서드를 구현함으로써 익명 클래스를 작성하는 것과 유사하다.
   3) 구현시, 각 상수가 접근해야 하는 변수의 접근 제어자는 protected로 해야 한다.

    

### compareTo() 
- 문자열과 숫자를 비교하여 int 값으로 반환해주는 함수이다.

문자열을 비교하는 경우

- 0: 두 문자열이 같은 경우
- 음수: 인자가 객체보다 사전적으로 순서가 앞인 경우
- 양수: 객체가 인자보다 사전적으로 순서가 앞인 경우

숫자를 비교하는 경우

- 0: 두 숫자가 같은 수인 경우
- 음수: 인자가 객체보다 큰 수인 경우
- 양수: 객체가 인자보다 큰 수인 경우
