package com.b4.apollo.qna.service;

import com.b4.apollo.qna.model.dao.BoardMapper;
import com.b4.apollo.qna.model.dto.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements  AnswerService{


    @Autowired
    private BoardMapper boardMapper;

//    public void create(Integer boardNo, String replyContent) {
//        Answer a = new Answer();
//        a.setReplyContent(replyContent);
//        a.setCreateDate(LocalDateTime.now());
//        a.setBoardNo(boardNo);
//        int result = answerDao.create(sqlSession, a);
//
//        if(result < 0) {
//            throw new CommonException("댓글 추가 실패 ");
//        }
//    }

    @Override
    public List<Answer> getReplyList(Answer answer) {
        return boardMapper.getReplyList(answer);
    }

    @Override
    public void insertReply(Answer answer) {
        boardMapper.insertReply(answer);
    }

//    @Override
//    public int create(Answer answer) {
//        return answerDao.create(sqlSession , answer);
//    }

//    @Override
//    public List<Answer> selectReplyList(Answer answer) {
//        return answerDao.selectReplyList(sqlSession , answer);
//    }

//    @Override
//    public List<Answer> selectReplyList(int bno) {
//        return answerDao.selectReplyList(sqlSession , bno);
//    }
}
