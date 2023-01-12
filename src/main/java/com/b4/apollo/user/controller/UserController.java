package com.b4.apollo.user.controller;


import com.b4.apollo.user.model.dto.UserDTO;
import com.b4.apollo.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
    private final UserDTO userDTO;


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


    @GetMapping("login")
    public String userLoginForm(){

        return "/user/login";
    }

    @PostMapping("/login")
    @ResponseBody
    public ModelAndView loginUser(ModelAndView mv, UserDTO userDTO, HttpSession session, RedirectAttributes rttr, Locale locale) throws Exception{

        boolean result = userService.loginUser(userDTO, session);
        String msg="";

        if(result){
            mv.addObject("userId", 1);
            session.setAttribute("userId", userDTO.getUserId());
//            mv.setViewName("redirect:/user/mypage");
//            msg = "<script>location.href='/user/mypage'</script>";
        }else {
            mv.addObject("userId", 0);
            rttr.addFlashAttribute("loginFailMsg", messageSource.getMessage("loginFail", null, locale));
//            mv.setViewName("redirect:/user/login");
//            msg = "<script>alert('login_fail. 다시 로그인해주세요');location.href='../login'<script>";
        }
        return mv;
    }


    @GetMapping(value = {"/mypage","/header"})
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

}
