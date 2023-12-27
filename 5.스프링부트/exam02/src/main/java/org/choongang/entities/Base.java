package org.choongang.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter @Setter
@MappedSuperclass // 공통 속성화를 위한 상위 클래스
@EntityListeners(AuditingEntityListener.class)
public abstract class Base { // 공통 속성 클래스
    @CreatedDate
    @Column(updatable = false) // 추가o, 수정 x
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(insertable = false) // 추가x, 수정 o
    private LocalDateTime modifiedAt;


}
