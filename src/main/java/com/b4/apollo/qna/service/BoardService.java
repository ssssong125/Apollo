package com.b4.apollo.qna.service;

import com.b4.apollo.qna.model.dto.PageInfo;
import com.b4.apollo.qna.model.dto.Question;

import java.util.ArrayList;

/**
 * Board Test Business Logic
 *  <pre>
 *  <b> History: </b>
 * @author 이현도
 * @version 1.0.0, 2022, 12,28 최초 작성 (목록 조회 구현)
 */


public interface BoardService {

    ArrayList<Question> selectList(PageInfo pageInfo);

    Question selectBoard(int bno);

    int selectListCount();

    void deleteBoard(int boardNo);


    void insertBoard(String boardTitle, String boardContent);

    void updateBoard(int boardNo);

    void updateBoard(String boardTitle, String boardContent);
}
