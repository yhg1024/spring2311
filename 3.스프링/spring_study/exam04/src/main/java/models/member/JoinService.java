package models.member;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor // 초기화가 반드시 필요한 멤버 변수를 생성자 매개변수로 자동 생성
public class JoinService { // 빈의 이름 joinService

    private final MemberDao memberDao;

    private final JoinValidator validator;

    /*

    // @Autowired 애노테이션을 사용하지 않고 자동 주입 방법
    //        - 생성자 매개 변수 정의 / 기본 생성자X -> 컴포넌트 스캔에서 적용
    public JoinService(MemberDao memberDao, JoinValidator validator) {
        this.memberDao = memberDao;
        this.validator = validator;
    }
    // @RequiredArgsConstructor로 해결해도 된다.

     */

    public void join(Member member) {
        // 데이터 검증
        validator.validate(member);
        
        // 데이터 추가
        memberDao.register(member);
    }
}
