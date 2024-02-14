package commons;

import member.controllers.Member;

public class Joinvalidator implements Validator<Member>, RequiredValidator {
    @Override
    public void check(Member member) {
        String userId = member.getUserId();
        String userPw = member.getUserPw();
        String confirmPw = member.getConfirmPw();
        String userNm = member.getUserNm();


    }
}
