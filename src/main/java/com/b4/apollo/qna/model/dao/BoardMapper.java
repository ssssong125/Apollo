package com.b4.apollo.qna.model.dao;

import com.b4.apollo.qna.model.dto.QuestionDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BoardMapper {
    Page<QuestionDTO> selectList();

    int deleteBoard(int boardNo);

    int insertBoard(QuestionDTO q);

    int updateBoard(QuestionDTO q);

    QuestionDTO selectBoard(int bno);

    void updateCount(int bno);
}
