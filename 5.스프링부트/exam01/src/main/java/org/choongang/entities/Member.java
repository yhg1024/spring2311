package org.choongang.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor // 빌더 쓰려고 편법으로 추가
public class Member {
    @Id // Primary Key(기본키) 임을 알려준다.
    // USER_NO -> userNo
    private Long userNo;
    private String userId;
    @JsonIgnore // 배재하는 에노테이션
    private String userPw;
    private String userNm;
    private String email;

    @JsonFormat(pattern = "yyyy.MM.dd HH:mm")
    private LocalDateTime regDt;

    @JsonFormat(pattern = "yyyy.MM.dd HH:mm")
    private LocalDateTime modDt;
}
