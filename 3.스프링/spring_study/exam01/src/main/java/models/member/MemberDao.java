package models.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberDao {
    private  static Map<String, Member> members = new HashMap<>();

    // 아이디 추가 (가입)
    public void register(Member member) {
        members.put(member.getUserId(), member);
    }

    // 아이디가 포함된건지 체크
    public boolean exists(String userId) {
        return members.containsKey(userId);
    }

    // 회원 데이터 목록을 가져온다.
    public List<Member> getList() {
        return  new ArrayList<>(members.values());
    }
}
