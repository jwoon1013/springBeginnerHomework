package com.homework.springhomework.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class ResponsePostListDto {

    private List<ResponsePostDto> postDtoList;
    private String msg;
}
