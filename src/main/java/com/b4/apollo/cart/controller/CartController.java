package com.b4.apollo.cart.controller;

import com.b4.apollo.cart.model.dto.CartDTO;
import com.b4.apollo.cart.model.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

/**
 @FileName : CartController.java
 @Project : Apollo
 @Date : 2022. 12. 28.
 @작성자 : 김수용
 @프로그램 설명 : 어플리케이션 컨텍스트 리소스의 위치 혹은 컨텍스트를 로드할때 사용되는 클래스의 컴포넌트를 선언
 */
//@Controller
//@RestController
@Controller
@RequestMapping("cart")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    };

    /**
     * @MethodName : trolley
     * @작성일 : 2022. 12. 28.
     * @작성자 : 김수용
     * @Method 설명 : GetMapping 방식으로 trolley 값을 받게되면 trolley 페이지로 넘겨줌
     */
    @GetMapping("trolley")
    public ModelAndView trolley(ModelAndView mv) {

        HashMap<String, String> parameter = new HashMap<>();
        parameter.put("userId", "user01");

        List<CartDTO> cartList = cartService.getCartList(parameter);

        mv.addObject("cartList", cartList);

        // 합산 가격
        int totalPrice = 0;

        for(CartDTO cart : cartList) {
            totalPrice += cart.getProductInfo().getProductPrice() * cart.getProductInfo().getProductQty();
        }

        mv.addObject("totalPrice", totalPrice);

        // 프로덕트 맵핑
        mv.setViewName("cart/trolley");

        return mv;
    }

    /**
     * @MethodName : trolleyResult
     * @작성일 : 2023. 01. 06.
     * @작성자 : 김수용
     * @Method 설명 : PostMapping 방식으로 trolley 페이지에 출력될 값을 반환해줌
     */
    @ResponseBody
    @PostMapping("trolley-result")
    public Model trolleyResult(Model model) {

        HashMap<String, String> parameter = new HashMap<>();
        parameter.put("userId", "user01");

        List<CartDTO> cartList = cartService.getCartList(parameter);

        model.addAttribute("cartList", cartList);

        // 합산 가격
        int totalPrice = 0;

        for(CartDTO cart : cartList) {
            totalPrice += cart.getProductInfo().getProductPrice() * cart.getProductInfo().getProductQty();
        }

        model.addAttribute("totalPrice", totalPrice);

        return model;
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

//        logger.info(name);

//    <button onclick="location.href='/cart/trolley'">장바구니 조회</button>
//    <button onclick="location.href='/cart/order'">주문 정보 입력</button>
//    <button onclick="location.href='/cart/payment'">결제</button>
//    <button onclick="location.href='/cart/success'">결제 성공</button>
//    <button onclick="location.href='/cart/fail'">결제 실패</button>
}
