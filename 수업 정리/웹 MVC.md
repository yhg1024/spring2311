# 스프링 웹 MVC
1. 요청 매핑 : 요청 방식에 따라, 요청이 한정적이다.

Stpring4.3에 추가 된 내용
- @GetMapping
- @DeleteMapping

@PostMapping
@PutMapping
@PatchMapping

@RequestMapping : 모든 요청에 대한 매핑 (GET, POST ....)
: 공통 URL 패턴 주로 정의, 세부적으로 사용할 때


2. 커맨드 객체
    - 요청 데이터의 이름과 동일한 getter, setter가 정의된 객체
    - 요청 메서드의 매개변수로 정의만하면 알아서 주입(HandlerAdapater 에서 컨트롤러빈을 실행할때 주입)

    - 요청 데이터의 이름에 해당하는 값이 여러개 인 경우
        - 자료형 배열 또는 컬렉션(List, Set ...)

      참고) HttpServletRequest
      String[] getParameterValues()

    - 중첩된 커맨드 객체  : 커맨드 객체안에 커맨드 객체
      - th:field - 입력 형태에 따라 value, checked, selected를 알아서 선택하거나 값을 입력
    - @ModelAttribute : 현재 컨트롤러 모든 URL에서 공유할 데이터 설정시 사용

속성 : 뷰에서 사용할 데이터 setAttribute 컨트롤러안에서 처리하는 데이터 추가

3. redirect, forward
   : 페이지 이동
- 요청 메서드의 반환값 : redirect:주소

- 참고)
  - 응답 헤더
    - Location: 주소
  - HttpServletResponse
    - void sendRedirect("주소")
    
forward:/주소

RequestDispatcher
- forward : 기존 버퍼 취소하고 버퍼를 바꿔준다.?
- include : 기존 버퍼 추가

<jsp:forward page="..." />


4. 모델


참고)
스프링 관리 객체 
1) 서블릿 핵심 객체  - 스프링 컨테이너에서 추가 : 편하게 의존성 주입
    HttpServletRequest 
    HttpServletResponse 
    HttpSession 
    - 주로 요청과 응답 처리시에 많이 사용되므로 요청 메서드의 매개변수로 정의 : 자동 주입 
    - @Autowired, 생성자 매개변수 : 의존성 자동 주입 
    
2) 스프링 핵심 객체
    Model : 속성을 관리하는 메서드가 주로 정의 : EL식 속성(변수)
        addAtrribute(String name, Object value)
        addAllAttribute(Map<.....> ....)
    
    Errors : 유효성 검사 실패시 실패에 대한 정보가 담겨 있는 객체 

4. 폼 태그

# 스프링 MVC
1. 메시지
1) MessageSource
2) ResourceBundleMessageSource
3) 다국어 지원 위한 메시지 파일

2. 커맨드 객체 검증
1) Validator 인터페이스
2) Errors
- reject("에러코드") - 메세지 코드로 에러코드가 등록된 경우 -> 출력
- reject("에러코드", "기본 메세지") - 에러코드가 메세지로 등록 되지 않은 경우 기본 메세지

-- 특정 필드에 해당하는 에러 메세지 처리 --
- rejectValue("필드명", "에러코드");
- rejectValue("필드명", "에러코드", "기본메세지");

- boolean hasErrors() : reject 또는 rejectValue가 한개라도 호출 되면 -> true
- 에러 출력 -> #fields.errors("필드명")

3) ValidationUtils
   - .rejectIfEmpty
   - .rejectIfEmptyOrWhitespaces(...)

3. 에러 코드에 해당하는 메시지 코드를 찾는 규칙
- 에러코드 + "." + 커맨드객체이름 + "." + 필드명
- 에러코드 + "." + 필드명
- 에러코드 + "." + 필드타입(자료형 - 예) java.lang.Integer, java.lang.String
- 에러코드

4. 프로퍼티 타입이 List나 목록인 경우 다음 순서를 사용해서 메시지 코드를 생성한다.

