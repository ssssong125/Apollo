package com.b4.apollo.blog.post.model.dto;//package com.b4.apollo.blog.post.model.dto;

import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PostDTO {

    private Integer blogNo;
    private String userId;

    private String blogTitle;

    private String blogContent;

    private Timestamp postDate;

    private Integer viewCount;


}
