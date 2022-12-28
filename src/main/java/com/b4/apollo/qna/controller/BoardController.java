package com.b4.apollo.qna.controller;

import com.b4.apollo.qna.model.dto.Question;
import com.b4.apollo.qna.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("question")
@Controller
public class BoardController {

    @Resource
    private BoardService boardService;

    @RequestMapping("/list")
   public ModelAndView BoardList() throws Exception{

        ModelAndView mv = new ModelAndView("/qna/boardList");

        List<Question> list = boardService.selectBoardList();
        mv.addObject("list, list");

        return mv;
    }
}
