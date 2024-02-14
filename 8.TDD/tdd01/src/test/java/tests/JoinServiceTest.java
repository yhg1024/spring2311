package tests;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Builder;
import member.controllers.JoinValidator;
import member.controllers.Member;
import member.service.BadRequestException;
import member.service.JoinService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@DisplayName("회원가입 기능 테스트")
@ExtendWith(MockitoExtension.class) // 모의 객체를 편하게 쓴다.
public class JoinServiceTest {

    private JoinService joinService;

    private HttpServletRequest request;

    @BeforeEach
    void init() {
        joinService = new JoinService(new JoinValidator());

        Member member = getMember();

        // request = mock(HttpServletRequest.class);
        given(request.getParameter("userId")).willReturn(member.getUserId());
        given(request.getParameter("userPw")).willReturn(member.getUserPw());
        given(request.getParameter("confirmPw")).willReturn(member.getConfirmPw());
        given(request.getParameter("userNm")).willReturn(member.getUserNm());
    }

    private Member getMember() {
        return Member.builder()
                .userId("user" + System.currentTimeMillis())
                .userPw("12345678")
                .confirmPw("12345678")
                .userNm("사용자")
                .build();
    }

    @Test
    @DisplayName("회원 가입 성공시 예외 발생 없음")
    void joinSuccess() {
        assertDoesNotThrow(() -> {
            joinService.join(getMember());
        });
    }

    @Test
    @DisplayName("회원가입 성공 테스트 - 요청 데이터")
    void joinSuccessWithRequest() {
        assertDoesNotThrow(() -> {
            joinService.join(request);
        });
    }

    @Test
    @DisplayName("필수 입력항목(userId, userPw, confirmPw, userNm) 검증, 실패시에는 BadRequestException 발생")
    void requiredField() {
        assertAll(
                () -> requiredFieldTestEach("userId", "아이디"),
                () -> requiredFieldTestEach("userPw", "비밀번호"),
                () -> requiredFieldTestEach("confirmPw", "비밀번호를 확인"),
                () -> requiredFieldTestEach("userNm", "회원명")
        );
    }

    private void requiredFieldTestEach(String field, String keyword) {
        Member memberNull = getMember();
        Member memberBlank = getMember();
        if (field.equals("userId")) {
            memberNull.setUserId(null);
            memberBlank.setUserId("     ");
        } else if (field.equals("userPw")) {
            memberNull.setUserPw(null);
            //memberNull.setUserId(null);
            memberBlank.setUserPw("     ");
            //memberBlank.setUserId("   ");
        } else if (field.equals("confirmPw")) {
            memberNull.setConfirmPw(null);
            memberBlank.setConfirmPw("     ");
        } else if (field.equals("userNm")) {
            memberNull.setUserNm(null);
            memberBlank.setUserNm("      ");
        }

        assertAll(
                () -> {
                    BadRequestException thrown =  assertThrows(BadRequestException.class, () -> joinService.join(memberNull));
                    String message = thrown.getMessage();
                    assertTrue(message.contains(keyword));
                },
                () -> {
                    BadRequestException thrown = assertThrows(BadRequestException.class, () -> joinService.join(memberBlank));
                    String message = thrown.getMessage();
                    assertTrue(message.contains(keyword));
                }
        );
    }
}