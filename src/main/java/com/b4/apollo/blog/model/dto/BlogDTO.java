package com.b4.apollo.blog.model.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

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
