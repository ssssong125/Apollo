package com.b4.apollo.qna.service;

import com.b4.apollo.qna.exception.CommonException;
import com.b4.apollo.qna.exception.DataNotFoundException;
import com.b4.apollo.qna.model.dao.BoardDao;
import com.b4.apollo.qna.model.dto.PageInfo;
import com.b4.apollo.qna.model.dto.Question;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

//    @Override
//    public void insertBoard(Question q) {
//        int result = boardDao.insertBoard(q);
//
//        if(result < 0) {
//            throw new CommonException("게시글추가실패 ");
//        }
//    }

    @Override
    public void deleteBoard(int bno) {
        int result = boardDao.deleteBoard(sqlSession, bno);

        if(result < 0) {
            throw new CommonException("게시글삭제실패 ");
        }
    }

    @Override
    public void insertBoard(String boardTitle, String boardContent) {
        Question q = new Question();
        q.setBoardTitle(boardTitle);
        q.setBoardContent(boardContent);
        q.setCreateDate(LocalDateTime.now());
        int result = boardDao.insertBoard(sqlSession, q);

        if(result < 0) {
            throw new CommonException("게시글 추가 실패 ");
        }
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
