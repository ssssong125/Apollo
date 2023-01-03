package com.b4.apollo.qna.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class AnswerForm {
    @NotEmpty(message = "내용은 필수항목입니다.")
    private String replyContent;
}
