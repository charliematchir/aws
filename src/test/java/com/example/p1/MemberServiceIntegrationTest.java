//package com.example.p1;
//
//import com.example.p1.domain.Member;
//import com.example.p1.repository.MemberRepository;
//import com.example.p1.service.MemberService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//
//
//// @SpringBootTest는 스프링 컨테이너와 테스트 함께 실행
//// @Transactional은 Test에서 트랜잭션 하나마다 시작하고 롤백함
//
//@SpringBootTest
//@Transactional
//public class MemberServiceIntegrationTest {
//
//    @Autowired
//    MemberService memberService;
//    @Autowired
//    MemberRepository memberRepository;
//
//    @Test
//    public void 회원가입() {
//        Member member  = new Member();
//        Long savedId = memberService.join(member);
//
//        Member findMember = memberService.findOne(savedId).get();
//        assertThat(member.getName()).isEqualTo(findMember.getName());
//
//    }
//
//    @Test
//    public void 중복회원() {
//        Member member1  = new Member();
//        Member member2  = new Member();
//
//        member1.setName("spr");
//        member2.setName("spr");
//
//        memberService.join(member1);
//
//        assertThrows(IllegalStateException.class, () -> memberService.join(member2));
//    }
//
//}
