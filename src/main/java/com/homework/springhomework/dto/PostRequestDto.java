// DTO : 데이터 전송객체. 뷰에서 컨트롤러로 넘어오는 데이터나, 컨트롤러에서 서비스로 넘기는 데이터를 담는 용도.
// 로직을 가지지 않고, 데이터 객체에 대한 정보만 담는다.
package com.homework.springhomework.dto;

import lombok.Getter;
@Getter
public class PostRequestDto {
    private String title;

    private String author;

    private String content;

    private String password;
}
