package tests;

import configs.ControllerConfig;
import configs.DbConfig;
import configs.MvcConfig;
import controllers.member.RequestJoin;
import models.member.JoinService;
import models.member.Member;
import models.member.MemberDao;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Transactional // 테스트 완료 후에 롤백, 테스트 데이터를 디비에 저장하지 않기위해
@SpringJUnitConfig
// @WebAppConfiguration // webMvc 관련 테스트
@ContextConfiguration(classes = {DbConfig.class, ControllerConfig.class})
public class JoinServiceTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private JoinService service;

    @Test
    @DisplayName("데이터베이스 연결 테스트")
    void connectionTest(){
        try (Connection conn = dataSource.getConnection()) {
            System.out.println(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("MemberDao - exist 메서드 테스트")
    void existsTest(){
        String userId = "USER01";
        boolean result = memberDao.exist(userId);

        assertTrue(result); // assertTrue - 참값이 되면 통과
    }

    @Test
    @DisplayName("JoinService - join메서드 테스트")
    void joinTest() {
        RequestJoin form = new RequestJoin();
        form.setUserId("user01");
        form.setUserPw("12345678");
        form.setUserNm("사용자01");
        form.setEmail("user01@test.org");

        service.join(form);

        Member member = memberDao.get(form.getUserId());
        System.out.println(member);
    }
}
