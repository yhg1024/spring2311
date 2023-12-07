package models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JoinService {
    @Autowired
    private  MemberDao memberDao;
    @Autowired
    private JoinValidator validator;
    
    public void join(Member member) {
        // 데이터 검증
        validator.validate(member);
        
        // 데이터 추가
        memberDao.register(member);
    }
}
