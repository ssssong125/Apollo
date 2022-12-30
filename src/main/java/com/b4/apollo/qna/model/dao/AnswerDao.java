package com.b4.apollo.qna.model.dao;

import com.b4.apollo.qna.model.dto.Answer;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AnswerDao {

    public int createAnswer (SqlSessionTemplate sqlSession, int bno) {
        // TODO Auto-generated method stub
        return sqlSession.insert("boardMapper.insertReply", bno);
    }

}
