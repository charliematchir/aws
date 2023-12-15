//package com.example.p1.repository;
//
//import com.example.p1.domain.Member;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.Optional;
//
//// JpaRepository 는 라이브러리 제공 레포지토리로,
//// JpaMemberReposiory 처럼 파일에 만들지 않아도 됨
//public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
//    @Override
//    Optional<Member> findByName(String name);
//}
