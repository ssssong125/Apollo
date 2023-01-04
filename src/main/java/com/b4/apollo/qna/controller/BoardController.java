package com.b4.apollo.qna.controller;

import com.b4.apollo.qna.model.dto.AnswerForm;
import com.b4.apollo.qna.model.dto.QuestionDTO;
import com.b4.apollo.qna.model.dto.QuestionForm;
import com.b4.apollo.qna.service.BoardService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    //페이징

//    @RequestMapping("/pagesample")
//    public PageInfo<Question> findPage(HttpServletRequest request){
//        PageHelper.startPage(request);
//        return  PageInfo.of(boardService.findAll());
//    }


    //질문 게시판 전체 조회
    @GetMapping("/list")
    public String selectList(@RequestParam(required = false, defaultValue = "1") int pageNum, Model model) {

        PageInfo<QuestionDTO> list = new PageInfo<>(boardService.selectList(pageNum), 10);


        model.addAttribute("list", list);
        return "qna/boardList";
    }

    // 게시글 작성
    @GetMapping("/create")
    public String insertBoard(QuestionForm questionForm){
        return "qna/board_form";
    }

    @PostMapping("/create")
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/qna/board_form";
        }
        boardService.insertBoard(questionForm.getBoardTitle(), questionForm.getBoardContent());
        return "redirect:/question/list"; // 질문 저장후 질문목록으로 이동
    }

     //질문 게시판 상세 조회
    @GetMapping(value = "/detail/{bno}")
    public String selectBoard(@PathVariable("bno") int bno, Model model, AnswerForm answerForm) {
        QuestionDTO questionDTO = boardService.selectBoard(bno);
        model.addAttribute("question", questionDTO);
        return "/qna/boardDetail";
    }

    // 질문 수정
    @GetMapping("/modify/{boardNo}")
    public String questionModify(QuestionForm questionForm, @PathVariable("boardNo") int boardNo) {
        QuestionDTO questionDTO = this.boardService.selectBoard(boardNo);
        questionForm.setBoardTitle(questionDTO.getBoardTitle());
        questionForm.setBoardContent(questionDTO.getBoardContent());
        return "/qna/board_form";
    }

    @PostMapping("/modify/{boardNo}")
    public String questionModify(@Valid QuestionForm questionForm, BindingResult bindingResult,
                                 @PathVariable("boardNo") int boardNo) {
        if (bindingResult.hasErrors()) {
            return "/qna/board_form";
        }
        QuestionDTO q = this.boardService.selectBoard(boardNo);
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
