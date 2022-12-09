package com.homework.springhomework.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTotalPostDto {

    private List<ResponsePostNoMsgDto> postNoMsgDtoList;
    private String msg;
}
