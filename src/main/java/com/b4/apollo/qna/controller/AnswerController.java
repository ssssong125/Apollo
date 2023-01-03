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
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {

    private final BoardService boardService;
    private final AnswerService answerService;

//    @PostMapping("/answer")
//    private ModelAndView selectReplyList() throws Exception{
//
//        List<Answer> answerList = answerService.selectReplyList(new Answer());
//
//        ModelAndView mv = new ModelAndView("qna/boardDetail");
//        mv.addObject("answerList", answerList);
//        return mv;
//    }

    @GetMapping("/getReplyList")
    @ResponseBody
    private List<Answer> getReplyList(@RequestParam("replyNo") int replyNo){
        Answer answer = new Answer();
        answer.setReplyNo(replyNo);
        return answerService.getReplyList(answer);
    }



//    @PostMapping("/answer/{bno}")
//    private String selectReplyList(Model model, @PathVariable("bno") int bno) throws Exception{
//
//        List<Answer> list = answerService.selectReplyList(bno);
//        model.addAttribute("list", list);
//
//        return String.format("redirect:/question/detail/%s", bno);
//    }

    @PostMapping("/create/{replyNo}")
    private String createAnswer(Model model, @PathVariable("replyNo") Integer replyNo,
                                @RequestParam("replyContent") String replyContent){
        Answer answer = new Answer();
        answer.setReplyNo(replyNo);
        answer.setReplyContent(replyContent);

        answerService.create(answer);

        return String.format("redirect:/question/detail/%s", replyNo);
    }



//    @PostMapping("/create/{bno}")
//    public String createAnswer(Model model, @PathVariable("bno") int bno
//            , @Valid AnswerForm answerForm, BindingResult bindingResult){
//
//        Question question = boardService.selectBoard(bno);
//
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("question", question);
//            return "qna/boardDetail";
//        }
//        this.answerService.create(question.getBoardNo(), answerForm.getReplyContent());
//
//        return String.format("redirect:/question/detail/%s", bno);
//    }
}
