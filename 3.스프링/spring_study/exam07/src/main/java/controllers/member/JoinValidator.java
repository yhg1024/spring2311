package controllers.member;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class JoinValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) { // 검증 커맨드 객체를 제한
        return clazz.isAssignableFrom(RequestJoin.class);
    }

    /**
     * 실제로 검증을 수행할 메서드
     *
     * @param target the object that is to be validated / 검증할 커맨드 객체
     * @param errors contextual state about the validation process / 검증 실패시 에러 정보를 처리
     */
    @Override
    public void validate(Object target, Errors errors) {
        /*
        1. 필수 항목 검증(userId, userPw, confirmPw, userNm, agree) - o
        2. 중복 ID 여부를 체크
        3. 아이디 최소 자리수(6자리 이상) 체크 - o
        4. 비밀번호 최소 자리수(8자리 이상) 체크 - o
        5. 이메일 값은 필수는 아니지만 값이 있으면 형식 체크 - o
        6. 비밀번호, 비밀번호 확인 일치여부
         */

        RequestJoin form = (RequestJoin) target;
        String userId = form.getUserId();
        String userPw = form.getUserPw();
        String confirmPw = form.getConfirmPw();
        /*String userNm = form.getUserNm();
        String email = form.getEmail();
        boolean agree = form.isAgree();*/

        if (StringUtils.hasText(userPw) && StringUtils.hasText(confirmPw)
                && !userPw.equals(confirmPw)) {
            errors.rejectValue("confirmPw", "Mismatch");
        }

        /*if (userId == null || userId.isBlank()) {

        }
        if (!StringUtils.hasText(userId)) {
            errors.rejectValue("userId", "Required", "아이디를 입력하세요.");
        }
        if (!StringUtils.hasText(userPw)){
            errors.rejectValue("userPw", "Required", "비밀번호를 입력하세요.");
        }

        if(!StringUtils.hasText(confirmPw)) {
            errors.rejectValue("confirmPw", "Required", "비밀번호를 확인하세요.");
        }

         */
    }
}
