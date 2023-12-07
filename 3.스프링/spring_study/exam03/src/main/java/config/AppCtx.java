package config;

import models.member.JoinService;
import models.member.JoinValidator;
import models.member.ListService;
import models.member.MemberDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// 설정 클래스(config)에서 객체를 어떻게 조립할지 알려준다.
@Configuration
public class AppCtx {
    @Bean // 뭐 해달라고 알려주는거
    public MemberDao memberDao() {

        return new MemberDao();
    }

    @Bean
    public JoinValidator joinValidator() {
        return new JoinValidator(memberDao());
    }

    @Bean
    public JoinService joinService() {
        return new JoinService(memberDao(), joinValidator());
    }

    @Bean
    public ListService listService() {
        ListService listService = new ListService();
        listService.setMemberDao(memberDao());

        return listService;
    }
}
