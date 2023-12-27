package org.choongang.jpaex;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.choongang.entities.BoardData;
import org.choongang.entities.Member;
import org.choongang.entities.QBoardData;
import org.choongang.repositories.BoardDataRepository;
import org.choongang.repositories.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.choongang.entities.QMember.member;

@SpringBootTest
@Transactional
@TestPropertySource(properties = "spring.profiles.active=test")
public class Ex06Test {

    @Autowired
    private BoardDataRepository boardDataRepository;
    @Autowired
    private MemberRepository memberRepository;

    @PersistenceContext
    private EntityManager em; // 엔티티를 비우고 다시 쿼리 실행

    @BeforeEach
    void init() {
        Member member = new Member(); // 외래키로 회원번호가 추가된다.
        member.setEmail("user01@test.org");
        member.setName("사용자01");
        member.setPassword("12345678");

        memberRepository.saveAndFlush(member);

        List<BoardData> items = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            BoardData item = new BoardData();
            item.setSubject("제목" + i);
            item.setContent("내용" + i);
            item.setMember(member);
            items.add(item);
        }

        boardDataRepository.saveAllAndFlush(items);
        em.clear(); // 엔티티 비우기

        /*BoardData data = new BoardData();
        data.setSubject("제목1");
        data.setContent("내용1");
        data.setMember(member); // 엔티티로 추가된다.

        boardDataRepository.saveAndFlush(data);*/
    }

    @Test
    void test1() {
        BoardData data = boardDataRepository.findById(1L).orElse(null);
        /*
        *    left join
        member m1_0
            on m1_0.seq=bd1_0.user_no  */
        Member member = data.getMember();
        String email = member.getEmail(); // 2차 쿼리 수행
        System.out.println(email);
        // System.out.println(member);
    }

    @Test
    void test2() {
        Member member = memberRepository.findByEmail("user01@test.org");
        List<BoardData> items = member.getItems();
        items.forEach(System.out::println); // BoardData -> toString()
    }

    @Test
    void test3() {
        List<BoardData> items = boardDataRepository.findAll(); // 1차 쿼리
        for (BoardData item : items) {
            Member member = item.getMember();
            String email = member.getEmail(); // 2차 쿼리 실행
        }
    }

    @Test
    void test4() {
        // List<BoardData> items = boardDataRepository.getSubjects("목");
        List<BoardData> items = boardDataRepository.findBySubjectContaining("목");
    }

    @Test
    void test5() {
        QBoardData boardData = QBoardData.boardData;
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(em);

        List<BoardData> items = jpaQueryFactory.selectFrom(boardData)
                .leftJoin(boardData.member)
                .fetchJoin()
                .where(boardData.subject.contains("목"))
                .fetch(); // fetch로 데이터를 가져온다.

        items.forEach(System.out::println);
    }

}
