# 스프링 프레임워크란?
   (Spring Framework)
   spring6
   jdk17

1) 의존 주입(Dependency Inject : DI) 지원
2) AOP(Aspect-Oriented Programming) 지원
    - 프록시(proxy) : 대신하다, 대리하다.

3) MVC 웹 프레임워크 제공
    - spring-webmvc

4) JDBC, JPA 연동, 선언적 트랜잭션 처리 등 DB 연동 지원
   JPA(Java Persistence API - ORM 표준 설계)

5) 스프링 데이터 : 추상화된 틀 제공<br>
   스프링 시큐리티 : 인증, 인가(접근제한) <br>
   스프링 배치


## 스프링 프로젝트 생성하기
   spring-context 의존성



## 객체 컨테이너
   IoC - Inversion Of Control : 제어의 역전
   - 개발자가 해야되는 객체의 관리 -> 스프링 컨테이너가 대신 수행

   - 다양한 방식으로 객체 관리
        1) 모든 관리 객체가 싱글턴 객체(동일 객체)

## 스프링 DI(Dependency Injection - 의존주입)

0) 의존(Dependency)
    - 협동, 상호작용

1) DI를 통한 의존 처리
2) DI와 의존 객체 변경의 유연함

5.  객체 조립기

클래스 클래스 : 클래스라고 하는 정보가 담겨있는 객체

``` java
AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);  
```

애노태이션으로 설정?담는 스프링 컨테이너 <br>
ApplicationContext : 스프링 컨테이너 : 객체가 담겨있고 필요할 때마다 꺼내준다.<br>
어떤 객체가 담겨 있는지는 설정으로 알려준다.<br>
Bean으로 알려준다.<br>
애노테이션 : 클래스클래스의 정보의 일부분<br>
AnnotationConfig : 설정방식<br>
AppCtx.class : 정보(설정)이 담긴 클래스 클래스<br>
@Configuration : 설정클래스라고 알려주는 애노테이션<br>

스프링 컨테이너 : 객체관리



! 중요
BeanFactory : 
ApplicationContext :
AnnotationConfigApplicationContext(Class<?>... componentClasses) : ... 가변적인 매개변수


함수 이름 (메서드 명) - 함수의 시그니쳐
패키지명 | 클래스명 | 반환값 타입 | 함수명 | 매개변수 타입 | 예외 전가

메서드 오버로드가 가능한것은 다른 함수라서 가능하다.

RuntimeException : 실행 오류 예외 처리 : 예외가 체크된 시간의 차이

오류 : 시스템 오류
예외 : 통제 가능

FileNotFoundException : 런타임이 없고 , 컴파일 시에
ArithmeticException : 런타임이 있다. 실행중에
컴파일할때 차이가 난다.

class파일(컴파일) 실행중에 런타임 체크?

### Exception 
   - 컴파일 시점에 예외를 체크 -> 이상 -> 컴파일x
   - 엄격한 예외, 형식 중요! - 예외가 있던 없던 무조건 예외처리가 필요

### RuntimeException 
   - 실행 중에 예외를 체크 -> 실행이 되려면? 컴파일이 o -> 컴파일 o
   - 유연한 예외, 예외가 발생하는 상황이 되더라도 실행된다.
   - 예외발생 -> 중단
   - 서비스 중단을 막기 위해서 -> 적절한 예외 처리 O

``` java
try{
   // 예외가 발생할 가능성이 있는 코드
} catch (예외 객체) {
   // 예외에 대한 후속 처리
}
```

생성자만 예외처리해도 된다.?

기능의 확장 : 상속
인터페이스로 상속의 기능확장을 유연하게 한다.<br>
default 메서드 : 인스턴스 정의?

C -> B -> A 상속
super는 중요해서 자동으로 추가가 된다.

this : 지역변수 -> 참조 변수<br>
this() : 생성자 메서드

super : 지역 변수 : 상위 클래스의 객체의 참조 변수<br>
super() : 상위 클래스 생성자 메서드

C() -> super() : B() -> A()

상속은 인스턴스 자원만

