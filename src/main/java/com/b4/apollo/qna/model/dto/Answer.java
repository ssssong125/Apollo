package com.b4.apollo.qna.model.dto;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Answer {

    private Integer replyNo;
    private String replyContent;

    private LocalDateTime postDate;

    private LocalDateTime modDate;

}