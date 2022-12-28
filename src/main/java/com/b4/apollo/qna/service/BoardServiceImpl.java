package com.b4.apollo.qna.service;

import com.b4.apollo.qna.model.dao.BoardMapper;
import com.b4.apollo.qna.model.dto.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardMapper boardMapper;
    @Override
    public List<Question> selectBoardList() throws Exception {
        return boardMapper.selectBoardList();
    }
}
