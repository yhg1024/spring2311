package member.controllers;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Member {
    private String userId;
    private String userPw;
    private String confirmPw;
    private String userNm;
}
