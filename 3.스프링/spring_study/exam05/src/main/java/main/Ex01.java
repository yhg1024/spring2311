package main;

import aopex.*;
import config.AppCtx;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex01 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        Calculator cal = ctx.getBean(Calculator.class);
        long result = cal.factorial(10L);
        System.out.printf("cal : %d%n", result);




        ctx.close();
    }
}
