package com.b4.apollo.qna.model.dto;

import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Question {

    private Integer qnaNo;

    private String userId;

    private String qnaTitle;

    private String qnaContent;

    private LocalDateTime postDate;


}
