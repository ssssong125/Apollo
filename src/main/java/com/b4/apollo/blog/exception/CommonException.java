package com.b4.apollo.blog.exception;

import lombok.RequiredArgsConstructor;

/**
 @FileName : CommonException.java
 @Project : Apollo
 @Date : 2023. 01. 06.
 @작성자 : 이현도
 @프로그램 설명 : Exception 발생 시 메세지를 출력해주는 프로그램
 */
@RequiredArgsConstructor
public class CommonException extends RuntimeException{

    public CommonException(String message) {
        super(message);
    }
}
