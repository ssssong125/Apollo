package com.b4.apollo.common.config;

import com.b4.apollo.qna.service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApolloApplicationTest {

    @Autowired
    private BoardService boardService;

    @Test
    void 질문_삽입_테스트() {
        for (int i = 1; i <= 40; i++) {
            String userId = "user01";
            String boardTitle = String.format("테스트 데이터입니다:[%03d]", i);
            String boardContent = "내용무";
            this.boardService.insertBoard(boardTitle, boardContent);
        }
    }

}