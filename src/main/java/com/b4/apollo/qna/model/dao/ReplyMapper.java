package com.b4.apollo.qna.model.dao;

import com.b4.apollo.qna.model.dto.ReplyDTO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ReplyMapper {

    List<ReplyDTO> selectReplyList(int bno);
    int insertReply(ReplyDTO reo);
    ReplyDTO replyModify(Integer replyNo);
    ReplyDTO selectReply(Integer replyNo);
    int deleteReply(ReplyDTO rep);
    int updateReply(int bno);
}
