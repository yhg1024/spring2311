package models.member;

public class JoinService {
    private  MemberDao memberDao;
    private JoinValidator validator;
    
    public JoinService(MemberDao memberDao, JoinValidator validator) { // 의존하는 객체를 넣는다.
        this.memberDao = memberDao;
        this.validator = validator;
    }
    
    public void join(Member member) {
        // 데이터 검증
        validator.validate(member);
        
        // 데이터 추가
        memberDao.register(member);
    }
}
