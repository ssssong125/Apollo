package com.b4.apollo.blog.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


/**
 @FileName : BlogForm.java
 @Project : Apollo
 @Date : 2023. 01. 06.
 @작성자 : 이현도
 @프로그램 설명 : 블로그 게시글 작성 시 Validation을 검증 하기 위한 프로그램
 */
@Getter
@Setter
public class BlogForm {

    private String userId;

    @NotEmpty(message = "제목은 필수 항목입니다.")
    @Size(max = 200)
    private String blogTitle;

    @NotEmpty(message = "내용은 필수 항목입니다.")
    private String blogContent;
}
