package com.b4.apollo.qna.model.dao;

import com.b4.apollo.qna.model.dto.Answer;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AnswerDao {

    public int create(SqlSessionTemplate sqlSession, Answer a) {
        return sqlSession.insert("boardMapper.insertReply", a);
    }

    public List<Answer> selectReplyList(SqlSessionTemplate sqlSession, int bno) {
        return sqlSession.selectList("boardMapper.selectReplyList", bno);
    }
}