에러코드 + "." + 커맨드객체이름 + "." + 필드명[인덱스].중첩필드명
에러코드 + "." + 커맨드객체이름 + "." + 필드명.중첩필드명
에러코드 + "." + 필드명[인덱스].중첩필드명
에러코드 + "." + 필드명.중첩필드명
에러코드 + "." + 중첩필드명
에러코드 + "." + 필드타입
에러코드

5. 글로벌 범위 Validator와 컨트롤러 범위 Validator
1) 글로벌 범위 Validator 설정과 @Valid 애노테이션
-  WebMvcConfigurer의 getValidalor()
2) @InitBinder 애노테이션을 이용한 컨트롤러 범위 Validator
   @InitBinder
   protected void InitBinder(WebDataBinder binder) {
   binder.setValidator(new RegisterRequestValidator());
   }

3) 컨트롤러 범위 Validator  > 글로벌 범위 Validator

6. Bean Validation
- Bean Validation API
- Hibernate Valiator 
1) 설정
2) Bean Validation의 주요 애노테이션
   - @AssertTrue, @AssertFalse : 값이 true인지 또는 false인지 검사한다. null은 유효하다고 판단한다.
   - @DecimalMax, @DecimalMin : 지정한 값보다 작거나 같은지 또는 크기가 같은지 검사한다. inclusive가 false이면 value로 지정한 값은 포함하지 않는다. null은 유효하다고 판단한다.
   - @Max, @Min : 지정한 값보다 작거나 같은지 또는 크거나 같은지 검사한다. null은 유효하다고 판단한다.
   - @Digits : 자릿수가 지정한 크기를 넘지않는지 검사한다.
     null은 유효하다고 판단한다.
   - @Size : 길이나 크기가 지정한 값 범위에 있는지 검사한다. null은 유효하다고 판단한다.
   - @Null, @NonNull : 값이 null인지 또는 null이 아닌지 검사한다.
   - @Pattern :값이 정규표현식에 일치하는지 검사한다.
     null은 유효하다고 판단한다.

Bean Validator 2.0이 추가로 제공하는 애노테이션
- @NotEmpty :문자열이나 배열의 경우 null이 아니고 길이가 0이 아닌지 검사한다. 콜렉션의 경우 null이 아니고 크기가 0이 아닌지 검사한다. (NotBlack를 더 많이 쓴다.)
- @NotBlank : null이 아니고 최소한 한 개 이상의 공백아닌 문자를 포함하는지 검사한다.
- @Positive, @PositiveOrZero : 양수인지 검사한다.   <br>
- OrZero가 붙은 것은 0 또는 양수인지 검사한다. <br> 
- null은 유효하다고 판단한다.
- @Email 	이메일 주소가 유효한지 검사한다.<br>
  null은 유효하다고 판단한다.
- @Future, @FutureOrPresent : 해당 시간이 미래 시간인지 검사한다. <br>
  OrPresent가 붙은 것은 현재 또는 미래 시간인지 검사한다. <br>
  null은 유효하다고 판단한다.
- @Past, @PastOrPresent : 해당 시간이 과거 시간인지 검사한다. <br>
  OrPresent가 붙은 것은 현재 또는 과거 시간인지 검사한다. <br>
  null은 유효하다고 판단한다.


암호화
- 양방향 암호화
    - 암호화 - 복호화
        - AES256
        - ARIA

- 단방향 암호화
    - 복호화는 불가
        - 해시
        - 고정 해시 : sha1, md5, sha256, sha512
            - : 같은 값에 대해서 동일한 해시 값이 나온다.
            - 예측이 가능해서 보안에 취약하다, 검증의 용도로만 쓴다.
        - 유동 해시 : 같은 값에 대해서 해시를 만들때 마다 다른 해시값
            - 예측 불가능성
            - BCrypt

커멘드 객체
1. 요청 데이터 매핑(set멤버변수명() .. 멤버변수명 == name)
- RequestJoin -> requestJoin : Model의 속성명으로 추가 -> 템플릿 내에서 바로 접근 가능
2. 커맨드 객체 검증 (Bean Validation API) - 에너테이션으로


