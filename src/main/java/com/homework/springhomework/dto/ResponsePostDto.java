package com.homework.springhomework.dto;

import com.homework.springhomework.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponsePostDto { // 리스폰스
    private LocalDateTime createdAt; //작성시간

    private LocalDateTime modifiedAt; //수정시간

    private Long id; //id


    private String title; //글제목


    private String author; //글작성자


    private String content; //글내용

    private String msg; //백단에서 보내는 메세지

    public ResponsePostDto(Post post, String msg){
        this.createdAt = post.getCreatedAt();
        this.modifiedAt = post.getModifiedAt();
        this.id = post.getId();
        this.title = post.getTitle();
        this.author = post.getAuthor();
        this.content =post.getContent();
        this.msg = msg;
    }

    public ResponsePostDto(Post post){
        this.createdAt = post.getCreatedAt();
        this.modifiedAt = post.getModifiedAt();
        this.id = post.getId();
        this.title = post.getTitle();
        this.author = post.getAuthor();
        this.content =post.getContent();
        this.msg = "msg를 넣는것은 정말정말 잘못된 선택이었다...";
    }
}
