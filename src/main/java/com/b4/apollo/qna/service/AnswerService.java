package com.b4.apollo.qna.service;

import com.b4.apollo.qna.model.dto.Answer;

import java.util.List;

public interface AnswerService {


//        void create(Integer boardNo, String replyContent);

//        List<Answer> selectReplyList(Answer answer);

        List<Answer> getReplyList(Answer answer);

        void create(Answer answer);

//        int create(Answer answer);

//        List<Answer> selectReplyList(int bno);
}
