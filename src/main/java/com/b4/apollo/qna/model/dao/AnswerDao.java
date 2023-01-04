//package com.b4.apollo.qna.model.dao;
//
//import com.b4.apollo.qna.model.dto.Answer;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class AnswerDao {
//
//
//
////    public int create(SqlSessionTemplate sqlSession, Answer a) {
////        return sqlSession.insert("boardMapper.insertReply", a);
////    }
//
////    public List<Answer> selectReplyList(SqlSessionTemplate sqlSession, Answer answer) {
////        return sqlSession.selectList("boardMapper.selectReplyList", answer);
////    }
//
//    public List<Answer> getReplyList(SqlSessionTemplate sqlSession, Answer answer) {
//        return sqlSession.selectList("boardMapper.getReplyList", answer);
//    }
//
//    public void create(SqlSessionTemplate sqlSession, Answer answer) {
//        sqlSession.insert("boardMapper.insertReply", answer);
//    }
//
//
////    public List<Answer> selectReplyList(SqlSessionTemplate sqlSession, int bno) {
////        return sqlSession.selectList("boardMapper.selectReplyList", bno);
////    }
//}
