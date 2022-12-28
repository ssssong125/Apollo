package com.b4.apollo.common.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @GetMapping(value = {"/","/main"})  //main으로 들어오거나 /로들어왔을 때 메인 페이지가 뜸
    public String main(){
        return "main/main";
    }

    //post 방식 요청 -> main forwarding -> getMapping에 다시 redirect되어 main이 뜰수  있도록 ??? 이게 무슨 말일까?/
    @PostMapping(value = "/")
    public String redirectMain(){
        return "redirect:/";
    }


    
}
