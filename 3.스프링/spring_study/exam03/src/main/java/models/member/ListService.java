package models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ListService {


    private MemberDao memberDao; // 뒤에 new MemberDao를 쓰지 않는건 통제하기 위해서 외부에서 주입하기 위해

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy.MM.dd");

    /*
    자동 주입대상이 없을 경우 메서드 자체가 호출되지 않음
    @Autowired(required = false)
    public void setDateTimeFormatter(Optional<DateTimeFormatter>dateTimeFormatter){
           this.dataTimeFormatter = dateTimeFormatter;
    }
    */
    @Autowired  // (required = false)
    public void setFormatter(@Nullable DateTimeFormatter formatter) {
        this.formatter = formatter;
    }

    @Autowired
    public void setMemberDao(MemberDao memberDao) {
        // setMemberDao(@Qualifier("memberDao") MemberDao memberDao)
        // 주입받는 객체가 매개변수로 들어가 있어서 그 앞에다 쓴거다
        // 통제하기 위해
        // //setter를 통한 주입
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
