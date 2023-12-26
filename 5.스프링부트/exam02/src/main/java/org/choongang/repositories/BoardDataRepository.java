package org.choongang.repositories;

import org.choongang.entities.BoardData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardDataRepository extends JpaRepository<BoardData, Long> {
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
}
