package com.homework.springhomework.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Post extends TimeStamped {

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


    public Post(String title, String author, String content, String password) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.password = password;
    }

    public void update(String title, String author, String content) {
        this.title = title;
        this.author = author;
        this.content = content;
    }

    // 아 이래서 비번 체크는 post에다가 달아야한다고 하는구나...
    // 왜냐면, 이걸떼면 post값을 인자로 넘겨주는 미친짓을 해야한다....
    public Boolean checkPw(String pw){
        Boolean isSame;
        if (this.getPassword().equals(pw) ){
            isSame = true;
        } else isSame = false;
        return isSame;
    }


}
