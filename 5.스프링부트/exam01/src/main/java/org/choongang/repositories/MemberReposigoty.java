package org.choongang.repositories;

import org.choongang.entities.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberReposigoty extends CrudRepository<Member, Long> {
    Member findByUserId(String userId);

    List<Member> findByUserNmContainingOrUserIdContainingOrderByRegDtDesc(String keyword1, String keyword2);
    // 쿼리 메서드를 이용한 게시글 조회

    Page<Member> findByUserNmContaining(String key, Pageable pageable);

    @Query("SELECT * FROM MEMBER WHERE USER_NM LIKE '%key%' OR USER_ID LIKE '%key%' ORDER BY REG_DT DESC")
    List<Member> getMembers(@Param("key1") String keyword1, @Param("key2") String keyword2);
}