다형성 : 하위클래스는 상위클래스가 될 수 있다. 출처가 명확하기 때문이다. <br>
상위 클래스는 출처가 동일한지 모르기 때문에 하위클래스가 될 수 없다. <br>
instanceof : 동일한지 확인, 객체의 출처 확인

상위 클래스 -> 일반적인 개념 <br>
하위 클래스 -> 구체적인 개념

배열 : 같은 자료형, 연속적으로 나열된

생성자 함수(메소드) - 객체들 생성하는 역할 (힙 메모리에 필요한 자원을 위한 공간 할당)

데이터 영역 : 클래스도 코드가 올라와있어야 참고해서 객체를 만들수 있다. 코드와 상수
method는 하나만 공유한다.<br>
method override : 본인거 먼저 나오고 없으면 거슬러 올라가면서 동일한게 있는지 확인, 하위에서부터 확인

@Override : 재정의한 메소드라고 알려줌

모든 클래스의 정점은 추상클래스나 , 인터페이스

### 추상클래스
- 설계, 공통자원 정의
- 공통기능 추가
- 객체가 될수 없다.
- 추상메서드면 추상 클래스여야한다.

### 객체 생성과정
- new 하고 공간할당
- 힙 메모리공간에 각각의 생성
- 메서드가 구현된게 없어 추상은 객체가 될 수없다.
- 상속을 통한 자원은 인스턴스 자원일때 가능

### 메서드
   - 객체를 만들기 위해 클래스를 만든다.
   - 객체에서 제일 중요한건 메서드
   - 인스턴스 메서드 : 객체를 만들면 접근할 수있는 메서드
   - 정적 메서드 : 메서드만 가지고 접근할수 있다.
   - 상수와 같이 
   - 동일한 자원을 호출한다. 가상 메서드 테이블
   - 상속을 통해 상위 클래스를 바꾼다.
   - 상속은 인스턴스 자원만

## 인터페이스(interface)
- 목적이 명확한 클래스
- 설계 만을 위한 클래스
- 추상 메서드만 정의 : 설계 명세
- implements 인터페이스 ...
- 제한적인 클래스의 일종

implements : 구현하다

상속보단 구성의 확장이 유리하다. <br>
public  JoinValidator(MemberDao memberDao) { <br>
this.memberDao = memberDao;<br>
}

전략 패턴 : 변화에는 닫혀있고(캡슐화), 확장에는 열린 구조, 통제를 하기 위한 구조

자바 기초 Wrapper 클래스
Optional 클래스 - JDK 8
- Wrpper 클래스 : 기본형, 객체가 되야 기능을 쓸수 있다.
- NPE(NullPointException)의 다양한 처리 지원

### 자료형
기본 자료형 : 숫자를 저장하는 자료형
  - byte - Byte
  - short - Short
  - int - Integer
  - long - Long
  - float -Float
  - double - Double
  - char(2,3)

참조 자료형 : 주소를 저장하는 자료형

```java
class Integer ... {
   ...
   private final int value;
   ...
}
```
싱글톤 패턴(SingleTon)
1. 하나의 객체만 생성하고 공유(static)
   1) 기본 생성자 private 정의,  통제가 안되는건 막는다.
   2) 클래스 내부에서 객체 생성
2. 필요할때만 처음 객체를 생성 -> 공유

this는 생성된 객체를 참조하는 참조 변수로 모든 인스턴스 메서드에는 지역변수인 this가 있다.<br>
static메서드만 this가 존재하지 않는다.

의존하는 객체는 내부에서 하는것보다 외부에서 주입하는게 통제하는데 좋다.<br>
외부에서 주입하면 객체 변경이 용이하다. (한번에 바꿀수 있다.)

회원가입
joinService : validate  - member(데이터형태 객체) - memberDao(데이터에 접근) 를 의존한다.
하나의 기능을 위해서 객체를 의존한다.
캡슐화 : 감춰놓고 통제



# 스프링 DI 설정 및 사용
1. 스프링을 이용한 객체 조립과 사용
2. DI 방식 1 : 생성자 방식
3. DI 방식2 : 세터 메서드 방식
4. @Configuration : 설정 클래스임을 알려주는 애노테이션
5. @Bean : 뭐 해달라고 알려주는거
   - getBean : 필요한 클래스를 찾아 오는 변수

