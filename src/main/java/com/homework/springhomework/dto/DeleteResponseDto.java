package com.homework.springhomework.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DeleteResponseDto { // 삭제 성공 메세지 보내는 용
    private String msg;
}
