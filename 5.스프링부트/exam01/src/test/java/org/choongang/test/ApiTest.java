package org.choongang.test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.choongang.entities.Member;
import org.choongang.restcontrollers.RequestJoin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ApiTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("회원 가입 성공시 응답 코드 201")
    void joinTest() throws Exception{
        // MediaType.APPLICATION_JSON == application/json

        RequestJoin form = new RequestJoin();
        form.setUserId("user01");
        form.setUserPw("123456789");
        form.setConfirmPw("123456789");
        form.setUserNm("사용자01");
        form.setEmail("user01@test.org");
        form.setRegDt(LocalDateTime.now()); // 자바 타임패키지는 변환이 안된다.

        ObjectMapper om = new ObjectMapper(); // 위의 자바 객체를 JSON 객체로 바꿔준다.
        om.registerModule(new JavaTimeModule()); // 타임패키지를 쓰기 위해

        String body = om.writeValueAsString(form); // 자바 객체 -> JSON 문자열 변환
        System.out.println(body);

        mockMvc.perform(post("/api/member")
                        // .header("Content-Type", "application/json")
                        .header("Content-Type", MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(body)
                )
                .andDo(print())
                .andExpect(status().isCreated()); // 201
    }

    @Test
    @DisplayName("JSON 문자열 -> Member 객체로 변환")
    void infoTest() throws Exception {
        String body = mockMvc.perform(get("/api/member"))
                .andDo(print())
                .andReturn().getResponse().getContentAsString(Charset.forName("UTF-8"));
        ObjectMapper om = new ObjectMapper();
        om.registerModule(new JavaTimeModule());

        Member member = om.readValue(body, Member.class);
        System.out.println(member);
    }

    @Test
    @DisplayName("list")
    void listTest() throws Exception{
        String body = mockMvc.perform(get("/api/member/list"))
                .andDo(print())
                .andReturn()
                .getResponse()
                .getContentAsString(Charset.forName("UTF-8")); // 내부 정보

        ObjectMapper om = new ObjectMapper();
        om.registerModule(new JavaTimeModule());

        List<Member> members = om.readValue(body, new TypeReference<List<Member>>() {});
        members.forEach(System.out::println);
    }
}
