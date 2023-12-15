//package com.example.p1.controller;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static net.bytebuddy.matcher.ElementMatchers.is;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//
//@AutoConfigureMockMvc
//@SpringBootTest
//public class HelloControllerTest {
//    @Autowired
//    private MockMvc mvc;
//
//    @Test
//    public void hello_ret() throws Exception {
//        String hello = "hello";
//        mvc.perform(get("/hello"))
//                .andExpect(status().isOk())
//                .andExpect(content().string(hello));
//    }
//
//    @Test
//    public void hello_dto_ret() throws Exception {
//        String name = "hello";
//        int amount = 1000;
//
//        mvc.perform(get("/hello/dto"))
//                .param("name", name)
//                .param("amount", String.valueOf(amount))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name", is(name)))
//                .andExpect(jsonPath("$.amount", is(amount)));
//
//    }
//}
package com.example.p1.controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @WithMockUser(roles = "USER")
    public void hello_ret() throws Exception {
        String hello = "hello";
        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(hello));
    }

    @Test
    @WithMockUser(roles = "USER")
    public void hello_dto_ret() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                // jsonPath는 json 응답값을 필드별로 검증하는 method이고, $ 기준으로 필드명 명시
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
