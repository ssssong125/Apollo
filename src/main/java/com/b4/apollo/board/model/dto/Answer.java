package com.b4.apollo.board.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Answer {

    private Integer replyNo;
    private String replyContent;

    private LocalDateTime postDate;

    private LocalDateTime modDate;

}
