package com.b4.apollo.qna.model.dto;

import lombok.*;
import java.time.LocalDateTime;

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
