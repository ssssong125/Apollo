package com.b4.apollo.qna.model.dto;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageSerializable;
import lombok.*;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class QuestionDTO {


    private Integer boardNo;

    private String userId;

    private String boardTitle;

    private String boardContent;

    private LocalDateTime createDate;

    private String status;

    @Nullable
    private int count;
}
