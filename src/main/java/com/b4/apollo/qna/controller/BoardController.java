package com.b4.apollo.qna.controller;

import com.b4.apollo.blog.exception.CommonException;
import com.b4.apollo.qna.model.dto.QuestionDTO;
import com.b4.apollo.qna.model.dto.QuestionForm;
import com.b4.apollo.qna.model.dto.ReplyDTO;
import com.b4.apollo.qna.service.BoardService;
import com.b4.apollo.qna.service.ReplyService;
import com.b4.apollo.user.model.dto.UserDTO;
import com.github.pagehelper.PageInfo;
import groovy.transform.Undefined;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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

    @Autowired
    private UserDTO userDTO;

    //질문 게시판 전체 조회
    @GetMapping("/list")
    public String selectList(HttpSession session, @RequestParam(required = false, defaultValue = "1") int pageNum, Model model) {
        ReplyDTO rep = new ReplyDTO();
        PageInfo<QuestionDTO> list = new PageInfo<>(boardService.selectList(pageNum), 10);

        String writer = (String) session.getAttribute("userId");

        model.addAttribute("writer", writer);
        model.addAttribute("rep", rep);
        model.addAttribute("list", list);
        return "qna/boardList";
    }

    // 게시글 작성
    @GetMapping("/create")
    public String insertBoard(QuestionForm questionForm){
        return "qna/boardForm";
    }

    @PostMapping("/create")
    public String questionCreate(HttpSession session, @Valid QuestionForm questionForm, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return "qna/boardForm";
        }
        String writer = (String) session.getAttribute("userId");

        boardService.insertBoard(writer, questionForm.getBoardTitle(), questionForm.getBoardContent());

        return "redirect:/question/list"; // 질문 저장후 질문목록으로 이동
    }

     //질문 게시판 상세 조회
    @GetMapping(value = "/detail/{bno}")
    public String selectBoard(@PathVariable("bno") int bno, Model model) {
        QuestionDTO questionDTO = boardService.selectBoard(bno);
        ReplyDTO rep = new ReplyDTO();

        model.addAttribute("rep", rep);
        model.addAttribute("question", questionDTO);


        return "/qna/boardDetail";
    }

    // 질문 수정
    @GetMapping("/modify/{boardNo}")
    public String questionModify(HttpSession session, QuestionForm questionForm, @PathVariable("boardNo") int boardNo) {
        QuestionDTO questionDTO = this.boardService.selectBoard(boardNo);

        String writer = (String) session.getAttribute("userId");
        questionDTO.setUserId(writer);

        questionForm.setBoardTitle(questionDTO.getBoardTitle());
        questionForm.setBoardContent(questionDTO.getBoardContent());
        return "/qna/boardForm";
    }

    @PostMapping("/modify/{boardNo}")
    public String questionModify(HttpSession session, @Valid QuestionForm questionForm, BindingResult bindingResult,
                                 @PathVariable("boardNo") int boardNo) throws Exception {
        if (bindingResult.hasErrors()) {
            return "/qna/boardForm";
        }
        QuestionDTO q = this.boardService.selectBoard(boardNo);

        String writer = (String) session.getAttribute("userId");

        try {
            if (writer.equals(q.getUserId())) {

                boardService.updateBoard(q, questionForm.getBoardTitle(), questionForm.getBoardContent());
                return String.format("redirect:/question/detail/%s", boardNo);
            }
        }catch(NullPointerException e){
            throw new CommonException("수정 실패 ");
        }
        return "redirect:/question/list";
    }


    // 질문 삭제
    @GetMapping("/delete/{boardNo}")
    private String deleteBoard(HttpSession session, @PathVariable("boardNo")  int boardNo) {

            QuestionDTO q = this.boardService.selectBoard(boardNo);
            String writer = (String) session.getAttribute("userId");
        try {
            if (writer.equals(q.getUserId())) {
                boardService.deleteBoard(boardNo);
                return "redirect:/question/list";
            }
        } catch(NullPointerException e){
            throw new CommonException("삭제 실패 ");
        }
        return "/qna/boardDetail";
    }

    //FAQ
    @RequestMapping("/faq")
    public String faqBoard(){
        return "qna/faq";
    }
}
