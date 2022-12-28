package com.b4.apollo.board.model.dao;

import com.b4.apollo.board.model.dto.Question;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public class QnaMapper {
    public List<Question> findAll;
}
