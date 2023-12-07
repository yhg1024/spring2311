package commons.validators;

import org.springframework.util.StringUtils;

public interface RequiredValidator {
    // 반복되는 공통적인거 한번에 만들기
    default void checkRequired(String str, RuntimeException e) {
        if (!StringUtils.hasText(str)) { // 널값도 체크하고 빈공간(문자열이 없을때)도 체크
            throw e;
        }
    }

    // 참이 아닐때 예외 발생
    default  void checkTrue(boolean result, RuntimeException e) {
        if (!result) {
            throw e;
        }
    }

    // 참일때 예외 발생
    default void checkFalse(boolean result, RuntimeException e) {
        if (result) {
            throw e;
        }
    }
}
