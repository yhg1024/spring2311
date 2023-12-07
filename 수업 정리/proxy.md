AOP 프로그래밍
(Aspect Oriented Programming)
- 관점 지향 프로그래밍
- 관점 : 개발자들의 공통 관심사, 공통으로 항상 처리해야 할 부분
spring-aop API
aspectjweaver

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
1) @Aspect : 공통 기능이 포함된 클래스
2) @Pointcut : 공통 기능이 적용될 범위
    - execution 명시자

3) @Around : 공통 기능을 수행하고 핵심 기능을 대신 수행해 주는 메서드

3. @Order

4. 프록시 생성방식
5. @Around의 Pointcut 설정과 @Pointcut 재사용