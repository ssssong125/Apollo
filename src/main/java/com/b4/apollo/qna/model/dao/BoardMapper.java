package com.b4.apollo.qna.model.dao;

import com.b4.apollo.qna.model.dto.QuestionDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 @FileName : BoardMapper.java
 @Project : Apollo
 @Date : 2022. 12. 29.
 @작성자 : 이현도
 @프로그램 설명 : 서버 구동 프로그램
 */
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
