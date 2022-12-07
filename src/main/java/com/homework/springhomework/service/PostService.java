package com.homework.springhomework.service;

import com.homework.springhomework.dto.PostRequestDto;
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

    @Transactional(readOnly = true) //전체 포스트 조회
    public List<Post> getPosts() {return postRepository.findAllByOrderByModifiedAtDesc();}

    @Transactional
    public Post createPost(PostRequestDto postRequestDto){
        Post post = new Post(postRequestDto);
        postRepository.save(post);
        return post;
        // 궁금증 : 얘는 왜 굳이 Post를 리턴 해야할까? 리퍼지토리에 save하는데..?
        // 리퍼지토리가 뭐하는 놈인지 몰라서 어렵다 이부분...
    }
}
