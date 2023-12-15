package com.example.p1.domain.posts;


import com.example.p1.domain.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor // 기본 생성자 자동 추가
@Entity // 테이블과 링크될 클래스임을 나타냄
public class Posts extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 안써도 모든 필드 칼럼인데 추가 옵션 변경시 사용함
    @Column(length = 100, nullable = false)
    private String title;

//    @Column(columnDefinition = "TEXT", nullable = false)
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    // 생성자랑 하는건 같은데, 넣는 필드 명확히 지정가능함 (a,b) 받는걸 (b,a)로 하는걸 방지D
    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
