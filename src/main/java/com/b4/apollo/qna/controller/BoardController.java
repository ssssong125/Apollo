package com.b4.apollo.qna.controller;

import com.b4.apollo.common.Pagination;
import com.b4.apollo.qna.model.dto.PageInfo;
import com.b4.apollo.qna.model.dto.Question;
import com.b4.apollo.qna.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
/**
 @FileName : BoardController.java

 @Project : Apollo

 @Date : 2022. 12. 29.

 @작성자 : 이현도

 @프로그램 설명 : 질문 게시판 조회 컨트롤러
 */
@RequestMapping("/question")
@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    //질문 게시판 전체 조회
    @RequestMapping("list")
    public String selectList(@RequestParam(value="currentPage",
            required = false, defaultValue = "1") int currentPage, Model model ) {

        int listCount = boardService.selectListCount();

        PageInfo pageInfo = Pagination.getPageInfo(listCount, currentPage, 10, 5);

        ArrayList<Question> list = boardService.selectList(pageInfo);

        model.addAttribute("list", list);
        model.addAttribute("pageInfo", pageInfo);
        return "qna/boardList";
    }
    
    //질문 게시판 상세 조회
    @GetMapping(value = "/detail/{bno}")
    public String selectBoard(@PathVariable("bno") int bno, Model model) {
        Question question = boardService.selectBoard(bno);
        model.addAttribute("question", question);
        return "/qna/boardDetail";
    }
}
