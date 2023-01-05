package com.b4.apollo.user.controller;


import com.b4.apollo.user.model.dto.UserDTO;
import com.b4.apollo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {

    private final UserService userService;


    @GetMapping("signup")
    public String signupForm(){
        return "user/signup";
    }

    @PostMapping("signup")
    public ModelAndView insertUser(ModelAndView mv, UserDTO newUser, RedirectAttributes rttr){
        System.out.println(1);
        System.out.println("newUser = " + newUser);
        userService.insertUser(newUser);
        mv.setViewName("redirect:/user/login");

        rttr.addFlashAttribute("successMessage","회원가입되었습니다,");
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
