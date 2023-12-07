package models.member;

import java.util.List;

public class ListService {

    private MemberDao memberDao; // 뒤에 new MemberDao를 쓰지 않는건 통제하기 위해서 외부에서 주입하기 위해

    public void setMemberDao(MemberDao memberDao) {
        // 통제하기 위해
        // //stter를 통한 주입
        this.memberDao = memberDao;
    }

    public void print() {
        List<Member> members = memberDao.getList();
        for (Member member : members) {
            System.out.println(member);
        }
    }
}
