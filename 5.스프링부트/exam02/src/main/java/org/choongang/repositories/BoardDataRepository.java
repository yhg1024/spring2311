package org.choongang.repositories;

import org.choongang.entities.BoardData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardDataRepository extends JpaRepository<BoardData, Long>,
        QuerydslPredicateExecutor<BoardData> {
    @EntityGraph(attributePaths = {"member"})
    List<BoardData> findBySubjectContaining(String keyword);
    /*
    * where
        bd1_0.subject like ? escape '\'
    * */

    // 중요
    Page<BoardData> findBySubjectContaining(String keyword, Pageable pageable);
    //반환값 페이지로 고정

    List<BoardData> findBySubjectContainingOrderBySeqDesc(String keyword);
    /*
    * where
        bd1_0.subject like ? escape '\'
    order by
        bd1_0.seq desc
    * */

    // 위 코드와 동일
    @Query("SELECT b FROM BoardData b LEFT JOIN FETCH b.member WHERE b.subject LIKE %:key% ORDER BY b.seq DESC")
    List<BoardData> getSubjects(@Param("key") String keyword); // 위의 키로 들어감

    @Query("SELECT b FROM BoardData b WHERE b.subject LIKE %:key%")
    Page<BoardData> getSubjects(@Param("key") String keyword, Pageable pageable);
}
