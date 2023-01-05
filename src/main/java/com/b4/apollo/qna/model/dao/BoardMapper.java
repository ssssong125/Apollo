package com.b4.apollo.qna.model.dao;

import com.b4.apollo.qna.model.dto.Answer;
import com.b4.apollo.qna.model.dto.QuestionDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BoardMapper {
    Page<QuestionDTO> selectList();

    int deleteBoard(int boardNo);

    int insertBoard(QuestionDTO q);

    int updateBoard(QuestionDTO q);

    QuestionDTO selectBoard(int bno);

    List<Answer> getReplyList(Answer answer);

    void insertReply(Answer answer);

    void updateCount(int bno);
}
