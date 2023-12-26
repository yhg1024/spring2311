package org.choongang.restcontrollers;

import org.choongang.entities.Member;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;

@RestController
public class ApiMember2Controller {

    @GetMapping("/info")
    public Member info() {
        Member member = Member.builder()
                .userNo(1L)
                .userId("user01")
                .userPw("12345678")
                .email("user01@test.org")
                .userNm("사용자01")
                .regDt(LocalDateTime.now())
                .build();

        return member;
    }

    @GetMapping("/list")
    public List<Member> list() {
        List<Member> members = IntStream.rangeClosed(1, 10)
                .mapToObj(i -> Member.builder()
                        .userNo(Long.valueOf(i))
                        .userId("user" + i)
                        .userNm("사용자" + i)
                        .email("user" + i + "@test.org")
                        .regDt(LocalDateTime.now())
                        .build()
                ).toList();
        return members;
    }

    @GetMapping("/greet")
    public String hello() {
        return "안녕하세요.";
    }

    @GetMapping("/process")
    public void process() {
        System.out.println("처리...");
    }

    @PostMapping("/join")
    public void join(@RequestBody RequestJoin form) {
        System.out.println(form);
    }
}
