package com.b4.apollo.qna.controller;

import com.b4.apollo.qna.model.dto.Answer;
import com.b4.apollo.qna.model.dto.AnswerForm;
import com.b4.apollo.qna.model.dto.Question;
import com.b4.apollo.qna.service.AnswerService;
import com.b4.apollo.qna.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {

    private final BoardService boardService;
    private final AnswerService answerService;

//    @GetMapping ("/create/{bno}")
//    @ResponseBody
//    private String selectReplyList(@PathVariable("bno") int bno) throws Exception{
//
//        List<Answer> list = answerService.selectReplyList(bno);
//
//        return  "qna/boardDetail";
//    }

    @PostMapping("/create/{bno}")
    public String createAnswer(Model model, @PathVariable("bno") int bno
            , @Valid AnswerForm answerForm, BindingResult bindingResult){

        Question question = boardService.selectBoard(bno);

        if (bindingResult.hasErrors()) {
            model.addAttribute("question", question);
            return "qna/boardDetail";
        }
        this.answerService.create(question.getBoardNo(), answerForm.getReplyContent());
        return String.format("redirect:/question/detail/%s", bno);
    }
}
