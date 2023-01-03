package com.b4.apollo.qna.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class QuestionForm {

    @NotEmpty(message = "제목은 필수 항목입니다.")
    @Size(max = 200)
    private String boardTitle;

    @NotEmpty(message = "내용은 필수 항목입니다.")
    private String boardContent;
}
