package member.controllers;

import commons.RequiredValidator;
import commons.Validator;
import member.service.BadRequestException;

public class JoinValidator implements Validator<Member>, RequiredValidator {
    @Override
    public void check(Member member) {
        String userId = member.getUserId();
        String userPw = member.getUserPw();
        String confirmPw = member.getConfirmPw();
        String userNm = member.getUserNm();

        checkRequired(userId, new BadRequestException("아이디를 입력하세요."));
        checkRequired(userPw, new BadRequestException("비밀번호를 입력하세요."));
        checkRequired(confirmPw, new BadRequestException("비밀번호를 확인하세요."));
        checkRequired(userNm, new BadRequestException("회원명을 입력하세요."));
    }
}