package config;

import models.member.MemberDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
/*@ComponentScan(value = "models",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,
                    classes = ManualBean.class))*/

/*@ComponentScan(value = "models",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,
            classes = MemberDao.class))*/

@ComponentScan(value = "models",
    excludeFilters = @ComponentScan.Filter(type = FilterType.ASPECTJ,
    pattern = "models..*Dao")) // 모델이 들어간 패턴 배재
public class AppCtx {

    /*
    @Bean
    public MemberDao memberDao() { // 이름이 동일한 경우 수동 등록 빈이 자동 등록 빈보다 우선 순위가 높다.
        System.out.println("수동 등록빈");
        return new MemberDao();
    }
    */
}
