package com.example.p1.domain.posts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

// 이 어노테이션 쓰면 자동으로 h2데이터베이스 실행해줌
@SpringBootTest
public class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글_불러오기() {
        String title = "테스트 게시글";
        String content = "테스트 본문";
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("jiuac@naver.com").
                build());

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_등록() {

        LocalDateTime now = LocalDateTime.of(2023, 11, 19, 12, 54, 00);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("jiuac@naver.com").
                build());

        List<Posts> postsList = postsRepository.findAll();
        Posts posts = postsList.get(0);
        System.out.println(">>>>>>> createDate=" + posts.
                getCreatedDate()+ ", modifiedDate=" + posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}

