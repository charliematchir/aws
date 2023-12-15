package com.example.p1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@EnableJpaAuditing
@SpringBootApplication
public class P1Application {
    public static void main(String[] args) {
        SpringApplication.run(P1Application.class, args);
    }
}
