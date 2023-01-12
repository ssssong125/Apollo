package com.b4.apollo.blog.service;

import com.b4.apollo.blog.model.dto.CommentDTO;

import javax.xml.stream.events.Comment;
import java.util.List;

public interface CommentService {


    void insertComm(CommentDTO comm);

    List<CommentDTO> getList(CommentDTO comm);
}
