package com.b4.apollo.user.controller;


import com.b4.apollo.user.model.dto.UserDTO;
import com.b4.apollo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Locale;

@Controller
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {

    private final UserService userService;
    private final MessageSource messageSource;

    @GetMapping("signup")
    public String signupForm(){
        return "user/signup";
    }

    @PostMapping("signup")
    public ModelAndView insertUser(ModelAndView mv, UserDTO newUser, RedirectAttributes rttr, Locale locale) throws Exception{
        userService.insertUser(newUser);
        mv.setViewName("redirect:/user/login");

        rttr.addFlashAttribute("successMessage", messageSource.getMessage("insertUser", null, locale));
        return mv;
    }

    @PostMapping("idCheck")
    @ResponseBody
    public int idCheck(@RequestParam("userId") String userId){

        int cnt = userService.idCheck(userId);
        return cnt;
    }

    @GetMapping("/login")
    public String userLoginForm(){
        return "/user/login";
    }

    @GetMapping("/mypage")
    public void userPage(){

    }

    @GetMapping("contact")
    public void contact(){

    }

}
