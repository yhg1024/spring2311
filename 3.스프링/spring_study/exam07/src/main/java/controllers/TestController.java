package controllers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    // 쿠키연습
    @GetMapping("/cookie/test1")
    public String test1(HttpServletResponse response, HttpServletRequest request) {
        Cookie cookie = new Cookie("key1", "value1");
        response.addCookie(cookie); // 응답헤더에 실려보냄
        // ResponseHeaders에 Set-Cookie로 값이 들어간다.

        Cookie cookie2 = new Cookie("key2", "value2");
        cookie2.setPath(request.getContextPath()); // 쿠키설정, exam07
        cookie2.setMaxAge(60 * 60 * 24 * 7); // 유지시간, 초단위
        // cookie2.setMaxAge(0); // 1970.1.1 자정 - 쿠키 삭제
        cookie2.setHttpOnly(true); // false - 자바스크립트로 브라우저에서 조회 가능
                                // true - 자바스크립트 조회x, 서버쪽에서만 요청을 통한 조회 가능

        response.addCookie(cookie2);

        return "test";
    }

    @GetMapping("/cookie1/test2")
    public String test2(@CookieValue(name="key2", defaultValue = "기본값") String key2) { // 쿠키 개별 조회, 특정 변수에 주입
        System.out.printf("key2=%s%n", key2);
        return "test";
    }

    @GetMapping("/session/test1")
    public String test3 (HttpSession session) {
        session.setAttribute("key1", "value1");
        return "test";
    }

    @GetMapping("/session/test2")
    // public String test4(HttpSession session) {
    public String test4(HttpServletRequest request) {
        HttpSession session = request.getSession();

        String value = (String) session.getAttribute("key1");
        System.out.println("key1=%s%n, value");
        return "test";
    }
}
