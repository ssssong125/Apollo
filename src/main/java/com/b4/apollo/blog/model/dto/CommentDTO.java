package com.b4.apollo.blog.model.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class CommentDTO {
    private int commNo;
    private String commContent;
    private LocalDateTime commDate;
    private int blogNo;
    private String commWriter;
    private String commStatus;

}
