package com.b4.apollo.qna.model.dto;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 @FileName : QuestionForm.java
 @Project : Apollo
 @Date : 2022. 12. 29.
 @작성자 : 이현도
 @프로그램 설명 : 질문 게시글 작성 시 Validation을 검증 하기 위한 프로그램
 */
@Getter
@Setter
public class QuestionForm {

    private String userId;

    @NotEmpty(message = "제목은 필수 항목입니다.")
    @Size(max = 200)
    private String boardTitle;

    @NotEmpty(message = "내용은 필수 항목입니다.")
    private String boardContent;
}
