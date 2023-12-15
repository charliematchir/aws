package com.example.p1.controller;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

// ExtendWith(SpringExtention)는 junit5에서 사용하는 4에서 쓰던 Runwith와 동일함
// SpringBootTest는 application context를 전부 로딩해서 무거울 수 있음
// Extendwith를 쓰면 @autowired @Mockbean 에 해당하는 것들에만 application context 로딩해옴

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HomeControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void 메인페이지() {
        String body = this.restTemplate.getForObject("/", String.class);
        assertThat(body).contains("Hello Spring");
    }

}
