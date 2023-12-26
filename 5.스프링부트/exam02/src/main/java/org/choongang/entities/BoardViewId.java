package org.choongang.entities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode // 기본키를 조합해 중복을 하지 않게 한다.
@AllArgsConstructor @NoArgsConstructor // 생성자 형태로 초기화, 기본생성자
public class BoardViewId {
    private Long seq;
    private int uid;


}
