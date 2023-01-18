package com.b4.apollo.cart.controller;

import com.b4.apollo.cart.model.dto.CartDTO;
import com.b4.apollo.cart.model.dto.PaymentDTO;
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

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    private final CartService cartService;

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
    public ModelAndView trolley(HttpSession session, ModelAndView mv, PaymentDTO paymentDTO) {

        String userId = (String) session.getAttribute("userId");

        System.out.println(userId);

        if (userId == null) {

            mv.setViewName("redirect:/user/login");

        } else {
            mv.addObject("paymentDTO", paymentDTO);

            HashMap<String, String> parameter = new HashMap<>();
            parameter.put("userId", userId);

            List<CartDTO> cartList = cartService.getCartList(userId);
            mv.addObject("cartList", cartList);

            List<CartDTO> checkedCartList = cartService.getCheckedCartList(parameter);
            mv.addObject("checkedCartList", checkedCartList);

            UserDTO user = cartService.getUserDetail(parameter);
            mv.addObject("user", user);

            mv.setViewName("cart/trolley");
        }

        return mv;
    }
    /**
     * @MethodName : trolleyResultCount
     * @작성일 : 2023. 01. 06.
     * @작성자 : 김수용
     * @Method 설명 : PostMapping 방식으로 trolley 페이지에 출력될 값을 반환해줌
     */
    @ResponseBody
    @PostMapping("trolley-count")
    public Model trolleyResultCount(HttpSession session, Model model, Integer cartNo, Integer count) { // null값도 받기 위해 Integer 사용

        String userId = (String) session.getAttribute("userId");

        HashMap<String, String> parameter = new HashMap<>();
        parameter.put("userId", userId);

        if(cartNo != null && count != null) {

            if(count >= 1) {

                HashMap<String, Integer> cartParameter = new HashMap<>();
                cartParameter.put("cartNo", cartNo);
                cartParameter.put("count", count);

                cartService.updateProductCount(cartParameter);

            } else if(count < 1) cartService.deleteProductInCart(cartNo);
        }
        List<CartDTO> cartList = cartService.getCartList(userId);
        model.addAttribute("cartList", cartList);

        UserDTO user = cartService.getUserDetail(parameter);
        model.addAttribute("user", user);

        return model;
    }
    /**
     * @MethodName : trolleyResultCheck
     * @작성일 : 2023. 01. 13.
     * @작성자 : 김수용
     * @Method 설명 : PostMapping 방식으로 trolley 페이지에 출력될 값을 반환해줌 체크 여부 수정
     */
    @ResponseBody
    @PostMapping("trolley-check")
    public Model trolleyResultCheck(HttpSession session, Model model, Integer cartNo, char check) { // null값도 받기 위해 Integer 사용

        String userId = (String) session.getAttribute("userId");

        HashMap<String, String> parameter = new HashMap<>();
        parameter.put("userId", userId);

        HashMap<String, Object> checkParameter = new HashMap<>();
        checkParameter.put("cartNo", cartNo);
        checkParameter.put("check", check);

        cartService.updateCheckStatus(checkParameter);

        List<CartDTO> cartList = cartService.getCartList(userId);
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
    public ModelAndView order(HttpSession session, ModelAndView mv, PaymentDTO paymentDTO, ArrayList<Integer> purchaseList) {

        String userId = (String) session.getAttribute("userId");

        if (userId == null) {
            mv.setViewName("redirect:/user/login");
        } else {
            HashMap<String, String> parameter = new HashMap<>();
            parameter.put("userId", userId);

            UserDTO user = cartService.getUserDetail(parameter);
            mv.addObject("user", user);

            mv.addObject("paymentDTO", paymentDTO);

            mv.addObject("purchaseList", purchaseList);

            mv.setViewName("cart/order");
        }
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
    public Model orderResult(HttpSession session, Model model, PaymentDTO paymentDTO, ArrayList<Integer> purchaseList) {

        String userId = (String) session.getAttribute("userId");

        HashMap<String, String> parameter = new HashMap<>();
        parameter.put("userId", userId);

        model.addAttribute("paymentDTO", paymentDTO);

        model.addAttribute("purchaseList", purchaseList);

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
    public ModelAndView payment(HttpSession session, ModelAndView mv, PaymentDTO paymentDTO) {

        String userId = (String) session.getAttribute("userId");

        if (userId == null) {
            mv.setViewName("redirect:/user/login");
        } else {
            HashMap<String, String> parameter = new HashMap<>();
            parameter.put("userId", userId);

            UserDTO user = cartService.getUserDetail(parameter);
            mv.addObject("user", user);

            List<CartDTO> checkedCartList = cartService.getCheckedCartList(parameter);
            mv.addObject("checkedCartList", checkedCartList);

            mv.addObject("paymentDTO", paymentDTO);

            mv.setViewName("cart/payment");
        }
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
    public Model paymentResult(HttpSession session, Model model, PaymentDTO paymentDTO) {

        String userId = (String) session.getAttribute("userId");

        HashMap<String, String> parameter = new HashMap<>();
        parameter.put("userId", userId);

        UserDTO user = cartService.getUserDetail(parameter);
        model.addAttribute("user", user);

        List<CartDTO> checkedCartList = cartService.getCheckedCartList(parameter);
        model.addAttribute("checkedCartList", checkedCartList);

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
    public ModelAndView success(HttpSession session, ModelAndView mv, PaymentDTO paymentDTO) {

        String userId = (String) session.getAttribute("userId");

        if (userId == null) {
            mv.setViewName("redirect:/user/login");
        } else {
            mv.addObject("paymentDTO", paymentDTO);

            mv.setViewName("cart/success");
        }
        return mv;
    }
    /**
     * @MethodName : successResult
     * @작성일 : 2023. 01. 14.
     * @작성자 : 김수용
     * @Method 설명 : PostMapping 방식으로 success 페이지에 출력될 값을 반환해줌
     */
    @ResponseBody
    @PostMapping("success")
    public ModelAndView successResult(HttpSession session, ModelAndView mv, PaymentDTO paymentDTO) {

        String userId = (String) session.getAttribute("userId");

        if (userId == null) {
            mv.setViewName("redirect:/user/login");
        } else {
            HashMap<String, String> parameter = new HashMap<>();
            parameter.put("userId", userId);

            mv.setViewName("cart/success");

            List<CartDTO> checkedCartList = cartService.getCheckedCartList(parameter);

            if (checkedCartList.size() < 1) {
                mv.addObject("msg", "에러 :  선택된 상품이 없습니다.");
                mv.setViewName("cart/fail");
            } else {
                /*상품 재고 수정*/
                HashMap<String, Integer> productParameter = new HashMap<>();

                for (CartDTO checkedCart : checkedCartList) {
                    productParameter.clear();
                    productParameter.put("productCount", checkedCart.getProductCount());
                    productParameter.put("productNo", checkedCart.getProductInfo().getProductNo());

                    if (cartService.updateProductQty(productParameter) < 1) {
                        mv.addObject("msg", "에러 : 상품 재고 부족");
                        mv.setViewName("cart/fail");
                    }
                }
                /*결제 테이블에 등록*/
                if (cartService.payment(paymentDTO) < 1) {
                    mv.addObject("msg", "에러 : 상품 결제 에러");
                    mv.setViewName("cart/fail");
                }
                /*주문 테이블에 등록*/
                cartService.order(checkedCartList);
                /*구매상태 Y로 전환(카트 테이블에서 삭제)*/
                for (CartDTO checkedCart : checkedCartList) {
                    cartService.buyCartItem(checkedCart.getCartNo());
                }
                mv.addObject("paymentNo", cartService.getPaymentNo(checkedCartList.get(0).getCartNo()));
            }
        }
        return mv;
    }
    /**
     * @MethodName : fail
     * @작성일 : 2022. 12. 28.
     * @작성자 : 김수용
     * @Method 설명 : GetMapping방식으로 fail 값을 받게되면 fail 페이지로 넘겨줌
     */
    @GetMapping("fail")
    public ModelAndView fail(HttpSession session, ModelAndView mv) {

        String userId = (String) session.getAttribute("userId");

        if (userId == null) {

            mv.setViewName("redirect:/user/login");

        } else {

            mv.setViewName("cart/fail");
        }
        return mv;
    }
    /**
     * @MethodName : addToCart
     * @작성일 : 2023. 01. 16.
     * @작성자 : 김수용
     * @Method 설명 : PostMapping방식으로 상품 추가 요청을 받아서 장바구니에 등록
     */
    @ResponseBody
    @PostMapping("addToCart")
    public void addToCart(HttpSession session, int productNo, int count) {

        String userId = (String) session.getAttribute("userId");

        HashMap<String, Object> parameter = new HashMap<>();

        parameter.put("userId",  userId);
        parameter.put("productNo", productNo);
        parameter.put("count", count);

        cartService.addProductToCart(parameter);
    }
    /**
     * @MethodName : headerBadge
     * @작성일 : 2023. 01. 17.
     * @작성자 : 김수용
     * @Method 설명 : GetMapping방식으로 현재 장바구니에 담긴 상품수를 헤더 카트 아이콘 옆에 뱃지로 표현
     */
    @ResponseBody
    @PostMapping("/headerBadge")
    public Model headerBadge(HttpSession session, Model model){

        String userId = (String) session.getAttribute("userId");

        if (userId != null){
            List<CartDTO> cartList = cartService.getCartList(userId);
            model.addAttribute("cartList", cartList);
        }
        return model;
    }
}
