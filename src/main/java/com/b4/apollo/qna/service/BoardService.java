package com.b4.apollo.qna.service;

import com.b4.apollo.qna.model.dto.QuestionDTO;
import com.github.pagehelper.Page;

/**
 @FileName : BoardService.java
 @Project : Apollo
 @Date : 2022. 12. 28.
 @작성자 : 이현도
 @프로그램 설명 : 질문 게시판 관련 요청을 처리할 Service interface
 */
public interface BoardService {

    QuestionDTO selectBoard(int bno);

    void deleteBoard(int boardNo);

//    void insertBoard(String usrId, String boardTitle, String boardContent);

//    void insertBoard(HttpSession session, String usrId, String boardTitle, String boardContent);

    //    void updateBoard(int boardNo);
    void updateBoard(QuestionDTO q, String boardTitle, String boardContent);

    Page<QuestionDTO> selectList(int pageNum);

    void insertBoard(String writer, String boardTitle, String boardContent);

}
