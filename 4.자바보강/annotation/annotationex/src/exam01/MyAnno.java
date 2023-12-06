package exam01;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {
    String value(); // 추가적인 정보 전달 설정
}
/*
@interface 애너테이션이름 {
	타입 요소이름(); // 애너테이션의 요소를 선언한다.
	...
}
* */