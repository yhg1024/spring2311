package config;

import models.member.JoinService;
import models.member.JoinValidator;
import models.member.ListService;
import models.member.MemberDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {AppCtx3.class}) // 설정항목이 1개면 value가 없어도 된다. (AppCtx3.class는 있어야한다.)
public class AppCtx2 {

    @Bean
    public JoinValidator joinValidator() {
        return new JoinValidator();
    }

    @Bean
    public JoinService joinService() {
        return new JoinService();
    }

    @Bean
    public ListService listService () {
        return new ListService();
    }
}
