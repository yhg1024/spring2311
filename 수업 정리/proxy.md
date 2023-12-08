AOP 프로그래밍
(Aspect Oriented Programming)
- 관점 지향 프로그래밍
- 관점 : 개발자들의 공통 관심사, 공통으로 항상 처리해야 할 부분
spring-aop API
aspectjweaver - 구현채

1. 프록시(proxy) = 데코레이터 패턴
   - 대신하다, 대리하다
   
    factorial 연산
    !5 -> 5 * 4 * 3 * 2 * 1
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

2. AOP 
- @EnableAspectJAutoProxy : 프록시 설정 활성
1) @Aspect : 공통 기능이 포함된 클래스
2) @Pointcut : 공통 기능이 적용될 범위
    - execution 명시자

3) @Around : 공통 기능을 수행하고 핵심 기능을 대신 수행해 주는 메서드
    - proceedingJoinPoint joinPoint
      - Signature getSignature()
        - getName() : 메서드명
        - toLongString() : 자세한 메서드 이름 정보
      - Object proceed() : 핵심 기능 대신 수행해 주는 메서드(범용 기능), object가 반환값?
      - Object[] getArgs()
      - Object getTarget() : 핵심 기능 메서드가 속해 있는 객체의 참조 변수

3. @Order

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

프록시는 