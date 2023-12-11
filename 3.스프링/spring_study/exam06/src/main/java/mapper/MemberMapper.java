package mapper;

import models.member.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MemberMapper {
    // @Select("SELECT * FROM MEMBER") // 실행할 쿼리, 구현체는 스프링이 알아서
    List<Member> getMembers(); // 반환값, xml파일에서 동일한 명칭의 ID값을 찾아 매칭

    // @Insert("INSERT INTO MEMBER (USER_NO, USER_ID, USER_PW, USER_NM) VALUES (SEQ_MEMBER.nextval, #{userId}, #{userPw}, #{userNm})")
    int register (Member member);

    int update (Member member);

    int delete (String userId);

}
