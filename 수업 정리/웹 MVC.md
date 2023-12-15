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
- 
2) Errors
3) ValidationUtils


3. 에러 코드에 해당하는 메시지 코드를 찾는 규칙
- 에러코드 + "." + 커맨드객체이름 + "." + 필드명
- 에러코드 + "." + 필드명
- 에러코드 + "." + 필드타입
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
1) 설정
2) Bean Validation의 주요 애노테이션
   @AssertTrue
   @AssertFalse
   @DecimalMax
   @DecimalMin
   @Max
   @Min
   @Digits
   @Size
   @Null
   @NonNull
   @Pattern

@NotEmpty
@NotBlank
@Positive
@PositiveOrZero
@Email
@Future
@FutureOrPresent
@Past
@PastOrPresent