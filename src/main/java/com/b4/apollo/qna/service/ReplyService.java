package com.b4.apollo.qna.service;


import com.b4.apollo.qna.model.dto.ReplyDTO;
import java.util.List;

public interface ReplyService {

    List<ReplyDTO> selectReplyList(int bno);
    int insertReply(ReplyDTO reo);
    ReplyDTO replyModify(Integer replyNo);
    ReplyDTO selectReply(Integer replyNo);
    int deleteReply(ReplyDTO rep);
    int updateReply(int bno);
}
