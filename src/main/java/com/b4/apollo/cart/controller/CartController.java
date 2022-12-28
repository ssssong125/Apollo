package com.b4.apollo.cart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 @FileName : CartController.java

 @Project : Apollo

 @Date : 2022. 12. 28.

 @작성자 : 김수용

 @프로그램 설명 : 어플리케이션 컨텍스트 리소스의 위치 혹은 컨텍스트를 로드할때 사용되는 클래스의 컴포넌트를 선언
 */
@Controller
@RequestMapping("cart")
public class CartController {


    /**
     * @MethodName : trolley
     * @작성일 : 2022. 12. 28.
     * @작성자 : 김수용
     * @Method 설명 : GetMapping방식으로 trolley 값을 받게되면 trolley 페이지로 넘겨줌
     */
    @GetMapping("trolley")
    public ModelAndView trolley(ModelAndView mv) {

        mv.setViewName("cart/trolley");

        return mv;
    }

    /**
     * @MethodName : order
     * @작성일 : 2022. 12. 28.
     * @작성자 : 김수용
     * @Method 설명 : GetMapping방식으로 order 값을 받게되면 order 페이지로 넘겨줌
     */
    @GetMapping("order")
    public ModelAndView order(ModelAndView mv) {

        mv.setViewName("cart/order");

        return mv;
    }

    /**
     * @MethodName : payment
     * @작성일 : 2022. 12. 28.
     * @작성자 : 김수용
     * @Method 설명 : GetMapping방식으로 payment 값을 받게되면 payment 페이지로 넘겨줌
     */
    @GetMapping("payment")
    public ModelAndView payment(ModelAndView mv) {

        mv.setViewName("cart/payment");

        return mv;
    }

    /**
     * @MethodName : success
     * @작성일 : 2022. 12. 28.
     * @작성자 : 김수용
     * @Method 설명 : GetMapping방식으로 success 값을 받게되면 success 페이지로 넘겨줌
     */
    @GetMapping("success")
    public ModelAndView success(ModelAndView mv) {

        mv.setViewName("cart/success");

        return mv;
    }

    /**
     * @MethodName : fail
     * @작성일 : 2022. 12. 28.
     * @작성자 : 김수용
     * @Method 설명 : GetMapping방식으로 fail 값을 받게되면 fail 페이지로 넘겨줌
     */
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
