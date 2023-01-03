package com.b4.apollo.qna.model.dto;

import com.b4.apollo.qna.service.AnswerService;
import lombok.*;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
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
