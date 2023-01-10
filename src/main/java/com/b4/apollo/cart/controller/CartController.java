package com.b4.apollo.cart.controller;

import com.b4.apollo.cart.model.dto.CartDTO;
import com.b4.apollo.cart.model.service.CartService;
import com.b4.apollo.user.model.dto.UserDTO;
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

    HashMap<String, String> parameter = new HashMap<>();
//    String userId = userId;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    };

    /**
     * @MethodName : trolley
     * @작성일 : 2022. 12. 28.
     * @작성자 : 김수용
     * @Method 설명 : GetMapping 방식으로 trolley 값을 받게되면 trolley 페이지로 넘겨줌, null값 처리를 위해 Integer 자료형 사용
     */
//    @GetMapping("trolley")
    @GetMapping(value = {"trolley","cart/trolley"})
    public ModelAndView trolley(ModelAndView mv) {

        parameter.put("userId", "user01");

        List<CartDTO> cartList = cartService.getCartList(parameter);
        mv.addObject("cartList", cartList);

        UserDTO user = cartService.getUserDetail(parameter);
        mv.addObject("user", user);

        // 합산 가격
//        int totalPrice = 0;
//
//        for(CartDTO cart : cartList) {
//            totalPrice += cart.getProductInfo().getProductPrice() * cart.getProductCount();
//        }
//
//        mv.addObject("totalPrice", totalPrice);

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
    @PostMapping("trolley")
    public Model trolleyResult(Model model, Integer cartNo, Integer count) {

        parameter.put("userId", "user01");

        // null값도 받기 위해 Integer 사용
        if(cartNo != null && count != null) {

            if(count >= 1) {

                HashMap<String, Integer> parameter = new HashMap<>();
                parameter.put("cartNo", cartNo);
                parameter.put("count", count);

                cartService.updateProductCount(parameter);

            } else cartService.deleteProductInCart(cartNo);

        }

        List<CartDTO> cartList = cartService.getCartList(parameter);
        model.addAttribute("cartList", cartList);

        UserDTO user = cartService.getUserDetail(parameter);
        model.addAttribute("user", user);

        // 합산 가격
//        int totalPrice = 0;
//
//        for(CartDTO cart : cartList) {
//            totalPrice += cart.getProductInfo().getProductPrice() * cart.getProductInfo().getProductQty();
//        }
//
//        model.addAttribute("totalPrice", totalPrice);

        return model;
    }

    /**
     * @MethodName : order
     * @작성일 : 2022. 12. 28.
     * @작성자 : 김수용
     * @Method 설명 : GetMapping방식으로 order 값을 받게되면 order 페이지로 넘겨줌
     */
    @GetMapping("order")
//    @GetMapping(value = {"order","cart/order"})
    public ModelAndView order(ModelAndView mv, String userId) {

//        parameter.put("userId", userId);
        parameter.put("userId", "user01");

        UserDTO user = cartService.getUserDetail(parameter);

        mv.addObject("user", user);
        mv.setViewName("cart/order");

        return mv;

//        List<CartDTO> cartList = cartService.getCartList(parameter);
//
//        mv.addObject("cartList", cartList);
//
//        // 합산 가격
//        int totalPrice = 0;
//
//        for(CartDTO cart : cartList) {
//            totalPrice += cart.getProductInfo().getProductPrice() * cart.getProductCount();
//        }
//
//        mv.addObject("totalPrice", totalPrice);
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