# 스프링 MVC
1. 세션
   - 개인 서비스 데이터를 직접 서버에 저장
   - 개인 데이터를 찾으려면?
     - 브라우저마다 JSESSIONID 저장 : 개개인의 브라우저를 구분할 수 있는 값
     - 요청시 마다 요청 헤더 Cookie: JSESSIONID=... 를 통해서 서버에 전송
     - 요청 처리 중에 JSESSIONID -> 서버쪽에 저장된 개인 데이터를 추출 -> session 객체 생성
     - HttpServletRequest
       - HttpSession getSession() // 세션 객체 조회
   - HttpSession session 
     - setAttribute(String name, Object value)
     - Object getAttribute(String name)
     - void removeAttribute(String name) // 특정 키값만 지운다.
     - invalidate() : 세션 비우기
2. 인터셉터
- 특정 실행흐름을 가로채서 공통적인 부분을 실행
   1) HandlerInterceptor 인터페이스
   - boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception;
     : 컨트롤러 빈 실행 전 호출
     : 컨트롤러 빈 실행 전 공통 적인 처리
     : true -> 컨트롤러 빈을 호출 실행
     : false -> X
     : + 인가(페이지 접근 제한)

   - void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception;
     : 컨트롤러 빈 실 행 후, 응답 전 호출
     : 컨틀로러 빈 실 행 후 공통적인 처리

   - void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception;
     : 응답 완료 후 호출
     : 응답 완료 후 공통적인 정리 작업..

/mypage

2) WebMvcConfigurer 인터페이스 : addInterceptors(InterceptorRegistry registry)
   -> 적용할 URL 패턴 + 인터셉터 객체

   3) Ant 경로 패턴
- * : 0개 또는 그 이상의 글자
  - ** 0개 또는 그 이상의 폴더 경로
  - ? : 1개 글자

/mypage/**

/mypage
/mypage/sub
/mypage/sub/sub2

3. 쿠키
- 개인 서비스 구현 기술 (개개인을 구분해서 서비스를 제공)
- 개개인을 어떻게 구분?
  - 브라우저별로 데이터를 저장함으로써 개개인의 데이터를 유지
     - NNB - 브라우저마다 다른 값
- 쿠키 데이터(개개인 구분 데이터)는 서버가 필요한 데이터
  - 매 요청시마다 요청 헤더(cookie)에 실어서 함께 전송

same-site : 같은 사이트끼리만 쿠키공유

서블릿
- 쿠키 등록
  - 응답 헤더 : Set-Cookie : 키=값, 키=값;
  - HttpServletResponse::addCookie(Cookie cookie)
- 쿠키 조회
  - 요청 헤더 : Cookie 항목으로 전송
  - HttpServletRequest
    - Cookie[] getCookies()

문제?
1. 요청시 마다 헤더에 실려서 서번에 전송 : 노출 - 보안에 취약
   - 개인정보는 절개 사용 불가
   - 쿠키는 암호화가 필수
2. 요청시 마다 헤더에 실려서 서버에 전송 : 전송 데이터가 많아진다. 네트워크에 부담

세션 : 이러한 문제점을 해결하기 위한 기술

@CookieValue 쿠키명과 동일한 변수명
- 쿠키 개별 조회
- 특정 변수에 주입, 형변환도 자동

통합테스트
- MockMvc

1. 날짜 값 변환
   @DateTimeFormat
- LocalDate, LocalTime, LocalDateTime .. - JSR310 - Date & Time API
- 형식이 일치 하지 않으면 예외 발생
    - 메세지 코드 typeMismatch
      - 메세지코드
      - 메세지코드.필드명
      - 메세지코드.커맨드 객체명.필드명
      - 메세지코드.자료형 타입
      - 메세지코드.커맨드 객체명.자료형 타입
    - typeMismatch.java.LocalDate

2. @PathVariable : 경로 변수

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