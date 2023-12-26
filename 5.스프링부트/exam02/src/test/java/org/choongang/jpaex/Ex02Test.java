package org.choongang.jpaex;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.choongang.entities.Member;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootTest
@Transactional
@TestPropertySource(properties = "spring.profiles.active=test")
public class Ex02Test {

    @PersistenceContext
    private EntityManager em;  // 엔티티 영속성 관리

    @Test
    void test1() {
        Member member = new Member();
        member.setEmail("user01@test.org");
        member.setName("사용자01");
        member.setPassword("12345678");
        // member.setCreateAt(LocalDateTime.now());

        em.persist(member); // 영속성 contest안에 넣기
        em.flush(); // DB 반영
        em.clear();

        member = em.find(Member.class, member.getSeq());

        System.out.println(member);

        try {
            Thread.sleep(3000); // 3초 지연
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        member.setName("(수정)사용자01");
        em.flush();
        em.clear();

        member = em.find(Member.class, member.getSeq());
        System.out.println(member);
    }

    @Test
    void test2() {
        Member member = new Member();
        member.setEmail("user01@test.org");
        member.setName("사용자01");
        member.setPassword("12345678");

        em.persist(member);
        em.flush();

        System.out.printf("createdAt=%s, modifiedAt=%s%n", member.getCreatedAt(), member.getModifiedAt());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        member.setName("(수정)사용자01");
        em.flush();

        System.out.printf("createdAt=%s, modifiedAt=%s%n", member.getCreatedAt(), member.getModifiedAt());
    }
}
