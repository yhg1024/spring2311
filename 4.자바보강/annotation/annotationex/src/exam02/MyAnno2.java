package exam02;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno2 {
    String value() default "기본값"; // 따로설정하지 않으면 default 뒤에 값이 들어간다.

    int[] nums();

}
