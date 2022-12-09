package com.homework.springhomework.dto;

import com.homework.springhomework.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// 이 DTO의 용도 : 전체결과 리스트를 보낼때 모든 POSTDTO에 메세지 값이 붙어있어 100개의 POSTDTO에 100개의 메세지와 그 것이 담긴 리스트에 붙은 또다른 메세지로 101개 메세지를 보내는 짓을 안하고 싶어서
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponsePostNoMsgDto { // 리스폰스
    private LocalDateTime createdAt; //작성시간

    private LocalDateTime modifiedAt; //수정시간

    private Long id; //id


    private String title; //글제목


    private String author; //글작성자


    private String content; //글내용


    public ResponsePostNoMsgDto(Post post){
        this.createdAt = post.getCreatedAt();
        this.modifiedAt = post.getModifiedAt();
        this.id = post.getId();
        this.title = post.getTitle();
        this.author = post.getAuthor();
        this.content =post.getContent();
    }

}
