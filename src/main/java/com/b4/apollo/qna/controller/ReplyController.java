package com.b4.apollo.qna.controller;

import com.b4.apollo.blog.adapter.GsonLocalDateTimeAdapter;
import com.b4.apollo.qna.model.dto.ReplyDTO;
import com.b4.apollo.qna.service.ReplyService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/question/detail")
public class ReplyController {
    @Autowired
    private ReplyService replyService;

    // 댓글 목록 출력
    @ResponseBody
    @RequestMapping(value = "/replyList", produces = "application/json;charset=utf-8", method = RequestMethod.GET)
    public String getReplyList(@RequestParam("boardNo") Integer boardNo) {
        int bno = (boardNo == 0) ? 1 : boardNo;
        List<ReplyDTO> replyLists = replyService.selectReplyList(bno);
        if (!replyLists.isEmpty()) {
            Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new GsonLocalDateTimeAdapter())
                    .registerTypeAdapter(LocalDate.class, new GsonLocalDateTimeAdapter()).create();
            return gson.toJson(replyLists);
        }
        return replyLists.toString();
    }

    // 댓글 등록
    @ResponseBody
    @RequestMapping(value = "replyInsert")
    public String insertReply(ReplyDTO rep) {
        int result = replyService.insertReply(rep);
        return String.valueOf(result);
    }

    @ResponseBody
    @RequestMapping(value = "/replyModify", produces = "application/json;charset=utf-8", method = RequestMethod.GET)
    public String commModify(@RequestParam("replyNo") Integer replyNo) {
        ReplyDTO rep = replyService.replyModify(replyNo);
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("replyContent",rep.getReplyContent());
        return jsonObj.toString();
    }

    @RequestMapping(value = "/replyDelete", produces = "application/json;charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    private String deleteReply(@RequestParam(value = "replyNo")  Integer replyNo) {

        ReplyDTO rep = replyService.selectReply(replyNo);
        int result = replyService.deleteReply(rep);
        return String.valueOf(result);
    }
}
