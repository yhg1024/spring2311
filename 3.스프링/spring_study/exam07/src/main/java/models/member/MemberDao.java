package models.member;

import controllers.admin.MemberSearch;
import lombok.RequiredArgsConstructor;
import mapper.MemberMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor // 초기화 되지않은 final 필드나, @NonNull 이 붙은 필드에 대해 생성자를 생성
public class MemberDao {

    private final MemberMapper mapper;

    public boolean register(Member member) {
        int affectedRows = mapper.register(member);
        return  affectedRows > 0;
    }

    public boolean exist(String userId) {
        int cnt = mapper.exist(userId);

        return cnt > 0; // 1이상 - 이미 등록된 id
    }

    public Member get(String userId) {
        return mapper.get(userId);
    }

    public List<Member> getList(MemberSearch search) {
        LocalDate edate = search.getEdate();
        if (edate != null) {
            LocalDate newEdate = edate.plusDays(1);
            search.setEdate(newEdate);
        }

        return mapper.getList(search);
    }
}
