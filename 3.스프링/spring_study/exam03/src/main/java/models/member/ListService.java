package models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.Nullable;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class ListService {


    private MemberDao memberDao; // 뒤에 new MemberDao를 쓰지 않는건 통제하기 위해서 외부에서 주입하기 위해

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy.MM.dd");

    @Autowired  // (required = false)
    public void setFormatter(@Nullable DateTimeFormatter formatter) {
        this.formatter = formatter;
    }

    @Autowired
    public void setMemberDao(@Qualifier("memberDao") MemberDao memberDao) {
        // 통제하기 위해
        // //stter를 통한 주입
        this.memberDao = memberDao;
    }

    public void print() {
        List<Member> members = memberDao.getList();
        for (Member member : members) {
            if (formatter != null) {
                String regDtstr = formatter.format(member.getRegDt());
                member.setRegDtStr(regDtstr);
            }

            System.out.println(member);
        }
    }
}
