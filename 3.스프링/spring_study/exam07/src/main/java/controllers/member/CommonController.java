package controllers.member;

import commons.CommonException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("controllers") // 컨트롤러 실해 전 공통 기능, controllers를 포함한 하위 패키디 모두에 적용
public class CommonController {
    @ExceptionHandler(RuntimeException.class)
    public String errorHandler(RuntimeException e, Model model, HttpServletResponse response) {

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; // 500 error
        if (e instanceof CommonException) {
            CommonException commonException = (CommonException) e;
            status = commonException.getStatus();
        }

        response.setStatus(status.value()); // 응답코드 고정?

        e.printStackTrace();

        model.addAttribute("message", e.getMessage());

        return  "error/common";
    }
}
