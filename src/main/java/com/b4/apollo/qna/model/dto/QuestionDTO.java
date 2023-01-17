package com.b4.apollo.qna.model.dto;

import lombok.*;
import org.springframework.lang.Nullable;
import java.time.LocalDateTime;

/**
 @FileName : QuestionDTO.java
 @Project : Apollo
 @Date : 2022. 12. 29.
 @작성자 : 이현도
 @프로그램 설명 : 질문게시판 정보를 담은 DTO
 */
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
