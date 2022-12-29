package com.b4.apollo.qna.service;

import com.b4.apollo.qna.exception.DataNotFoundException;
import com.b4.apollo.qna.model.dao.BoardDao;
import com.b4.apollo.qna.model.dto.PageInfo;
import com.b4.apollo.qna.model.dto.Question;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private SqlSessionTemplate sqlSession;

    @Autowired
    private BoardDao boardDao;

    @Override
    public int selectListCount() {
        return boardDao.selectListCount(sqlSession);
    }

    @Override
    public ArrayList<Question> selectList(PageInfo pageInfo) {
        return boardDao.selectList(sqlSession, pageInfo);
    }


    @Override
    public Question selectBoard(int bno) {
        Optional<Question> question = Optional.ofNullable(this.boardDao.selectBoard(sqlSession, bno));
        if(question.isPresent()){
            return question.get();
        }else{
            throw new DataNotFoundException("question not found");
        }
    }
}
