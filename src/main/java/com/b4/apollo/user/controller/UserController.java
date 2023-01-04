package com.b4.apollo.user.controller;


import com.b4.apollo.user.model.dto.UserDTO;
import com.b4.apollo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("signup")
    public void signupForm(){

    }

    @PostMapping("signup")
    public ModelAndView singup(ModelAndView mv, UserDTO userDTO, RedirectAttributes rttr) throws Exception {
        userService.insertUser(userDTO);
        mv.setViewName("redirect:user/login");
        rttr.addFlashAttribute("successMessage","회원가입되었습니다,");
        return mv;
    }

    @RequestMapping(value = "idCheck", method = RequestMethod.GET)
    @ResponseBody
    public int idCheck(String id){
        int result = userService.idCheck(id);
        return result;
    }

    @GetMapping("login")
    public void userLoginForm(){

    }

    @GetMapping("mypage")
    public void userPage(){

    }

    @GetMapping("contact")
    public void contact(){

    }

}
