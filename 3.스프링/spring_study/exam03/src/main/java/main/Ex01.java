package main;

import config.AppCtx;
import config.AppCtx2;
import config.AppCtx3;
import models.member.JoinService;
import models.member.ListService;
import models.member.Member;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;

public class Ex01 {
    public static void main(String[] args) {
        // 스프링 컨테이너-
        AnnotationConfigApplicationContext ctx
                = new AnnotationConfigApplicationContext(AppCtx2.class, AppCtx3.class);

        // 싱글톤
        JoinService joinService = ctx.getBean("joinService", JoinService.class);
        ListService listService = ctx.getBean("listService", ListService.class);

        Member member = new Member();
        member.setUserId("userId");
        member.setUserPw("123456");
        member.setConfirmPw("123456");
        member.setUserNm("사용자01");
        member.setRegDt(LocalDateTime.now());

        joinService.join(member);

        listService.print();

        ctx.close();
    }
}
