AOP 프로그래밍
(Aspect Oriented Programming)
- 관점 지향 프로그래밍
- 관점 : 개발자들의 공통 관심사, 공통으로 항상 처리해야 할 부분
spring-aop API(Application Programming Interface) : 구현채가 따라온다. API는 상세 명세
aspectjweaver - 구현채
스프링 관리객체(@Bean 등) 안에 들어가있어야한다.
```java
    @Bean
    public config.ProxyCalculator getProxyCalculator() {
        return new ProxyCalculator();
    }
```

1. 프록시(proxy) = 데코레이터 패턴
   - 대신하다, 대리하다
   - 공통 기능과 핵심사항을 대신해준다.
- 데코레이션 패턴<br>
  ex) java.io.BufferdInputStream<br>
  ->파일, 데이터를 읽을 때 버퍼 기능 추가

        class BufferedInputStream extends InputStream {
            private InputStream in;
            public BufferedInputStream(InputStream in) {
                this.in = in;
            }
            public int read() {
                // 버퍼 기능을 위한 코드
                int ch = in.read(); // 다른 입력 스트림(InputStream) 핵심 기능을 대신 수행
                // 버퍼 기능을 위한 코드
                return ch;
            }
         }

- 스프링에서 대신 해주는 관점 -> 프록시라고 관례적으로 명칭
- 참고) 프록시 패턴 : 통제, 제어 관점이 추가 (예 - 방화벽)

2. AOP - 범용적 프록시
- @EnableAspectJAutoProxy : 프록시 설정 자동화
  - 코드가 추가 될거라는 거
1) @Aspect : 공통 기능이 적용할 클래스
2) @Pointcut : 공통 기능이 적용될 범위
    - execution 명시자

3) @Around : 공통 기능을 추가 실행 하고 핵심 기능을 대신 수행해 주는 메서드
   - proceedingJoinPoint joinPoint
   - Signature getSignature()
     - getName() : 메서드명
     - toLongString() : 자세한 메서드 이름 정보
     - Object proceed() : 핵심 기능 대신 수행해 주는 메서드(범용 기능), 반환값 : Object
     - 매개변수 : ProceedingJoinPoint
     - 메서드의 정보(정의, 매개변수로 적용된 인자 값)
     - Object[] getArgs()
     - Object getTarget() : 핵심 기능 메서드가 속해 있는 객체의 참조 변수

3. @Order
- @EnableAspectJAutoProxy : 프록시 설정 자동화
    ProxyCache -> ProxyCalculator : 정상,  캐시가 먼저 동작하고 없을때 프록시칼큘레이터
    ProxyCalculator -> ProxyCache : 캐시 동작 x
    프록시의 실행 순서가 매우 중요한 경우 @Order(1), @Order(2) -> 순서를 직접 명확히 지정

인터페이스 기반 프록시
proxyTargetClass -> true : 하위 클래스 기반 프록시

프록시는 코드가 추가되는 형태로 만들어진다.
자바 표준 프록시는 인터페이스 기반이 기본
인터페이스에서 새로운 프록시가 많들어진다.

<img src="../img/하위클래스 기반 proxy.png" alt="하위클래스 기반 proxy"><br>
하위클래스 기반 proxy

자바는 컴파일 뒤에 못바꾼다.
그래서 프록시는 기존에 + 추가라서 다른데다 만든다.

4. 프록시 생성방식
5. @Around의 Pointcut 설정과 @Pointcut 재사용

Ant 경로 패턴
aopex.* : aopex 패키지의 모든 하위 클래스
                예) aopex.Calculator

aopex.** : aopex 패키지를 포함한 하위 패키지 전체 모든 클래스
                예) aopex.sub2.Calculator

( ) : 메서드 매개변수 패턴
    - (..) : 0 개 이상의 매개변수 패턴 - 모든 메서드
    - (*,*) : 2개의 매개변수를 가진 매개변수 패턴
    - (long) : 매개변수가 1개 있고, 자료형이 long 패턴
    - (long, *) : 매개변수가 2개, 첫번째는 long으로 고정
    - (long, ..) : 첫번째는 long으로 고정, 나머지는 있어도 되고 없어도 되는 패턴

- `* aopex.*.*()` : 모든 반환값, aopex의 모든 하위 클래스, 모든 메서드, 매개변수 없는 메서드
- `* aopex.*()`


