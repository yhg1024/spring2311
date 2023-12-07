package config;

import aopex.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 설정 파일
public class AppCtx {

    @Bean // 스프링 관리 객체라고 알려줌
    public Calculator calculator(){
        return new RecCalculator();
    }
}
