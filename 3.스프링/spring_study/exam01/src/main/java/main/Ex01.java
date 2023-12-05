package main;

import config.AppCtx;
import models.Greeter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex01 {
    public static void main(String[] args) {
        // 애노태이션으로 설정?담는 스프링 컨테이너
        // ApplicationContext : 스프링 컨테이너 : 객체가 담겨있고 필요할 때마다 꺼내준다.
        // 어떤 객체가 담겨 있는지는 설정으로 알려준다.
        // @Bean으로 알려준다.
        // 애노테이션 : 클래스클래스의 정보의 일부분
        // AnnotationConfig : 설정방식
        // AppCtx.class : 정보(설정)이 담긴 클래스 클래스
        // @Configuration : 설정클래스라고 알려주는 애노테이션
        AnnotationConfigApplicationContext ctx = new
                AnnotationConfigApplicationContext(AppCtx.class);

        Greeter g1 = ctx.getBean("greeter", Greeter.class);
        g1.hello("이이름");

        Greeter g2 = ctx.getBean("greeter", Greeter.class);
        System.out.println(g1 == g2);
        // 여러번 가져와도 하나의 객체
        
        ctx.close();

    }
}
