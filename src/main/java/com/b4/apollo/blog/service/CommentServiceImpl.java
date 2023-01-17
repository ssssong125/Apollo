package com.b4.apollo.blog.service;

import com.b4.apollo.blog.exception.CommonException;
import com.b4.apollo.blog.model.dao.CommentMapper;
import com.b4.apollo.blog.model.dto.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 @FileName : CommentServiceImpl.java
 @Project : Apollo
 @Date : 2023. 01. 15.
 @작성자 : 이현도
 @프로그램 설명 : 블로그 댓글 관련 요청을 처리할 Service의 구현체
 */
@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<CommentDTO> selectCommList(int bno) {
        return commentMapper.selectCommList(bno);
    }

    @Override
    public int insertComm(CommentDTO comm) {
        int result = commentMapper.insertComm(comm);
        if(result < 0) {
            throw new CommonException("댓글 추가 실패 ");
        }
        return result;
    }

    @Override
    public int commModify(CommentDTO commNo) {
        return commentMapper.commModify(commNo);
    }

    @Override
    public CommentDTO selectComm(Integer commNo) {
        return commentMapper.selectComm(commNo);
    }

    @Override
    public int deleteComm(CommentDTO comm) {
        int result = commentMapper.deleteComm(comm);
        if(result < 0) {
            throw new CommonException("댓글 삭제 실패 ");
        }
        return result;
    }

}

