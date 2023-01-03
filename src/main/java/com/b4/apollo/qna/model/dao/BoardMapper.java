package com.b4.apollo.qna.model.dao;

import com.b4.apollo.qna.model.dto.Answer;
import com.b4.apollo.qna.model.dto.Question;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BoardMapper {
    Page<Question> selectList();

    int deleteBoard(int boardNo);

    int insertBoard(Question q);

    int updateBoard(Question q);

    Question selectBoard(int bno);

    List<Answer> getReplyList(Answer answer);

    void create(Answer answer);
}
