package config;

import aopex.*;
import config.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration // 설정 파일
@EnableAspectJAutoProxy(proxyTargetClass = true) // 프록시 설정, 하위클래스 기반의 프록시
public class AppCtx {

    @Bean // 스프링 관리 객체라고 알려줌
    public Calculator calculator(){
        return new RecCalculator();
    }

    @Bean
    public ProxyCache proxyCache() {
        return new ProxyCache();
    }

    @Bean
    public config.ProxyCalculator getProxyCalculator() {
        return new ProxyCalculator();
    }
}
