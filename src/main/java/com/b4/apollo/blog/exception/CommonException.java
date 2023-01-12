package com.b4.apollo.blog.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommonException extends RuntimeException{

    public CommonException(String message) {
        super(message);
    }
}