6. 두 개 이상의 설정 파일 사용하기
1) 생성자 매개변수
2) @Import


### 의존 자동 주입
1. @Autowired : 스프링에서 정의한 애노테이션
    - @Resource, @Inject : 자바표준 - 의존성 자동 주입
    - 적용 범위
      1) 멤버 변수 위에
      2) setter 메서드 위에
      3) Optional 내부 객체
      4) @Autowired 애노테이션을 사용하지 않고 자동 주입 방법
        - 생성자 매개 변수 정의 / 기본 생성자X -> 컴포넌트 스캔에서 적용
        - lobok과 함께 많이 사용
          - @RequiredArgsConstructor 
            - : 초기화가 반드시 필요한 멤버 변수를 생성자 매개변수로 자동 생성
            - 초기화가 반드시 필요한 경우 
              - : 멤버 변수가 상수이고 값을 지정하지 않은 경우
              - : @NonNull이 있는 멤버 변수
- 기본값 : required true
2. 일치하는 빈이 없는 경우
- @Autowired (required = false)
  - 의존하는 Bean이 없는 경우 setter 메서드를 호출 X
- 의존 객체 앞에 @Nullable 애노테이션을 추가
  - 의존하는 Bean이 없는 경우 setter 메서드 호출 -> 의존 객체를 nulll로 대입
3. @Qualifier
- 일치하는 빈이 여러개 있을 경우 -> 예외 발생
- 해결방법
  1) 순서를 정한다. @Primary : 동일한 자료형의 빈이 있는 경우 가장 우선순위
  2) 적용할 빈의 이름을 한정 @Qualifier
4. 빈 이름과 기본 한정자
5. @Autowired 애노테이션의 필수 여부

### 컴포넌트 스캔
1. @Component
2. @ComponentScan
3. 기본 스캔 대상
   - @Component
   - @Service : 
- 특정 기능, 역활과 연관된 애노테이션
  - @Configuration : 설정 클래스임을 알려주는 애노테이션
  - @Repository : 저장소
  - @Controller : WebMVC 프레임 워크
  - @RestController : WebMVC 프레임 워크
  - @ControllerAdvice : WebMVC 프레임 워크
  - @RestControllerAdvice : WebMVC 프레임 워크
  - @Aspect : AOP 관련
4. 컴포넌트 스캔에 따른 충돌 처리
1) 빈 이름 충돌
2) 수동 등록한 빈과 충돌
3) excludeFilters

빈 라이프 사이클과 범위
1. 컨테이너 초기화 : 빈 객체의 생성, 의존 주입, 초기화

2. 컨테이너 종료 : 빈 객체의 소멸

3. 빈 객체의 라이프 사이클
1) 객체 생성 -> 의존 설정 -> 초기화 -> 소멸
2) InitializingBean 인터페이스
   - afterPropertySet(...) : 호출
3) DisposableBean 인터페이스
   - destroy() : 소멸 전에 호출

4.  빈 객체의 초기화와 소멸 : 커스텀 메서드
1) initMethod
2) destroyMethod

5. 애노테이션 (참고만)
    - @PostConstruct : 초기화 단계시에 호출될 메서드
    - @PreDestroy() : 소멸 전에 호출될 메서드

6. 빈 객체의 생성과 관리 범위
   @Scope 
    - singleton : 단일 객체
   - prototype : 조회마다 새로운 객체 생성/ 스프링 컨테이너 관리 기능에 제한점이 



리터럴 상수?

스프링의 핵심 기능은 객체를 생성하고 초기화 하는 것이다.
스프링 컨테이너는 자바 객체의 생명 주기를 관리하며, 생성된 자바 객체들에게 추가적인 기능을 제공한다.
스프링에서는 자바 객체를 빈(Bean)이라 한다.
컨테이너는 개발자가 정의한 빈을 객체로 만들어 관리하고 개발자가 필요로 할 때 제공한다.


java쪽과 resource쪽 파일명을 동일하게 한다.