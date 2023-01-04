package com.b4.apollo.qna.model.dto;

import lombok.*;

import java.time.LocalDateTime;


 @Getter
 @Setter
 @AllArgsConstructor
@NoArgsConstructor
@ToString
public class Question {

    private Integer boardNo;

    private String userId;

    private String boardTitle;

    private String boardContent;

    private LocalDateTime createDate;

    private String status;

    // @Nullable
    private int count;

}
