package com.b4.apollo.qna.exception;

import lombok.RequiredArgsConstructor;

/**
 @FileName : CommonException.java
 @Project : Apollo
 @Date : 2022. 12. 29.
 @작성자 : 이현도
 @프로그램 설명 : Exception 발생 시 메세지를 출력해주는 프로그램
 */
@RequiredArgsConstructor
public class CommonException extends RuntimeException{

    public CommonException(String message) {
        super(message);
    }
}
