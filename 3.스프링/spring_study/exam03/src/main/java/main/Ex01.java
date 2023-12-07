package main;

import config.AppCtx;
import config.AppCtx2;
import config.AppCtx3;
import config.AppCtx4;
import models.member.JoinService;
import models.member.ListService;
import models.member.Member;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;

public class Ex01 {
    public static void main(String[] args) {
        // 스프링 컨테이너-
        AnnotationConfigApplicationContext ctx
                = new AnnotationConfigApplicationContext(AppCtx4.class);

        // 싱글톤
        JoinService joinService = ctx.getBean(JoinService.class);
        // ctx.getBean("joinService", JoinService.class)와 동일
        // JoinService는 하나라 name을 지워도 문제가 없다.
        ListService listService = ctx.getBean(ListService.class);

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
