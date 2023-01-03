package com.b4.apollo.qna.service;

import com.b4.apollo.qna.model.dto.Question;
import com.github.pagehelper.Page;

/**
 * Board Test Business Logic
 *  <pre>
 *  <b> History: </b>
 * @author 이현도
 * @version 1.0.0, 2022, 12,28 최초 작성 (목록 조회 구현)
 */


public interface BoardService {



    Question selectBoard(int bno);

    void deleteBoard(int boardNo);


    void insertBoard(String boardTitle, String boardContent);

//    void updateBoard(int boardNo);
    void updateBoard(Question q, String boardTitle, String boardContent);


    Page<Question> selectList(int pageNum);
}
