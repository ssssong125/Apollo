package com.b4.apollo.qna.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 @FileName : DataNotFoundException.java
 @Project : Apollo
 @Date : 2022. 12. 29.
 @작성자 : 이현도
 @프로그램 설명 : Exception 발생 시 메세지를 출력해주는 프로그램
 */
   @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "entity not found")
    public class DataNotFoundException extends RuntimeException {
        private static final long serialVersionUID = 1L;
        public DataNotFoundException(String message){
            super(message);
        }
}
