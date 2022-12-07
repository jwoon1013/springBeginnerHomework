package com.homework.springhomework.service;

import com.homework.springhomework.entity.Post;
import com.homework.springhomework.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public List<Post> getPosts() {return postRepository.findAllByOrderByModifiedAtDesc();}
}
