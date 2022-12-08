package com.homework.springhomework.service;

import com.homework.springhomework.dto.RequestDto;
import com.homework.springhomework.dto.ResponsePostDto;
import com.homework.springhomework.dto.ResponsePostListDto;
import com.homework.springhomework.entity.Post;
import com.homework.springhomework.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    @Transactional // 포스트 만들기
    public ResponsePostDto createPost(RequestDto requestDto) {
        Post post = requestDto.toEntity();
        postRepository.save(post);
        return new ResponsePostDto(post, "게시글 생성 완료");
    }


    public ResponsePostListDto getPostList() {
        List<Post> list =  postRepository.findAllByOrderByModifiedAtDesc();
        List<ResponsePostDto> postsResponseDtoList = new ArrayList<>();
        for (int i=0; i <list.size(); i++){
            ResponsePostDto responsePostDto = new ResponsePostDto(list.get(i));
            postsResponseDtoList.add(responsePostDto);
        }
        ResponsePostListDto responsePostListDto = new ResponsePostListDto(postsResponseDtoList, "진심 스스로불러온 재앙이구요 미친부분입니다.");

        return responsePostListDto;
    }
} // 클래스 PostService 끝


//    @Transactional(readOnly = true) //전체 포스트 조회
//    public List<Post> getPosts() {return postRepository.findAllByOrderByModifiedAtDesc();}
//
//    @Transactional // 포스트 생성
//    public Post createPost(PostRequestDto postRequestDto){
//        Post post = new Post(postRequestDto);
//        postRepository.save(post);
//        return post;
//        // 궁금증 : 얘는 왜 굳이 Post를 리턴 해야할까? 리퍼지토리에 save하는데..?
//        // 리퍼지토리가 뭐하는 놈인지 몰라서 어렵다 이부분...
//    }
//
//    @Transactional(readOnly = true) // 특정 포스트 조회
//    public Post getPost(Long id, PostRequestDto postRequestDto) {
//        Post post = postRepository.findById(id).orElseThrow(
//                () -> new IllegalArgumentException(("해당 id의 포스트가 존재하지 않습니다."))
//        );
//        return post;
//    }
//
//    @Transactional // 포스트 수정
//    public Long update(Long id, PostRequestDto postRequestDto) {
//        Post post = postRepository.findById(id).orElseThrow(
//                () -> new RuntimeException(("해당 id의 포스트가 존재하지 않습니다"))
//        );
//        String pw = postRequestDto.getPassword(); // 입력한 비번
//        String correctPw = post.getPassword(); // 업데이트할 포스트가 갖고있는 비번
//
//        if(pw.equals(correctPw)){
//            // 수정 작업 로직이 여기서 돌아가.
//            return post.getId(); // 리턴을 왜 시키지...?? x 415번 :이유 = 작동에 필요한거 아님. 걍 API에 이걸 뱉으라고 되있어서.(보통 실무에선 프론트에서 필요해서.나는 여기선 API에 맞춰서 필요한거 뱉거나 필요없으면 VOID 해도 됨)
//        } else {
//            throw new RuntimeException("비밀번호가 맞지 않습니다.");
//
//        }
//
//
//
//
//    }