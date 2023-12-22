package org.choongang.commons;

import org.springframework.http.HttpStatus;

public class CommonException extends RuntimeException {
    private HttpStatus status;

    public CommonException(String message) {
        this(message, HttpStatus.INTERNAL_SERVER_ERROR); // 500 에러
    }
    public CommonException(String message, HttpStatus status) {
        super(message);
        this.status = status; // 응답 객체 직접 설정
    }

    public HttpStatus getStatus() {
        return status;
    }
}
