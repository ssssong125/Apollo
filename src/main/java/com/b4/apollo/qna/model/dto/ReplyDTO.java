package com.b4.apollo.qna.model.dto;

import lombok.*;
import java.time.LocalDateTime;

/**
 @FileName : ReplyDTO.java
 @Project : Apollo
 @Date : 2023. 01. 15.
 @작성자 : 이현도
 @프로그램 설명 : 질문 게시판 댓글 정보를 담은 DTO
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class ReplyDTO {

    private Integer replyNo;
    private Integer boardNo;
    private String replyWriter;
    private String replyContent;
    private LocalDateTime replyDate;
    private Integer replyCount;

}
