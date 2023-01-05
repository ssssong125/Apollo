package com.b4.apollo.blog.model.dto;//package com.b4.apollo.blog.post.model.dto;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BlogDTO {

    private Integer blogNo;
    private String userId;

    private String blogTitle;

    private String blogContent;

    private Timestamp postDate;

    private int count;

    private String blogDel;
}
