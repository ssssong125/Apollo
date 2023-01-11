package com.b4.apollo.user.controller;


import com.b4.apollo.user.model.dto.UserDTO;
import com.b4.apollo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Locale;

@Controller
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {

    private final UserService userService;
    private final MessageSource messageSource;


    @GetMapping("userList")
    public ModelAndView findAllUser(ModelAndView mv){
        List<UserDTO> userList = userService.findAllUser();
        userList.stream().forEach(user -> System.out.println("user = " + user));
        mv.addObject("userList", userList);
        mv.setViewName("admin/userList");
        return mv;
    }
    @GetMapping("signup")
    public String signupForm(){
        return "user/signup";
    }

    @PostMapping("signup")
    public ModelAndView insertUser(ModelAndView mv, UserDTO newUser, RedirectAttributes rttr, Locale locale) throws Exception{
        userService.insertUser(newUser);
        mv.setViewName("redirect:/user/login");

        rttr.addFlashAttribute("signupSuccessMessage", messageSource.getMessage("insertUser", null, locale));
        return mv;
    }

//    @PostMapping("idCheck")
//    @ResponseBody
//    public int idCheck(@RequestParam("userId") String userId){
//
//        int cnt = userService.idCheck(userId);
//        return cnt;
//    }

    @GetMapping("/login")
    public String userLoginForm(){
        return "/user/login";
    }

    @GetMapping("/mypage")
    public void userPage(){

    }

    @GetMapping("/update")
    public String updateForm(){
        return "/user/update";
    }

    @PostMapping("/update")
    public ModelAndView updateUser(ModelAndView mv, UserDTO updateDTO, RedirectAttributes rttr, Locale locale) throws Exception{
        userService.updateUser(updateDTO);
        mv.setViewName("redirect:/user/mypage");
        rttr.addFlashAttribute("updSuccessMessage", messageSource.getMessage("updateUser", null, locale));
        return mv;
    }

    @GetMapping("delete")
    public String deletepage(){
        return "/user/delete";
    }

    @PostMapping("delete")
    public ModelAndView deleteUser(ModelAndView mv, String userId, RedirectAttributes rttr, Locale locale) throws Exception {
        userService.deleteUser(userId);
        mv.setViewName("redirect:/main");
        rttr.addFlashAttribute("deleSuccessMessage", messageSource.getMessage("deleteUser", null, locale));
        return mv;
    }



}
