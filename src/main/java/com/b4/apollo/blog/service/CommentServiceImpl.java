package com.b4.apollo.blog.service;

import com.b4.apollo.blog.model.dao.CommentMapper;
import com.b4.apollo.blog.model.dto.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentMapper commentMapper;


    @Override
    public void insertComm(CommentDTO comm) {
        commentMapper.insertComm(comm);
    }

    @Override
    public List<CommentDTO> getList(CommentDTO comm) {
        return commentMapper.getList(comm);
    }
}
