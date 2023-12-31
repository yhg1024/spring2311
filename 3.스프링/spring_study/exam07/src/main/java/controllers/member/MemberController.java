package controllers.member;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import models.member.JoinService;
import models.member.LoginService;
import models.member.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor// final 주입
public class MemberController {

    private final JoinValidator joinValidator;
    private final JoinService joinService; // 의존성 추가
    private final LoginValidator loginValidator;
    private final LoginService loginService;

    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        return  Arrays.asList("자바", "오라클", "JSP", "스프링");
    }

    @GetMapping("/join") // /member/join
    /*@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST},
            path = "/member/join") // get과 post한꺼번에 설정*/
    public String join(@ModelAttribute RequestJoin form, Model model) { // @ModelAttribute 비어있는 객체 형태로 알아서 해준다.

        /*String[] addCss = {"member/style1", "member/style2"};
        List<String> addScript = Arrays.asList("member/script1", "member/script2");

        model.addAttribute("addCss", addCss);
        model.addAttribute("addScript", addScript);*/
        /*model.addAttribute("requestJoin", new RequestJoin());
        // get방식일때는 ??? 동일한 명칭으로 하나 더 생성하면된다. 아에 없으면 널이라 오류가 난다.
        그래서 @ModelAttribute를 쓰면 동일한 기능을 한다.
        */
        model.addAttribute("pageTitle", "회원가입");

        return "member/join";
    }

    @PostMapping("/join") // /member/join
    public String joinPs(@Valid  RequestJoin form, Errors errors, Model model) {
        // @Valid 빈 검증기(Bean Validator)를 이용해 객체의 제약 조건을 검증하도록 지시하는 어노테이션
        // 에러객체가 커맨드 객체 뒤로 와야한다.

        joinValidator.validate(form, errors); // 검증을 처리하고 검증에 대한 에러 메세지

        if (errors.hasErrors()) { // 검증 실패시
            return "member/join";
        }

        // 회원 가입 처리
        joinService.join(form);

        // System.out.println(form);
        // 커맨드객체 RequestJoin -> requestJoin 이름으로 속성이 추가 -> 템플릿 내에서 바로 접근 가능

        /*model.addAttribute("requestJoin", form);
        // requestJoin으로 member/join에 속성 추가 직접 접근가능*/

        // response.sendRedirect(request.getContextPath() + "/member/login") // return "redirect:/member/login"; 과 동일한 형태
        // Location : 주소, 리턴의 값이 들어간다.
        // return "redirect:/member/login";
        return "redirect:/member/login";
        // return "member/join";
    }

    @GetMapping("/login") // /member/login
    public String login(@ModelAttribute RequestLogin form){
        return "member/login";
    }

    @PostMapping("/login") // /member/login
    public String loginPs(@Valid RequestLogin form, Errors errors) {

        loginValidator.validate(form, errors);

        if (errors.hasErrors()) {
            return "member/login";
        }

        // 로그인 처리
        loginService.login(form);

        return "redirect:/"; // 로그인 성공시 메인페이지 / 이동
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // 세션 비우기

        return "redirect:/member/login"; // 로그인 페이지 이동
    }

    @GetMapping("/list") // /member/list
    public String members(Model model) {
        List<Member> members = new ArrayList<>();
        for (int i = 1; i <= 10; i++){
            Member member = Member.builder()
                    .userNo(Long.valueOf(i))
                    .userPw("1234")
                    .userId("user" + i)
                    .userNm("사용자" + i)
                    .email("user" + i + "@test.org")
                    .regDt(LocalDateTime.now())
                    .build();
            members.add(member);
        }
        model.addAttribute("members", members);

        return "member/list";
    }

    // controller에 해당하는 공통적 validator
    /*@InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(joinValidator);
    }*/
}
