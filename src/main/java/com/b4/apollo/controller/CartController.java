package com.b4.apollo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("cart")
public class CartController {

    @GetMapping("trolley")
    public ModelAndView trolley(ModelAndView mv) {

        mv.setViewName("cart/trolley");

        return mv;
    }

    @GetMapping("order")
    public ModelAndView order(ModelAndView mv) {

        mv.setViewName("cart/order");

        return mv;
    }

    @GetMapping("payment")
    public ModelAndView payment(ModelAndView mv) {

        mv.setViewName("cart/payment");

        return mv;
    }

    @GetMapping("success")
    public ModelAndView success(ModelAndView mv) {

        mv.setViewName("cart/success");

        return mv;
    }

    @GetMapping("fail")
    public ModelAndView fail(ModelAndView mv) {

        mv.setViewName("cart/fail");

        return mv;
    }

//    <button onclick="location.href='/cart/trolley'">장바구니 조회</button>
//    <button onclick="location.href='/cart/order'">주문 정보 입력</button>
//    <button onclick="location.href='/cart/payment'">결제</button>
//    <button onclick="location.href='/cart/success'">결제 성공</button>
//    <button onclick="location.href='/cart/fail'">결제 실패</button>
}
