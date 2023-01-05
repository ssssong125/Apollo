package com.b4.apollo.blog.post.model.dao;

import com.b4.apollo.blog.post.model.dto.AttachDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AttachMapper {

    public int insertAttach(List<AttachDTO> attachList);

    public AttachDTO selectAttachDetail(int imgNo);

    public int deleteAttach(int boardNo);

    public List<AttachDTO> selectAttachList(int boardNo);

    public int selectAttachTotalCount(int boardNo);
}
