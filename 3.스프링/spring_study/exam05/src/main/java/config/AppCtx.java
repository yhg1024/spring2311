package config;

import aopex.*;
import config.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration // 설정 파일
@EnableAspectJAutoProxy
public class AppCtx {

    @Bean // 스프링 관리 객체라고 알려줌
    public Calculator calculator(){
        return new RecCalculator();
    }


    @Bean
    public config.ProxyCalculator getProxyCalculator() {
        return new ProxyCalculator();
    }
}
