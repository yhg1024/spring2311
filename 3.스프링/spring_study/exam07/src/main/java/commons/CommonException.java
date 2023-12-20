package commons;

import org.springframework.http.HttpStatus;

public class CommonException extends RuntimeException{
    // 이 예외의 하위 클래스를 모두 정의
    private HttpStatus status;

    public CommonException(String message) {
        this(message, HttpStatus.INTERNAL_SERVER_ERROR); // 500 error
    }

    public CommonException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
