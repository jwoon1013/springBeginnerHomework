package com.homework.springhomework.controller;
import com.homework.springhomework.dto.DeleteResponseDto;
import com.homework.springhomework.dto.ResponseTotalPostDto;
import com.homework.springhomework.dto.RequestDto;
import com.homework.springhomework.dto.ResponsePostDto;
import com.homework.springhomework.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/posts") // 생성
    public ResponsePostDto createPost(@RequestBody RequestDto requestDto){
        return postService.createPost(requestDto);
    }

    @GetMapping("/posts") // 전체 포스트 보여주기
    public ResponseTotalPostDto getPostList() {
        return postService.getPostList();
    }

    @GetMapping("/posts/{id}") // 특정 포스트 보여주기
    public ResponsePostDto getpost(@PathVariable Long id){
        return postService.getPost(id);
    }

    @PutMapping("/posts/{id}")
    public ResponsePostDto updatePost(@PathVariable Long id, @RequestBody RequestDto requestDto){

        return postService.updatePost(id, requestDto);
    }

    @DeleteMapping("/posts/{id}")
    public DeleteResponseDto deletePost(@PathVariable Long id){
        return postService.deletePost(id);
    }





}


