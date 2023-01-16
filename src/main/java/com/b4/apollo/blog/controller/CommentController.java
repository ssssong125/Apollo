package com.b4.apollo.blog.controller;

import com.b4.apollo.blog.adapter.GsonLocalDateTimeAdapter;
import com.b4.apollo.blog.model.dto.CommentDTO;
import com.b4.apollo.blog.service.CommentService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("blog")
public class CommentController {
    @Autowired
    private CommentService commentService;

    // 댓글 목록 출력
    @ResponseBody
    @RequestMapping(value = "/commList", produces = "application/json;charset=utf-8", method = RequestMethod.GET)
    public String getCommList(@RequestParam("blogNo") Integer blogNo) {
        int bno = (blogNo == 0) ? 1 : blogNo;
        List<CommentDTO> commLists = commentService.selectCommList(bno);
        if (!commLists.isEmpty()) {
            Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new GsonLocalDateTimeAdapter())
                    .registerTypeAdapter(LocalDate.class, new GsonLocalDateTimeAdapter()).create();
            return gson.toJson(commLists);
        }
        return commLists.toString();
    }

    // 댓글 등록
    @ResponseBody
    @RequestMapping(value = "commInsert")
    public String insertComm(CommentDTO comm) {
        int result = commentService.insertComm(comm);
        return String.valueOf(result);
    }

//    @ResponseBody
//    @RequestMapping(value = "/selectComm", produces = "application/json;charset=utf-8", method = RequestMethod.GET)
//    public String selectOneComm(@RequestParam("commNo") Integer commNo) {
//        CommentDTO comm = commentService.selectComm(commNo);
//        JSONObject jsonObj = new JSONObject();
//        jsonObj.put("commContent",comm.getCommContent());
//
//        return jsonObj.toString();
//    }
//
//    @RequestMapping(value = "/modifyComm", produces = "application/json;charset=utf-8", method = RequestMethod.POST)
//    @ResponseBody
//    private String modifyComm(@RequestParam(value = "commNo")  Integer commNo) {
//
//        int result = commentService.commModify(commNo);
//        return String.valueOf(result);
//    }


    @RequestMapping(value = "/commModify/{commNo}/{commContent}", produces = "application/json;charset=utf-8" , method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> modifyComm(@PathVariable("commNo") Integer commNo, @PathVariable("commContent") String commContent){
        Map<String, Object> map = new HashMap<>();

        try {
            CommentDTO comm = commentService.selectComm(commNo);
            comm.setCommNo(commNo);
            comm.setCommContent(commContent);
            commentService.commModify(comm);

            map.put("result", "success");
        } catch (Exception e){
            e.printStackTrace();
            map.put("result", "fail");

        }
        return map;

    }



//    @RequestMapping(value = "/commDelete/{commNo}", produces = "application/json;charset=utf-8" , method = RequestMethod.GET)
//    public String deleteComm(@PathVariable("commNo") Integer commNo){
//        return "redirect:/blog/detail/{commNo}";
//    }

    @RequestMapping(value = "/commDelete/{commNo}", produces = "application/json;charset=utf-8" , method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deleteComm(Model model, @PathVariable("commNo") Integer commNo){
        Map<String, Object> map = new HashMap<>();

        try {
            CommentDTO comm = commentService.selectComm(commNo);
            comm.setCommNo(commNo);
            commentService.deleteComm(comm);

            map.put("result", "success");
        } catch (Exception e){
            e.printStackTrace();
            map.put("result", "fail");

        }
        return map;

    }
}
