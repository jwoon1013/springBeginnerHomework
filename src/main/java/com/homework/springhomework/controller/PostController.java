package com.homework.springhomework.controller;

import com.homework.springhomework.entity.Post;
import com.homework.springhomework.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/api/posts")
    public List<Post> getPosts() {return postService.getPosts();}

}