package com.b4.apollo.qna.service;

import com.b4.apollo.qna.exception.CommonException;
import com.b4.apollo.qna.model.dao.AnswerDao;
import com.b4.apollo.qna.model.dto.Answer;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AnswerServiceImpl implements  AnswerService{

    @Autowired
    private SqlSessionTemplate sqlSession;

    @Autowired
    private AnswerDao answerDao;

    public void create(Integer boardNo, String replyContent) {
        Answer a = new Answer();
        a.setReplyContent(replyContent);
        a.setCreateDate(LocalDateTime.now());
        a.setBoardNo(boardNo);
        int result = answerDao.create(sqlSession, a);

        if(result < 0) {
            throw new CommonException("댓글 추가 실패 ");
        }
    }

    @Override
    public List<Answer> selectReplyList(int bno) {
        return answerDao.selectReplyList(sqlSession , bno);
    }
}
