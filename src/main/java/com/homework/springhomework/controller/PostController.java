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
        // 궁금증 : 이게 post를 돌려주나? long을 돌려주나?
        // Long을 돌려주는 애들은 왜 Long을 돌려주지?
    }

    @PutMapping("api/posts/{id}")
    public Long updatePost(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto){
        return postService.update(id, postRequestDto);
    }
    // 궁금증 : 백만스물한번 궁금하지만 도대체 리턴으로 Long을 돌려주는 이유가 뭐지?
    // id가 Long이라서 Long 돌려주는건 알겠는데 id를 왜 돌려주는지 모르겠음...
    // 해결됐음!!!! 왜냐면, 그냥 api 명세서에 Response로 그거 뱉어내라고 되있어서 뱉는거임! 거기 안써있음 안뱉여도됨!
    // 아마 뱉어내야 하는 이유는 앞단에서 쓰려고 하는거같음...?
}


/// 저녁식사중 6:00 ~ 7 : 00


