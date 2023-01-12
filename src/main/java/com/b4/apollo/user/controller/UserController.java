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
@RequestMapping(value={"user", "fragments"})
public class UserController {

    private final UserService userService;
    private final MessageSource messageSource;
    private final UserDTO userDTO;


//    @GetMapping("userList")
//    public ModelAndView findAllUser(ModelAndView mv){
//        List<UserDTO> userList = userService.findAllUser();
//        userList.stream().forEach(user -> System.out.println("user = " + user));
//        mv.addObject("userList", userList);
//        mv.setViewName("admin/userList");
//        return mv;
//    }
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

//    @GetMapping("/login")
//    public String userLoginForm(){
//        return "/user/login";
//    }

    @GetMapping("login")
    public String userLoginForm(){

        return "/user/login";
    }
//    @GetMapping("/mypage")
//    public void userPage(){
//
//    }
//    @PostMapping("login")
//    public ModelAndView login(UserDTO userDTO, HttpSession http, ModelAndView mv, RedirectAttributes rttr, Locale locale){
//        try {
//            UserDTO loginUser = userService.loginUser(userDTO);
//            http.setAttribute("loginUser", loginUser);
//            mv.setViewName( "redirect:/user/mypage");
//        } catch (Exception e) {
//
//            e.printStackTrace();
//            rttr.addFlashAttribute("loginFailMsg", messageSource.getMessage("loginFail", null, locale));
//            mv.setViewName("redirect:/user/login");
//
//        }
//
//        return mv;
//    }

    //    @PostMapping("login")
//    public String Login(UserDTO userDTO, HttpSession session, RedirectAttributes rttr, Locale locale) {
//
//        UserDTO loginUser = userService.loginUser(userDTO);
//        System.out.println(loginUser);
//        if(loginUser!=null) {
//            session.setAttribute("loginUser", loginUser);
//            session.setAttribute("userId", loginUser.getUserId());
//            return "redirect:/user/mypage";
//        }else{
//            rttr.addFlashAttribute("loginFailMsg", messageSource.getMessage("loginFail", null, locale));
//            return "redirect:/user/login";
//        }
//    }
    @PostMapping("/login")
    @ResponseBody
    public String loginUser(UserDTO userDTO, HttpSession session, Model model) throws Exception{

        boolean result = userService.loginUser(userDTO, session);
        String msg="";

        if(result == true){
            session.setAttribute("userId", userDTO.getUserId());
            msg = "<script>location.href='/user/mypage'</script>";
        }else {
            msg = "<script>alert('login_fail. 다시 로그인해주세요');location.href='/user/login'<script>";
        }

        return msg;
    }

    @GetMapping("/mypage")
    public String userpage(UserDTO userDTO, HttpSession session, Model model){
        String userId = (String)session.getAttribute("userId");
        userDTO.setUserId(userId);
        userService.userDetail(userDTO);
        model.addAttribute("userDetail", userService.userDetail(userDTO));

        return "user/mypage";
    }

//    @GetMapping("/mypage")
//    public String userPage(){
//        return "/user/mypage";
//    }


//    @GetMapping("update")
//    public String updateForm(HttpSession http, Model model){
//        Long id = (Long) http.getAttribute("userId");
//        UserDTO userDTO = userService.userDetail(new UserDTO());
//        model.addAttribute("updateUser", userDTO);
//        return "/user/update";
//    }
//
//    @PostMapping("update")
//    public String updateUser(@ModelAttribute UserDTO userDTO){
//        userService.updateUser(userDTO);
//        return "redirect:/user/mypage"+userDTO.getUserId();
//    }

//    @PostMapping("/update")
//    public ModelAndView updateUser(ModelAndView mv, UserDTO userDTO, String userId, RedirectAttributes rttr, Locale locale) throws Exception{
//        System.out.println(userDTO);
//        //updateDTO.setUserActive();
//        //QuestionDTO questionDTO = this.boardService.selectBoard(boardNo);
//       // UserDTO userDTO =
//        //가져와야함 그 회원정보
////        Login(userDTO).loginUser
////        System.out.println(userDTO);
////        updateDTO.setUserActive("Y");
////        updateDTO.setUserId(userDTO.getUserId());
////        updateDTO.setUserEntdate(userDTO.getUserEntdate());
////        updateDTO.setUserNo(userDTO.getUserNo());
////        updateDTO.setPoint(userDTO.getPoint());
////        updateDTO.setUserRole(userDTO.getUserRole());
//        userService.updateUser(userDTO);
//        mv.setViewName("redirect:/user/mypage");
//        rttr.addFlashAttribute("updSuccessMessage", messageSource.getMessage("updateUser", null, locale));
//        return mv;
//    }

    @GetMapping("update")
    public String userDetail(UserDTO userDTO, HttpSession session, Model model){
        String userId = (String)session.getAttribute("userId");
        userDTO.setUserId(userId);
        UserDTO userDetail = userService.userDetail(userDTO);
        model.addAttribute("userDetail", userDetail);

        return "user/update";
    }

    @PostMapping("update")
    public String userUpdate(UserDTO userDetail, Model model){
        userService.updateUser(userDetail);

        model.addAttribute("userDetail", userDetail);
        return "redirect:/user/mypage";
    }


//    @GetMapping("delete")
//    public String deletepage(){
//        return "/user/delete";
//    }

//    @PostMapping("delete")
//    public ModelAndView deleteUser(ModelAndView mv, String userId, RedirectAttributes rttr, Locale locale) throws Exception {
//        userService.deleteUser(userId);
//        mv.setViewName("redirect:/main");
//        rttr.addFlashAttribute("deleSuccessMessage", messageSource.getMessage("deleteUser", null, locale));
//        return mv;
//    }



}
