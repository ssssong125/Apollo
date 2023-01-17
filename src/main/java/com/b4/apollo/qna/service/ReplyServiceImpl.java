package com.b4.apollo.qna.service;

import com.b4.apollo.blog.exception.CommonException;
import com.b4.apollo.qna.model.dao.ReplyMapper;
import com.b4.apollo.qna.model.dto.ReplyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 @FileName : ReplyServiceImpl.java
 @Project : Apollo
 @Date : 2023. 01. 15.
 @작성자 : 이현도
 @프로그램 설명 : 질문 게시판 댓글 관련 요청을 처리할 Service의 구현체
 */
@Service
public class ReplyServiceImpl  implements ReplyService{

    @Autowired
    private ReplyMapper replyMapper;
    @Override
    public List<ReplyDTO> selectReplyList(int bno) {
        return replyMapper.selectReplyList(bno);
    }

    @Override
    public int insertReply(ReplyDTO reo) {
        int result = replyMapper.insertReply(reo);
        if(result < 0) {
            throw new CommonException("댓글 추가 실패 ");
        }
        return result;
    }

    @Override
    public ReplyDTO replyModify(Integer replyNo) {
        return replyMapper.replyModify(replyNo);
    }

    @Override
    public ReplyDTO selectReply(Integer replyNo) {
        return replyMapper.selectReply(replyNo);
    }

    @Override
    public int deleteReply(ReplyDTO rep) {
        int result = replyMapper.deleteReply(rep);
        if(result < 0) {
            throw new CommonException("댓글 삭제 실패 ");
        }
        return result;
    }

    @Override
    public int updateReply(int bno) {
        int result = replyMapper.updateReply(bno);
        if(result < 0) {
            throw new CommonException("댓글 수정 실패 ");
        }
        return  result;
    }
}
