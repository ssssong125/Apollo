package com.b4.apollo.cart.controller;

import com.b4.apollo.cart.model.dto.CartDTO;
import com.b4.apollo.cart.model.dto.PaymentDTO;
import com.b4.apollo.cart.model.service.CartService;
import com.b4.apollo.user.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    @GetMapping(value = {"trolley","cart/trolley"})
    public ModelAndView trolley(ModelAndView mv, PaymentDTO paymentDTO) {

        mv.addObject("paymentDTO", paymentDTO);

        parameter.put("userId", "user01");
//        getSession httpsession
//        parameter.put("userId", userId);

        List<CartDTO> cartList = cartService.getCartList(parameter);
        mv.addObject("cartList", cartList);

        UserDTO user = cartService.getUserDetail(parameter);
        mv.addObject("user", user);

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
    public Model trolleyResult(Model model, Integer cartNo, Integer count) { // null값도 받기 위해 Integer 사용

        parameter.put("userId", "user01");
//        parameter.put("userId", userId);

        if(cartNo != null && count != null) {

            if(count >= 1) {

                HashMap<String, Integer> parameter = new HashMap<>();
                parameter.put("cartNo", cartNo);
                parameter.put("count", count);

                cartService.updateProductCount(parameter);

            } else if(count < 1) cartService.deleteProductInCart(cartNo);

        }

        List<CartDTO> cartList = cartService.getCartList(parameter);
        model.addAttribute("cartList", cartList);

        UserDTO user = cartService.getUserDetail(parameter);
        model.addAttribute("user", user);

        return model;
    }

    /**
     * @MethodName : order
     * @작성일 : 2022. 12. 28.
     * @작성자 : 김수용
     * @Method 설명 : GetMapping방식으로 order 값을 받게되면 order 페이지로 넘겨줌
     */
    @GetMapping(value = {"order","cart/order"})
    public ModelAndView order(ModelAndView mv, PaymentDTO paymentDTO) {

//        parameter.put("userId", userId);
        parameter.put("userId", "user01");

        UserDTO user = cartService.getUserDetail(parameter);
        mv.addObject("user", user);

        mv.addObject("paymentDTO", paymentDTO);

        mv.setViewName("cart/order");

        return mv;
    }

    /**
     * @MethodName : orderResult
     * @작성일 : 2023. 01. 11.
     * @작성자 : 김수용
     * @Method 설명 : PostMapping 방식으로 order 페이지에 출력될 값을 반환해줌
     */
    @ResponseBody
    @PostMapping("order")
    public Model orderResult(Model model, PaymentDTO paymentDTO) {
//        @RequestBody 더 이상 필요 x -> Content type 'application/x-www-form-urlencoded;charset=UTF-8' not supported 유발함
//    public ModelAndView orderResult(ModelAndView mv, @ModelAttribute("paymentDTO") PaymentDTO paymentDTO) {

        parameter.put("userId", "user01");
//        parameter.put("userId", userId);

        model.addAttribute("paymentDTO", paymentDTO);

        UserDTO user = cartService.getUserDetail(parameter);
        model.addAttribute("user", user);

        return model;
    }

    /**
     * @MethodName : payment
     * @작성일 : 2022. 12. 28.
     * @작성자 : 김수용
     * @Method 설명 : GetMapping방식으로 payment 값을 받게되면 payment 페이지로 넘겨줌
     */
    @GetMapping("payment")
    public ModelAndView payment(ModelAndView mv, PaymentDTO paymentDTO) {

        mv.addObject("paymentDTO", paymentDTO);

        mv.setViewName("cart/payment");

        return mv;
    }

    /**
     * @MethodName : paymentResult
     * @작성일 : 2023. 01. 11.
     * @작성자 : 김수용
     * @Method 설명 : PostMapping 방식으로 payment 페이지에 출력될 값을 반환해줌
     */
    @ResponseBody
    @PostMapping("payment")
    public Model paymentResult(Model model, PaymentDTO paymentDTO) {

        parameter.put("userId", "user01");

        model.addAttribute("paymentDTO", paymentDTO);

        return model;
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
