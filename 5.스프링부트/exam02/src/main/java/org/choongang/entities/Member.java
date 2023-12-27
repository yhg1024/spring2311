package org.choongang.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.choongang.commons.MemberType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name="USERS", indexes = @Index(name = "idx_member_createdAt", columnList = "createdAt DESC"))
// @EntityListeners(AuditingEntityListener.class)
public class Member extends Base{

    @Id
    @GeneratedValue // @GeneratedValue	키 값을 생성하는 전략 명시
    private Long seq;

    // nullable : null 값의 허용 여부 설정, false로 설정하면 DDL 생성시에 not null 제약조건 추가
    // length : String 타입의 문자 길이 제약조건 설정
    @Column(length = 80, unique = true, nullable = false)
    private String email;

    @Column(length = 40, nullable = false)
    private String name;

    @Column(length = 65, name = "userPw", nullable = false) // 필드와 매핑할 컬럼의 이름 설정
    private String password; // varchar2

    // @Lob // 여러줄 텍스트 입력
    @Transient // 엔티티 내부에서만 쓴다, DB에 반영x
    private String introduction; // CLOB : 사이즈가 큰 데이터를 외부 파일로 저장하기 위한 데이터 타입입니다. 문자형 대용량 파일을 저장하는데 사용하는 데이터 타입이라고 생각하면 됩니다.

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private MemberType type; // ADMIN, MEMBER

    // @CreationTimestamp // INSERT SQL 실행시
    // @CreatedDate
    // private LocalDateTime createAt;

    // @UpdateTimestamp // UPDATE SQL 실행시
    // @LastModifiedDate
    // private LocalDateTime modifiedAt;

    // @Temporal(TemporalType.DATE) // 날짜
    // @Temporal(TemporalType.TIME) // 시간
    // @Temporal(TemporalType.TIMESTAMP) // 날짜 + 시간
    // public Date dt;

}
