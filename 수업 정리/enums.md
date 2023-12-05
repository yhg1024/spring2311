열거형(enums)
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

1) name(), ordinal()

2) 컴파일러가 자동 추가해주는 메서드
    valueof(...) : 변환 메서드

3. 모든 열거형의 상위 클래스 - java.lang.Enum

1) Enum 클래스에 정의된 메서드
    - int ordinal() : 상수가 정의된 위치 번호(0부터 시작)
    - String name() : 상수명을 문자열로 변경
    - static valueOf : 변환 메서드 (문자열 -> Enum 상수)

2) 컴파일러가 자동으로 추가해주는 메서드
   valueOf : 변환 메서드 (문자열 -> Enum 상수 )

4. 열거형에 멤버 추가하기
5. 열거형에 추상메서드 추가하기


애너테이션(annotation)
1. 에너테이션이란?
- 주석, 주해, 설명
- 정보 전달
  @interface 애노테이션명 {

}


2. 표준 애너테이션
- JDK에 정의되어 있는 기본 애너테이션
- @Override
- @Deprecated
- @SupressWarning
- @FunctionInterface
- @Retention
- @Target
  ...

3. 메타 애너테이션
- @Retention
  애너테이션 소스 유지 정책
  RetentionPolicy
  .SOURCE
  : 자바 코드에는 존재(java) -> 컴파일 이후에 제거
  -> 컴파일 시에 정보가 전달(컴파일러에게 전달)
  .CLASS
  : 자바 코드에도 존재(java), 클래스 파일에도 존재(class)
  -> 기본값, 정보 전달 X
  			
  		.RUNTIME
  			: 자바 코드에도 존재(java), 클래스 파일에도 존재(class)
  							-> 실행 중에 정보가 전달
- @Target

4. 사용자 정의 애노테이션


interface 애노테이션명 extends java.lang.annoation.Annotation {

}