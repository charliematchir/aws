//package com.example.p1.service;
//
//import com.example.p1.domain.Member;
//import com.example.p1.repository.MemberRepository;
//import com.example.p1.repository.MemoryMemberRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//
////@Service
//@Transactional
//public class MemberService {
//    private final MemberRepository memberRepository;
//
//    // DI!!
//    @Autowired
//    public MemberService(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//
//    public Long join(Member member) {
//        validateDuplicateMember(member); //중복 회원 검증
//        memberRepository.save(member);
//        return member.getId();
//    }
//
//    private void validateDuplicateMember(Member member) {
//        memberRepository.findByName(member.getName())
//                .ifPresent(m -> {
//                    throw new IllegalStateException("이미 존재하는 회원입니다.");
//                });
//    }
//
//    public List<Member> findMembers() {
//        return memberRepository.findAll();
//    }
//    public Optional<Member> findOne(Long memberId) {
//        return memberRepository.findById(memberId);
//    }
//
//}
