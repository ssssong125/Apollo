package com.b4.apollo.blog.model.dto;//package com.b4.apollo.blog.post.model.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AttachDTO {

    private int imgNo;
    private String originalName;

    private String storedName;

    private Integer blogNo;

    private String userId;

    private String uploadPath;

    private String fileLocation;

    private String imgDel;




}
