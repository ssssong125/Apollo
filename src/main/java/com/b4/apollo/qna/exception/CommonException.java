package com.b4.apollo.qna.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommonException extends RuntimeException{

    public CommonException(String message) {
        super(message);
    }
}
