# REST(Representational State Transfer) API 
    : 표현적 상태 정의

- URI
- METHOD
  - GET
  - POST
  - PUT
  - PATCH
  - DELETE

데이터 공유시 데이터 표기의 통일성을 위해 형식을 정한다.
- XML
- JSON (JavaScript Object Notation) - 자바스크립트 객체 표기법
  - 일반적인 방식
  ```json
    {
      "키" : "값",
      "키" : "값"
    }
    ```
  
의존성
- jackson-databind
- jackson-datatype-jsr310 : Date Time API

@RestController 
    : 반환값 : 자바 객체(getter) : JSON 변환

    @ResponseBody : 응답 -> body로 직접 출력 (JSON출력)
    - 메서드 단위 REST 변환

@JsonIgnore 
    : 변환 배제

@JsonFormat
    : 날짜의 형식화

@RequestBody
    : JSON 요청 데이터를 변환을 할 수 있도록 알려주는 정보 -> 커맨드 객체 변환