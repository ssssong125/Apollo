package com.b4.apollo.qna.service;

import com.b4.apollo.qna.model.dto.Question;

import java.util.List;

/**
 * Board Test Business Logic
 *  <pre>
 *  <b> History: </b>
 * @author 이현도
 * @version 1.0.0, 2022, 12,28 최초 작성 (목록 조회 구현)
 */


public interface BoardService {

    List<Question> selectBoardList() throws Exception;
}
