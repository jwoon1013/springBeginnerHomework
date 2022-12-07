package com.homework.springhomework.controller;

import com.homework.springhomework.dto.PostRequestDto;
import com.homework.springhomework.entity.Post;
import com.homework.springhomework.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/api/posts") // 전체 포스트 목록 조회
    public List<Post> getPosts() {
        return postService.getPosts();
    }

    @PostMapping("/api/posts") // 포스트 작성
    public Post createPost(@RequestBody PostRequestDto postRequestDto) {
        return postService.createPost(postRequestDto);
    }

    @PostMapping("/api/posts/{id}") // 특정 포스트 조회 (모르겟다 이거맞음?)
    public Post getPost(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto) {
        return postService.getPost(id, postRequestDto);
    }


}
