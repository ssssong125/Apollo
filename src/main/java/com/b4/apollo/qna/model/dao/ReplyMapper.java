package com.b4.apollo.qna.model.dao;

import com.b4.apollo.qna.model.dto.ReplyDTO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 @FileName : ReplyMapper.java
 @Project : Apollo
 @Date : 2023. 01. 25.
 @작성자 : 이현도
 @프로그램 설명 : 서버 구동 프로그램
 */
@Mapper
public interface ReplyMapper {

    List<ReplyDTO> selectReplyList(int bno);
    int insertReply(ReplyDTO reo);
    ReplyDTO replyModify(Integer replyNo);
    ReplyDTO selectReply(Integer replyNo);
    int deleteReply(ReplyDTO rep);
    int updateReply(int bno);
}
