package com.example.p1.controller;

import com.example.p1.controller.dto.PostsResponseDto;
import com.example.p1.controller.dto.PostsSaveRequestDto;
import com.example.p1.controller.dto.PostsUpdateRequestDto;
import com.example.p1.service.posts.PostsService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    // post는save, put은 update
    // RequestBody 붇은 파라미터에는 Http 요청의 본문 body 부분이 그대로 전달됨
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        System.out.println(requestDto.getAuthor());
        System.out.println(requestDto.getTitle());
        return postsService.save(requestDto);}

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @DeleteMapping("api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

}
