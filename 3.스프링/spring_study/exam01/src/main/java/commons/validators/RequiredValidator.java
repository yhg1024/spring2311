package commons.validators;

public interface RequiredValidator {
    // 반복되는 공통적인거 한번에 만들기
    default void checkRequired(String str, RuntimeException e) {
        if (str == null || str.isBlank()) {
            throw e;
        }
    }
}
