package com.b4.apollo.blog.model.dao;

import com.b4.apollo.blog.model.dto.CommentDTO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 @FileName : CommentMapper.java
 @Project : Apollo
 @Date : 2023. 01. 15.
 @작성자 : 이현도
 @프로그램 설명 : 서버 구동 프로그램
 */
@Mapper
public interface CommentMapper {

    List<CommentDTO> selectCommList(int bno);

    int insertComm(CommentDTO comm);

    int commModify(CommentDTO commNo);

    int deleteComm(CommentDTO comm);

    CommentDTO selectComm(Integer commNo);
}
