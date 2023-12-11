package jdbctest;

import config.AppCtx;
import models.member.Member;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppCtx.class) // 의존성 주입으로 테스트 준비
public class jdbcTemplateTest {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test // 하나의 테스트 단위
    @DisplayName("DataSource를 통한 DB연결 테스트")
    void connectionTest() {
        try (Connection conn = dataSource.getConnection()) {
            System.out.println(conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("INSERT 테스트")
    void insertTest(){
        // DataAccessException - RuntimeException - 예외처리 x -> 실핼

        String sql = "INSERT INTO MEMBER (USER_NO, USER_ID, USER_PW, USER_NM, EMAIL) " +
                " VALUES (SEQ_MEMBER.nextval, ?, ?, ?, ?)";
        int affectedRows = jdbcTemplate.update(sql, "USER99", "123456", "사용자99", "user99@test.org");
        System.out.println(affectedRows);
    }

    @Test
    @DisplayName("목록 출력 테스트")
    void selectTest() {
        String sql = "SELECT * FROM MEMBER";

        List<Member> members = jdbcTemplate.query(sql, this::mapper); // build로 넘겨주면 list형태로 회원 데이터가 넘어온다.


        for (Member member : members) {
            System.out.println(member);
        }
    }

    /**
        List<Member> members = jdbcTemplate.query(sql, new RowMapper<Member>() { // new RowMapper<Member>() -> 생략 가능 , 람다사용
        @Override
        public Member mapRow(ResultSet rs, int rowNum) throws SQLException { // rowMapp 내부 호출
            return Member.builder()
                    .userNo(rs.getLong("USER_NO"))
                    .userId(rs.getString("USER_ID"))
                    .userPw(rs.getString("123456"))
                    .userNm(rs.getString("USER_NM"))
                    .email(rs.getString("EMAIL"))
                    .regDt(rs.getTimestamp("REG_DT").toLocalDateTime())
                    .build(); // build로 넘겨주면 list형태로 회원 데이터가 넘어온다.
        }
    });
    */

    private Member mapper(ResultSet rs, int i) throws  SQLException {
        return  Member.builder()
                .userNo(rs.getLong("USER_NO"))
                .userId(rs.getString("USER_ID"))
                .userPw(rs.getString("123456"))
                .userNm(rs.getString("USER_NM"))
                .email(rs.getString("EMAIL"))
                .regDt(rs.getTimestamp("REG_DT").toLocalDateTime())
                .build();
    }


}
