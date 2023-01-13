package com.b4.apollo.blog.service;

import com.b4.apollo.blog.model.dto.CommentDTO;

import java.util.List;

public interface CommentService {

    public boolean registerComment(CommentDTO comm);

    public boolean deleteComment(Integer commNo);

    public List<CommentDTO> getCommentList(CommentDTO comm);



}
