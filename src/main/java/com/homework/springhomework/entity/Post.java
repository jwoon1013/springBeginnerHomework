package com.homework.springhomework.entity;

import com.homework.springhomework.dto.PostRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Post extends TimeStamped{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String password;

    public Post(PostRequestDto postRequestDto){
        this.title = postRequestDto.getTitle();
        this.author = postRequestDto.getAuthor();
        this.content = postRequestDto.getContent();
        this.password = postRequestDto.getPassword();
    }

    public void update(PostRequestDto postRequestDto){
        this.title = postRequestDto.getTitle();
        this.author = postRequestDto.getAuthor();
        this.content = postRequestDto.getContent();
        this.password = postRequestDto.getPassword();
    }


}
