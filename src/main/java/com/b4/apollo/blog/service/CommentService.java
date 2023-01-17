package com.b4.apollo.blog.service;

import com.b4.apollo.blog.model.dto.CommentDTO;
import java.util.List;

/**
 @FileName : CommentService.java
 @Project : Apollo
 @Date : 2023. 01. 15.
 @작성자 : 이현도
 @프로그램 설명 : 블로그 댓글 관련 요청을 처리할 Service interface
 */

public interface CommentService {

    List<CommentDTO> selectCommList(int bno);

    int insertComm(CommentDTO blogNo);

    int commModify(CommentDTO commNo);


    CommentDTO selectComm(Integer commNo);

    int deleteComm(CommentDTO comm);



}
