//package com.example.p1;
//
//
//
//import com.example.p1.repository.MemberRepository;
//import com.example.p1.service.MemberService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class SpringConfig {
//    private final MemberRepository memberRepository;
//
//    @Autowired
//    public SpringConfig(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//
//    @Bean
//    public MemberService memberService() {
//        return new MemberService(memberRepository);
//    }
//
//}
