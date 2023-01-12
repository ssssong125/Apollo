package com.b4.apollo.blog.model.dao;

import com.b4.apollo.blog.model.dto.CommentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {

    List<CommentDTO> getList(CommentDTO commNo);   //목록 요청
    void insertComm(CommentDTO comm);
}