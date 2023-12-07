package models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class JoinService {
    @Autowired // 의존성 자동주입 스프링한태 알려줌, 담겨있는 Bean이 있으면 담아줘
    // @Qualifier("memberDao")
    private  MemberDao memberDao;

    @Autowired
    private JoinValidator validator;

    @Autowired
    public JoinService(MemberDao memberDao, JoinValidator validator) {
        this.memberDao = memberDao;
        this.validator = validator;
    }

    public JoinService () {}

    public void join(Member member) {
        // 데이터 검증
        validator.validate(member);
        
        // 데이터 추가
        memberDao.register(member);
    }
}
