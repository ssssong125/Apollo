package com.b4.apollo.qna.model.dao;

import com.b4.apollo.qna.model.dto.Question;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<Question> selectBoardList() throws Exception;
}
