package com.b4.apollo.qna.model.dao;

import com.b4.apollo.qna.model.dto.PageInfo;
import com.b4.apollo.qna.model.dto.QuestionDTO;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class BoardDao {

    public int selectListCount(SqlSessionTemplate sqlSession) {
        return sqlSession.selectOne("boardMapper.selectListCount");
    }

    public ArrayList<QuestionDTO> selectList(SqlSessionTemplate sqlSession, PageInfo pageInfo) {
        int offset = (pageInfo.getCurrentPage() - 1) * pageInfo.getBoardLimit();
        RowBounds rowBounds = new RowBounds(offset, pageInfo.getBoardLimit());

        return (ArrayList)sqlSession.selectList("boardMapper.selectList", null, rowBounds);
    }

    public int increaseCount(SqlSessionTemplate sqlSession, int bno) {
        return sqlSession.update("boardMapper.increaseCount", bno);
    }

    public QuestionDTO selectBoard(SqlSessionTemplate sqlSession, int bno) {
        return sqlSession.selectOne("boardMapper.selectBoard", bno);
    }

    public int insertBoard(SqlSessionTemplate sqlSession, QuestionDTO q) {
        return sqlSession.insert("boardMapper.insertBoard", q);
    }

    public int deleteBoard(SqlSessionTemplate sqlSession, int boardNo) {
        return sqlSession.update("boardMapper.deleteBoard", boardNo);
    }

    public int updateBoard(SqlSessionTemplate sqlSession, QuestionDTO q) {
        return sqlSession.update("boardMapper.updateBoard", q);
    }
}
