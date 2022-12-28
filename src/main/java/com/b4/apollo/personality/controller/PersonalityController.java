package com.b4.apollo.personality.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/personality")
public class PersonalityController {

    @GetMapping("loginpage")
    public ModelAndView loginpage(ModelAndView mv){
        mv.setViewName("personality/loginpage");
        return mv;
    }

    @GetMapping("signin")
    public ModelAndView signin(ModelAndView mv){
        mv.setViewName("personality/signin");
        return mv;
    }

}
