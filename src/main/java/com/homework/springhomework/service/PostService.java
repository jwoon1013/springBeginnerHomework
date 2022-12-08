package com.homework.springhomework.service;

import com.homework.springhomework.dto.DeleteResponseDto;
import com.homework.springhomework.dto.RequestDto;
import com.homework.springhomework.dto.ResponsePostDto;
import com.homework.springhomework.dto.ResponseTotalPostDto;
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


    @Transactional(readOnly = true) // 전체 포스트 보여주기
    public ResponseTotalPostDto getPostList() { // 얘가 안오는 문제가 있는 부분이구요..
//        List<Post> list = postRepository.findAllByOrderByModifiedAtDesc();
//        List<ResponsePostDto> postsResponseDtoList = new ArrayList<>();
//        for (Post post : list) {
//            ResponsePostDto responsePostDto = new ResponsePostDto(post);
//            postsResponseDtoList.add(responsePostDto);
//        }
        ResponseTotalPostDto responseTotalPostDto = new ResponseTotalPostDto(postsResponseDtoList, "진심 스스로불러온 재앙이구요. 스스로 작성한 API 명세서에 고통받는다");

        return responseTotalPostDto;
    }

    @Transactional(readOnly = true) //특정 단일 포스트 보여주기
    public ResponsePostDto getPost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("id값이 일치하는 포스트 없음!"));
        ResponsePostDto responsePostDto = new ResponsePostDto(post, "msg를 굳이 넣지 않아도 되는 이유 너무나 절실하게 깨우침...");

        return responsePostDto;
    }

    @Transactional // 포스트 수정 ( 1. 그런 id의 포스트 있냐? 2. 비밀번호 맞냐? 3. 비밀번호 맞으면 수정)
    public ResponsePostDto updatePost(Long id, RequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new RuntimeException("해당 id의 포스트가 존재하지 않습니다.")
        );
        if (post.checkPw(requestDto.getPassword())) {
            post.update(requestDto.getTitle(), requestDto.getAuthor(), requestDto.getContent());
        } else throw new RuntimeException("비밀번호가 틀렸습니다.");
        ResponsePostDto responsePostDto = new ResponsePostDto(post);
        return responsePostDto;

    }

    @Transactional
    public DeleteResponseDto deletePost(Long id) {
        postRepository.deleteById(id);
        DeleteResponseDto deleteResponseDto = new DeleteResponseDto("삭제완료");
        return deleteResponseDto;
    }


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