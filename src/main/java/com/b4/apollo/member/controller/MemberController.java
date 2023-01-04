package com.b4.apollo.member.controller;

import com.b4.apollo.member.model.dto.MemberDTO;
import com.b4.apollo.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("member")
public class MemberController {
//
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping  ("signup")
    public ModelAndView insertMember(ModelAndView mv, MemberDTO m, RedirectAttributes rttr) throws Exception {
        memberService.insertMember(m);
        mv.setViewName("member/signup");
        rttr.addFlashAttribute("successMessage","회원가입되었습니다,");
        return mv;
    }

    @RequestMapping(value = "idCheck", method = RequestMethod.GET)
    @ResponseBody
    public int idCheck(String id){
        int result = memberService.idCheck(id);
        return result;
    }

}
