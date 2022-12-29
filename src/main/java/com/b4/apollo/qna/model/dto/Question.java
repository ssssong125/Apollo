package com.b4.apollo.qna.model.dto;

import lombok.*;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Question {

    private Integer boardNo;

    private String userId;

    private String boardTitle;

    private String boardContent;

    private LocalDateTime createDate;

    private String status;

    @Nullable
    private int count;


}
