package com.b4.apollo.blog.post.model.dto;//package com.b4.apollo.blog.post.model.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FileDTO {

    private int imgNo;
    private String originalName;

    private String storedName;

    private Integer blogNo;

    private String userId;

    private String uploadPath;

    private String fileLocation;





}
