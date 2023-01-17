package com.b4.apollo.blog.service;

import com.b4.apollo.blog.model.dto.CommentDTO;

import java.util.List;

public interface CommentService {

    List<CommentDTO> selectCommList(int bno);

    int insertComm(CommentDTO blogNo);

    int commModify(CommentDTO commNo);


    CommentDTO selectComm(Integer commNo);

    int deleteComm(CommentDTO comm);



}
