package com.b4.apollo.blog.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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
