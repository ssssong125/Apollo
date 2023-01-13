package com.b4.apollo.blog.service;

import com.b4.apollo.blog.model.dao.CommentMapper;
import com.b4.apollo.blog.model.dto.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentMapper commentMapper;


    @Override
    public boolean registerComment(CommentDTO comm) {
        int queryResult = 0;

        if (comm.getCommNo() == null) {
            queryResult = commentMapper.insertComment(comm);
        } else {
            queryResult = commentMapper.updateComment(comm);
        }

        return (queryResult == 1) ? true : false;
    }


    @Override
    public boolean deleteComment(Integer commNo) {
        int queryResult = 0;

        CommentDTO comm = commentMapper.selectCommentDetail(commNo);

        if (comm != null && "Y".equals(comm.getCommStatus())) {
            queryResult = commentMapper.deleteComment(commNo);
        }

        return (queryResult == 1) ? true : false;
    }

//    @Override
//    public void deleteComment(Integer commNo) {
//        int result = commentMapper.deleteComment(commNo);
//
//        if(result < 0) {
//            throw new CommonException("삭제실패 ");
//        }
//    }


    @Override
    public List<CommentDTO> getCommentList(CommentDTO comm) {
        List<CommentDTO> commentList = Collections.emptyList();

        int commentTotalCount = commentMapper.selectCommentTotalCount(comm);

        System.out.println(commentTotalCount);
        if (commentTotalCount > 0) {
            commentList = commentMapper.selectCommentList(comm);
        }

        return commentList;
    }
}

