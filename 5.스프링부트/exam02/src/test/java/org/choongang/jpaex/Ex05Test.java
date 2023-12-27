package org.choongang.jpaex;

import com.querydsl.core.BooleanBuilder;
import org.choongang.entities.BoardData;
import org.choongang.entities.QBoardData;
import org.choongang.repositories.BoardDataRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.domain.Sort.Order.desc;

@SpringBootTest
@TestPropertySource(properties = "spring.profiles.active=test")
public class Ex05Test {

    @Autowired
    private BoardDataRepository repository;

    @BeforeEach
    void init() {
        List<BoardData> items = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            BoardData item = new BoardData();
            item.setSubject("제목" + i);
            item.setContent("내용" + i);
            items.add(item);
        }

        repository.saveAllAndFlush(items);
    }

    @Test
    void test1() {
        List<BoardData> items = repository.getSubjects("목");
    }

    @Test
    void test2() {
        QBoardData boardData = QBoardData.boardData;

        List<BoardData> items = (List<BoardData>) repository.findAll(boardData.subject.contains("목"));

        items.forEach(System.out::println);
    }

    @Test
    void test3() {
        QBoardData boardData = QBoardData.boardData;
        List<BoardData> items = (List<BoardData>) repository.findAll(boardData.subject.contains("목")
                , Sort.by(desc("createdAt")));

        items.forEach(System.out::println);
    }

    @Test
    void test4() {
        QBoardData boardData = QBoardData.boardData;

        Pageable pageable = PageRequest.of(1, 3, Sort.by(desc("createdAt")));

        Page<BoardData> data = repository.findAll(boardData.subject.contains("목"),pageable);
    }

    @Test
    void test5() {
        QBoardData boardData = QBoardData.boardData;
        BooleanBuilder andBuilder = new BooleanBuilder();
        BooleanBuilder orBuilder = new BooleanBuilder();

        andBuilder.and(boardData.seq.in(1L, 3L, 5L)); // and 조건

        orBuilder.or(boardData.subject.contains("목"))
                .or(boardData.subject.contains("용")); // or 조건

        andBuilder.and(orBuilder); // or조건을 and조건 안에 넣어야해서

        // (subject LIKE '%목%' OR content LIKE '%용%') AND seq IN (1, 3, 5);
        List<BoardData> items = (List<BoardData>) repository.findAll(andBuilder);
        items.forEach(System.out::println);
    }
}
