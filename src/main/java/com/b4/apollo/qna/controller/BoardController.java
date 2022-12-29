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

@RequestMapping("/question")
@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @RequestMapping("list")
    public String selectList(@RequestParam(value="currentPage",
            required = false, defaultValue = "1") int currentPage, Model model ) {

        int listCount = boardService.selectListCount();

        PageInfo pageInfo = Pagination.getPageInfo(currentPage, currentPage, 10, 5);

        ArrayList<Question> list = boardService.selectList(pageInfo);

        model.addAttribute("list", list);
        model.addAttribute("pageInfo", pageInfo);
        return "qna/boardList";
    }
    @GetMapping(value = "/detail/{bno}")
    public String selectBoard(@PathVariable("bno") int bno, Model model) {
        Question question = boardService.selectBoard(bno);
        model.addAttribute("question", question)/*.setViewName("/qna/boardDetail");*/;
//        return mv;
        return "/qna/boardDetail";
    }
}
