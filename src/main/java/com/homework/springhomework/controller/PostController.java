package com.homework.springhomework.controller;
import com.homework.springhomework.dto.ResponsePostListDto;
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

    @GetMapping("/posts") // 전체 리스트 보여주기
    public ResponsePostListDto getPostList() {
        return postService.getPostList();
    }

}


