# 애너테이션(annotation)
1. 에너테이션이란?
- 프로그램의 소스코드 안에 다른 프로그램을 위한 정보를 미리 약속된 형식으로 포함시킨 것이 애너테이션이다.
- 주석, 주해, 설명
- 정보 전달
  @interface 애노테이션명 {

}


2. 표준 애너테이션
- JDK에 정의되어 있는 기본 애너테이션
- @Override : 컴파일러에게 재정의 하는 메서드라는 것을 알린다.
- @Deprecated : 애너테이션이 붙은 대상은 다른 것으로 대체되었으니 더 이상 사용하지 않을 것을 권한다는 의미
- @SupressWarning : 컴파일러가 보여주는 경고메시지가 나타나지 않게 억제해 준다.
- @FunctionInterface : 함수형 인터페이스라는 것을 알린다.(JDK1.8)
- @Retention : 애너테이션이 유지되는 범위를 지정하는데 사용한다.
- @Target : 애너테이션이 적용 가능한 대상을 지정하는데 사용한다.
  ...

3. 메타 애너테이션
- 애너테이션을 위한 애너테이션
- 애너테이션을 붙이는 애너테이션으로 애너테이션을 정의할 때 애너테이션의 적용대상(target)이나 유지기간(retention)등을 지정하는데 사용된다.

- @Retention (중요!!)
  - 애너테이션이 유지되는 기간을 지정하는데 사용된다
  - RetentionPolicy (애너테이션 유지정책)
      - .SOURCE : 자바 코드(소스 파일)에는 존재(java) ,클래스파일에는 존재하지 않음 -> 컴파일 이후에 제거
        -> 컴파일 시에 정보가 전달(컴파일러에게 전달)
      - .CLASS : 자바 코드에도 존재(java), 클래스 파일에도 존재(class)
        -> 기본값, 정보 전달 X
      - .RUNTIME : 자바 코드에도 존재(java), 클래스 파일에도 존재(class)
        -> 실행 중에 정보가 전달
- @Target : 애노테이션을 적용할 위치

``` java
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
```

4. 사용자 정의 애노테이션


interface 애노테이션명 extends java.lang.annotation.Annotation {

}

- 모든 애너테이션의 상위 클래스는 Annotation이다. 그러나 애너테이션은 상속이 허용되지 않으므로 명시적으로 Annotation을 상위 클래스로 지정할 수 없다.