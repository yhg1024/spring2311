스프링 MVC 시작하기
1. 스프링 MVC를 위한 설정
1) 실습에 플요한 의존성
- spring webmvc
- servlet-api
- servlet.jsp-api
- spring-jdbc
- tomcat-jdbc
- mybatis
- mybatis-spring

- slf4j-api
- logbak-classic

- lombok

1) 컨트롤러 구현
2) JSP 구현

2. 스프링 MVC 프레임워크 동작 방식
   요청(/hello) -> DispatcherServlet -> HandlerMapping -> 컨트롤러 빈(스프링 컨테이너) -> HandlerAdapter -> 컨트롤러 빈 -> 실행 -> ModelAndView
   HandlerAdapter : 컨트롤러 빈의 종류가 다양하기 때문에 맞춰서 실행하기 위한 목적
   @Controller, Controller 인터페이스의 구현체, HttpRequestHandler 인터페이스 구현체


ModelAndView :
1) Model : 데이터 (EL 속성으로 추가된 데이터)
2) View : 출력 템플릿 경로 정보

3. WebMvcConfigurer 인터페이스와 설정

4. 정리
1) DispatcherServlet
   : 요청과 응답의 창구 역할을 하는 서블릿 클래스
   - 스프링 컨테이너 생성

2) HandlerMapping
   : 요청 방식 + 주소 -> 스프링 컨테이너에 있는 컨트롤러 빈을 검색

3) HandlerAdapter
   : 형태가 다양한 컨트롤러 빈(@Controller, Controller 인터페이스, HttpRequestHandler 인터페이스) -> 실행 -> ModelAndView로 반환

   참고) ModelAndView
   - addObject(String name, String value) : EL 속성으로 추가되는 속성
   - setViewName(...) : 뷰 경로

   요청메서드의 반환값이 String 이미지만 -> HandlerAdpter에서 실행시 ModelAndView 객체로 변환

4) ViewResolver
   : ModelAndView 정보 -> 출력을 위한 View 객체 검색


5. 요청 처리에 대한 편의 기능 제공
    1) 요청 데이터의 이름과 동일한 매개변수를 요청 메서드에 정의하면 자동으로 주입
    2) 정의한 변수의 자료형으로 자동 형변환
    3) 요청 데이터의 이름과 요청 메서드에 정의한 이름이 다른 경우
       @RequestParam("요청 데이터의 이름")
       - required : true(기본값) : 요청 파라미터의 필수

   요청 데이터
   GET : ?이름=값&이름=값
   POST : 요청 바디 이름=값&이름=값

   	HttpServletRequest 
   		String getParameter(String name)
   		String[] getParameterValues(String name);