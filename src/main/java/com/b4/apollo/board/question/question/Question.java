package com.b4.apollo.board.question.question;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Question {

    private Integer qnaNo;

    private String userId;

    private String qnaTitle;

    private String qnaContent;

    private LocalDateTime postDate;


}
