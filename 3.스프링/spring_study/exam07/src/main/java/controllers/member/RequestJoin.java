package controllers.member;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Data
public class RequestJoin {
    @NotBlank // userId는 필수다
    @Size(min=6)
    private String userId;

    @NotBlank
    @Size(min=8)
    private String userPw;

    @NotBlank
    private String confirmPw;

    @NotBlank
    private String userNm;

    @Email
    private String email;
    /*private List<String> hobby; // String[] hobby; Set<String> hobby;
    private Address addr; // 중첩된 커맨드 객체 addr.address*/

    @AssertTrue
    private boolean agree;

}
