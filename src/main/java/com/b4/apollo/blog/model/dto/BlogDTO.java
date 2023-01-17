package com.b4.apollo.blog.model.dto;

import lombok.*;
import java.time.LocalDateTime;

/**
 @FileName : BlogDTO.java
 @Project : Apollo
 @Date : 2023. 01. 06.
 @작성자 : 이현도
 @프로그램 설명 : 블로그 정보를 담은 DTO
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class BlogDTO  {

    private Integer  blogNo;
    private String reporter;
    private String blogTitle;
    private String blogContent;
    private LocalDateTime createDate;
    private int count;
    private String status;
    private String fileName;
    private String filePath;
}
