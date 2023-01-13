package com.b4.apollo.blog.model.dao;

import com.b4.apollo.blog.model.dto.CommentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {

    public int insertComment(CommentDTO comm);

    public CommentDTO selectCommentDetail(int commNo);

    public int updateComment(CommentDTO comm);

    public int deleteComment(int commNo);

    public List<CommentDTO> selectCommentList(CommentDTO comm);

    public int selectCommentTotalCount(CommentDTO comm);

}
