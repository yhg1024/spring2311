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

DispatcherServlet : 모든 요청의 창구
- init(ServletConfig config) : 가장 먼저 호출
   - 설정을 주로 처리, 최초의 한번만 호출
   - WebApplicationContext : 스프링 컨테이너 객체 생성
      - 설정 클래스는? 설정 값 - contextConfigLocation 항목에 정의된 클래스
- 매 요청시 마다 doGet, doPost
- destroy()

ModelAndView 
- 통일성을 위해 사용
1) Model : 데이터 (EL 속성으로 추가된 데이터)
2) View : 출력 템플릿 경로 정보

3. WebMvcConfigurer 인터페이스와 설정
   - 주요 Mvc 설정 항목을 제공

4. 정리
   1) DispatcherServlet
      : 요청과 응답의 창구 역할을 하는 서블릿 클래스
      - 스프링 컨테이너 생성
      - web.xml 안에 있다.

2) HandlerMapping
   : 요청 방식 + 주소 -> 스프링 컨테이너에 있는 컨트롤러 빈을 검색, 찾는거

3) HandlerAdapter
   : 형태가 다양한 컨트롤러 빈(@Controller, Controller 인터페이스, HttpRequestHandler 인터페이스) -> 실행 -> ModelAndView로 반환

   참고) ModelAndView : 속성에 대한 값을 담고있고 뷰에 대한 경로가 있다.
   - addObject(String name, String value) : EL 속성으로 추가되는 속성
   - setViewName(...) : 뷰 경로

   요청메서드의 반환값이 String 이미지만 -> HandlerAdpter에서 실행시 ModelAndView 객체로 변환

4) ViewResolver
   : ModelAndView 정보 -> 출력을 위한 View 객체 검색

@EnableWebMvc : 3가지 관리 객체(HandlerMapping, HandlerAdapter, ViewResolver)가 설정 자동화


5. 요청 처리에 대한 편의 기능 제공
    1) 요청 데이터의 이름과 동일한 매개변수를 요청 메서드에 정의하면 자동으로 주입
    2) 정의한 변수의 자료형으로 자동 형변환
       - 기본 방식 -> String getParameter() -> 원하는 자료형으로 형변환
       - 자동 형변환
    3) 요청 데이터의 이름과 요청 메서드에 정의한 이름이 다른 경우
       @RequestParam("요청 데이터의 이름")
       - required : true(기본값) : 요청 파라미터의 필수

   요청 데이터
   GET : ?이름=값&이름=값
   POST : 요청 바디 이름=값&이름=값

	HttpServletRequest 
   		String getParameter(String name)
   		String[] getParameterValues(String name);

Get /Hello -> DispatcherServlet -> HandlerMapping -> HelloController 빈 
-> HandlerAdapter -> HelloController::hello 호출 -> ModelAndView 객케 -> ViewResolver -> View 객체 검색 -> 응답
-> HandlerAdapter -> HelloController::hello에 정의된 메서드 매개변수를 파악 -> 자동 주입 -> 호출

자동 주입 : 실행 될때 주입
1) 요청 데이터
    @RequestParam("파마리터명") 변수 -> 요청 데이터(GET, POST ...) 중에서 주입
    변수의 자료형 대로 자동으로 형변환 처리
2) 서블릿 기본 객체
   (HttpServletRequest, HttpServletResponse, HttpSession)
3) 스프링 WebMvc 기본 객체
    Model -> 데이터용 객체 -> 추가 데이터는 EL식 변수 형태로 접근 가능
         (== request.setAttribute(...))
         - addAtrribute(String name, Object value)
    Errors ..

편의상 서블릿 기본 객체 -> 스프링 컨테이너에 빈으로 관리
- HttpServletRequest
- HttpServletResponse
- HttpSession


Ant 경로 패턴
/mypage/** : /mypage 경로를 포함한 모든 하위 경로
            /mypage, /mypage/sub1, /mypage/sub1/sub2

/mypage/* : /mypage를 포함한 바로 하위 경로
            /mypage, /mypage/sub1, /mypage/sub2 ...

? : 문자 1개
/m0? -> /m001, /m01a /m02 ...

### 정리
- DispatcherServlet : 웹 브라우저의 요청을 받기 위한 창구 역할을 하고, 다른 주요 구성 요소들을 이용해서 요청 흐름을 제어하는 역할을 한다.
- HandlerMapping : 클라이언트의 요청을 처리할 핸들러 객체를 찾아준다. 핸들러(커맨드) 객체는 클라이언트의 요청을 실제로 처리한 뒤 뷰 정보와 모델을 설정한다.
- HandlerAdapter : DispatcherServlet과 핸들러 객체 사이의 변환을 알맞게 처리해 준다.
- ViewResolver : 요청 처리 결과를 생성할 View를 찾아주고 View는 최종적으로 클라이언트에 응답을 생성해서 전달한다.

3. 컨트롤러 익셉션 처리하기
1) @ExceptionHandler
    - 발생 예외를 정의
    - 예외발생시 특정 페이지를 노출
    - 메서드에 자동 주입
        - 발생한 예외 객체
        - Model
        - HttpServletRequest
        - HttpServletResponse
        - HttpSession

2) @ControllerAdvice
    - 컨트롤러 실해 전 공통 기능