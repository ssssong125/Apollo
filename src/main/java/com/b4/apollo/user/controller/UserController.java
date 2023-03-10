package com.b4.apollo.user.controller;


import com.b4.apollo.user.model.dto.UserDTO;
import com.b4.apollo.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Locale;

@Controller
@AllArgsConstructor
@RequestMapping("user")
public class UserController {

    private final UserService userService;
    private final MessageSource messageSource;

//    가입페이지를 불러오기 위한 맵핑 메소드
    @GetMapping("signup")
    public String signupForm(){
        return "user/signup";
    }


    @PostMapping("signup")
    public ModelAndView insertUser(UserDTO newUser, ModelAndView mv, RedirectAttributes rttr, Locale locale) throws Exception{
        userService.insertUser(newUser);
        mv.setViewName("redirect:/user/login");
        rttr.addFlashAttribute("signupSuccessMessage", messageSource.getMessage("insertUser", null, locale));

        return mv;
    }


    @GetMapping("login")
    public String userLoginForm(){

        return "/user/login";
    }

    @PostMapping({"/login", "/header"})
    @ResponseBody
    public ModelAndView loginUser(ModelAndView mv, UserDTO userDTO, HttpSession session, Model model, RedirectAttributes rttr, Locale locale) throws Exception{
        boolean result = userService.loginUser(userDTO, session);
        if(result == true){
            session.setAttribute("userId", userDTO.getUserId());
            String userId = (String)session.getAttribute("userId");
            String userDetail = model.addAttribute("userDetail", userService.userDetail(userDTO)).toString();
            mv.addObject("userDetail", userDetail);
            mv.setViewName("redirect:/user/mypage");
        }else {
            session.setAttribute("userId", userDTO.getUserId());
            String userId = (String)session.getAttribute("userId");
            rttr.addFlashAttribute("loginFailMsg", messageSource.getMessage("loginFail", null, locale));
            mv.addObject("userId", userId);
            mv.setViewName("redirect:/user/login");
        }
        return mv;
    }


    @GetMapping("/mypage")
    public String userpage(UserDTO userDTO, HttpSession session, Model model){
        String userId = (String)session.getAttribute("userId");
        userDTO.setUserId(userId);
        userService.userDetail(userDTO);
        model.addAttribute("userDetail", userService.userDetail(userDTO));
        return "user/mypage";
    }



    @GetMapping("update")
    public String userDetail(UserDTO userDTO, HttpSession session, Model model){
        String userId = (String)session.getAttribute("userId");
        userDTO.setUserId(userId);
        UserDTO userDetail = userService.userDetail(userDTO);
        model.addAttribute("userDetail", userDetail);
        return "user/update";
    }

    @PostMapping("update")
    public String userUpdate(UserDTO userDetail, Model model, RedirectAttributes rttr, Locale locale){
        userService.updateUser(userDetail);
        model.addAttribute("userDetail", userDetail);
        rttr.addFlashAttribute("updSuccessMessage", messageSource.getMessage("updateUser", null, locale));
        return "redirect:/user/mypage";
    }


    @GetMapping("delete")
    public String deletepage(UserDTO userDTO, HttpSession session, Model model){

        String userId = (String)session.getAttribute("userId");
        userDTO.setUserId(userId);
        userService.userDetail(userDTO);
        model.addAttribute("userDetail", userService.userDetail(userDTO));
        return "/user/delete";
    }

    @PostMapping("delete")
    public String deleteUser(UserDTO userDTO, HttpSession session, RedirectAttributes rttr, Locale locale){
        userDTO.setUserId((String)session.getAttribute("userId"));
        userService.deleteUser(userDTO);
        rttr.addFlashAttribute("deleSuccessMessage", messageSource.getMessage("deleteUser", null, locale));
        session.invalidate();
        return "redirect:/main";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session, RedirectAttributes rttr, Locale locale){

        session.setAttribute("userId", "value");
        String userId = (String) session.getAttribute("userId");

        session.removeAttribute("userId");
        session.invalidate();
        rttr.addFlashAttribute("logoutMessage", messageSource.getMessage("logout", null, locale));
        return "redirect:/main";
    }


}
