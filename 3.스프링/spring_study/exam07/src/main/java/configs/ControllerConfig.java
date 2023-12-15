package configs;

import controllers.HelloController;
import controllers.member.MemberController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("controllers") // 자동스캔 범위, 스프링 자동객체를 쓰기위한
public class ControllerConfig {
    /*@Bean
    public HelloController helloController(){
        return new HelloController();
    }

    @Bean
    public MemberController memberController(){
        return new MemberController();
    }*/
}
