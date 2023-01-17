package com.b4.apollo.qna.service;


import com.b4.apollo.qna.model.dto.ReplyDTO;
import java.util.List;

/**
 @FileName : ReplyService.java
 @Project : Apollo
 @Date : 2023. 01. 15.
 @작성자 : 이현도
 @프로그램 설명 : 질문 게시판 댓글 관련 요청을 처리할 Service interface
 */
public interface ReplyService {

    List<ReplyDTO> selectReplyList(int bno);
    int insertReply(ReplyDTO reo);
    ReplyDTO replyModify(Integer replyNo);
    ReplyDTO selectReply(Integer replyNo);
    int deleteReply(ReplyDTO rep);
    int updateReply(int bno);
}
