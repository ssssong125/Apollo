package com.b4.apollo.member.controller;

import com.b4.apollo.member.model.dto.MemberDTO;
import com.b4.apollo.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("member")
public class MemberController {

    private final MemberService memberService;
    private final MessageSource messageSource;

    @Autowired
    public MemberController(MemberService memberService, MessageSource messageSource) {
        this.memberService = memberService;
        this.messageSource = messageSource;
    }

    @GetMapping ("signup")
    public ModelAndView insertMember(ModelAndView mv, MemberDTO m){
        mv.setViewName("member/signup");
        return mv;
    }

//    @RequestMapping(value = "idCheck", method = RequestMethod.GET)
//    @ResponseBody
//    public int idCheck(String id){
//        int result = memberService.idCheck(id);
//        return result;
//    }
}
