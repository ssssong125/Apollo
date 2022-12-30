package com.b4.apollo.qna.service;

import com.b4.apollo.qna.exception.CommonException;
import com.b4.apollo.qna.model.dao.AnswerDao;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AnswerServiceImpl {

    @Autowired
    private AnswerDao answerDao;

    @Autowired
    private SqlSessionTemplate sqlSession;

    private int createAnswer(int bno) {
        int result = this.answerDao.createAnswer(sqlSession, bno);
        if (result < 0) {
            throw new CommonException("댓글 추가 실패");
        } else {
            return result;
        }
    }
}
