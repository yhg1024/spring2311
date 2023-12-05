package models.member;

import commons.exceptions.BadRequestException;
import commons.validators.RequiredValidator;
import commons.validators.Validator;

public class JoinValidator implements Validator<Member>, RequiredValidator {
    public void validate(Member member) {
        // 검증하면 좋은거 : 틀대로 하니까 예상 가능한 소스
        // 인터페이스 목적은 설계하려고, 설계는 통일성이 중요하다.
        // 추상클래스는 설계에 좋지 않다.
        // soild : 객체지향 설계 원칙

        /* 필수 항목 검증(아이디, 비밀번호, 비밀번호 확인, 회원명) */
        String userId = member.getUserId();
        String userPw = member.getUserPw();
        String confirmPw = member.getConfirmPw();
        String userNm = member.getUserNm();

        // 필수 항목 - null 또는 빈 공백 문자  "   "
        checkRequired(userId, new BadRequestException("아이디를 입력하세요."));
        checkRequired(userPw, new BadRequestException("비밀번호를 입력하세요."));
        checkRequired(confirmPw, new BadRequestException("비밀번호를 확인하세요."));
        checkRequired(userNm, new BadRequestException("회원명을를 입력하세요."));
    }
}
