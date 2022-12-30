package com.b4.apollo.qna.controller;

import com.b4.apollo.qna.model.dto.Answer;
import com.b4.apollo.qna.model.dto.Question;
import com.b4.apollo.qna.service.AnswerService;
import com.b4.apollo.qna.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {

    private AnswerService answerService;

    @PostMapping("/creat/{bno}")
    public String createAnswer(Model model, @PathVariable("bno") int bno, @RequestParam String boardContent){
        int answer = this.answerService.createAnswer(bno);
        //TODO 답변을 저장한다.
        return String.format("redirect:/question/detail/%s", bno);
    }
}
