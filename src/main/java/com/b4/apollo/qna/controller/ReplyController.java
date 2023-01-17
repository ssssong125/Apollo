package com.b4.apollo.qna.controller;

import com.b4.apollo.blog.adapter.GsonLocalDateTimeAdapter;
import com.b4.apollo.blog.exception.CommonException;
import com.b4.apollo.qna.model.dto.ReplyDTO;
import com.b4.apollo.qna.service.ReplyService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 @FileName : ReplyController.java
 @Project : Apollo
 @Date : 2023. 01. 15.
 @작성자 : 이현도
 @프로그램 설명 : 댓글 컨트롤러
 */
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
    public String insertReply(HttpSession session, ReplyDTO rep) {

        String writer = (String)session.getAttribute("userId");

        rep.setReplyWriter(writer);

        try {
            if (writer != null) {
                int result = replyService.insertReply(rep);
                return String.valueOf(result);
            }
        } catch(NullPointerException e){
            throw new CommonException("댓글 등록 실패 ");
        } catch(Exception e){
            e.printStackTrace();
        }
        return "/qna/boardDetail";
    }

    //댓글 수정
    @ResponseBody
    @RequestMapping(value = "/replyModify", produces = "application/json;charset=utf-8", method = RequestMethod.GET)
    public String commModify(@RequestParam("replyNo") Integer replyNo) {
        ReplyDTO rep = replyService.replyModify(replyNo);
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("replyContent",rep.getReplyContent());
        return jsonObj.toString();
    }
    
    
    //댓글 삭제
//    @RequestMapping(value = "/replyDelete", produces = "application/json;charset=utf-8", method = RequestMethod.POST)
//    @ResponseBody
//    private String deleteReply(@RequestParam(value = "replyNo")  Integer replyNo) {
//
//        ReplyDTO rep = replyService.selectReply(replyNo);
//        int result = replyService.deleteReply(rep);
//        return String.valueOf(result);
//    }
//}
    @RequestMapping(value = "/replyDelete/{replyNo}", produces = "application/json;charset=utf-8" , method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deleteReply(HttpSession session, Model model, @PathVariable("replyNo") Integer replyNo){
        Map<String, Object> map = new HashMap<>();

      String replier = (String)session.getAttribute("userId");

        try {
            ReplyDTO rep = replyService.selectReply(replyNo);
            rep.setReplyNo(replyNo);

            if(replier.equals(rep.getReplyWriter())){

            replyService.deleteReply(rep);
            map.put("result", "success");
            }
        } catch(NullPointerException e) {
            throw new CommonException("Null, 댓글 삭제 실패 ");
        } catch (Exception e){
            e.printStackTrace();
            map.put("result", "fail");
        }
        return map;
    }
}
