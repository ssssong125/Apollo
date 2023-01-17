package com.b4.apollo.blog.model.dto;

import lombok.*;
import java.time.LocalDateTime;

/**
 @FileName : CommentDTO.java
 @Project : Apollo
 @Date : 2023. 01. 15.
 @작성자 : 이현도
 @프로그램 설명 : 블로그 댓글 정보를 담은 DTO
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class CommentDTO {
    private Integer commNo;
    private String commContent;

    private LocalDateTime commDate;
    private Integer blogNo;
    private String commWriter;
    private String commStatus;

}
