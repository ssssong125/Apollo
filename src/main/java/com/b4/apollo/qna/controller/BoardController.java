package com.b4.apollo.qna.controller;

import com.b4.apollo.common.Pagination;
import com.b4.apollo.qna.exception.CommonException;
import com.b4.apollo.qna.model.dto.PageInfo;
import com.b4.apollo.qna.model.dto.Question;
import com.b4.apollo.qna.model.dto.QuestionForm;
import com.b4.apollo.qna.service.BoardService;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
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
    public String selectList(@RequestParam(value = "currentPage",
            required = false, defaultValue = "1") int currentPage, Model model) {

        int listCount = boardService.selectListCount();

        PageInfo pageInfo = Pagination.getPageInfo(listCount, currentPage, 10, 5);

        ArrayList<Question> list = boardService.selectList(pageInfo);

        model.addAttribute("list", list);
        model.addAttribute("pageInfo", pageInfo);
        return "qna/boardList";
    }

    // 게시글 작성
    @GetMapping("/create")
    public String insertBoard(QuestionForm questionForm){
        return "qna/board_form";
    }

    @PostMapping("/create")
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) {
        boardService.insertBoard(questionForm.getBoardTitle(), questionForm.getBoardContent());
        return "redirect:/question/list"; // 질문 저장후 질문목록으로 이동
    }

     //질문 게시판 상세 조회
    @GetMapping(value = "/detail/{bno}")
    public String selectBoard(@PathVariable("bno") int bno, Model model) {
        Question question = boardService.selectBoard(bno);
        model.addAttribute("question", question);
        return "/qna/boardDetail";
    }

    // 질문 수정
    @GetMapping("/modify/{boardNo}")
    public String questionModify(QuestionForm questionForm, @PathVariable("boardNo") int boardNo) {
        Question question = this.boardService.selectBoard(boardNo);
        questionForm.setBoardTitle(question.getBoardTitle());
        questionForm.setBoardContent(question.getBoardContent());
        return "/qna/board_form";
    }

    @PostMapping("/modify/{boardNo}")
    public String questionModify(@Valid QuestionForm questionForm, BindingResult bindingResult,
                                 @PathVariable("boardNo") int boardNo) {
        if (bindingResult.hasErrors()) {
            return "/qna/board_form";
        }
        Question q = this.boardService.selectBoard(boardNo);
        this.boardService.updateBoard(q, questionForm.getBoardTitle(), questionForm.getBoardContent());
        return String.format("redirect:/question/detail/%s", boardNo);
    }


    // 질문 삭제
    @GetMapping("/delete/{boardNo}")
    private String deleteBoard(@PathVariable("boardNo")  int boardNo) {
        boardService.deleteBoard(boardNo);
        return "redirect:/question/list";
    }
}
