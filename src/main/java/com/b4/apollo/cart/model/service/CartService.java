package com.b4.apollo.cart.model.service;

import com.b4.apollo.cart.model.dto.OrderDTO;
import com.b4.apollo.cart.model.dto.PaymentDTO;
import com.b4.apollo.product.model.dto.ProductDTO;

import java.util.List;
import java.util.Map;

/**
 @FileName : Cart
 @Project : Apollo
 @Date : 2022. 12. 28.
 @작성자 : 김수용
 @프로그램 설명 : 주문 관련 요청을 처리할 Service interface
 */
public interface CartService {


    /**
     * @MethodName : getCartList
     * @작성일 : 2022. 12. 30.
     * @작성자 : 김수용
     * @Method 설명 : 장바구니 페이지에 출력할 장바구니 품목들을 불러올 구현체의 인터페이스
     */
    List<ProductDTO> getCartList(Map<String, String> userId);

    /**
     * @MethodName : getPaymentDetail
     * @작성일 : 2022. 12. 30.
     * @작성자 : 김수용
     * @Method 설명 : 결제 정보를 불러올 구현체의 인터페이스
     */
    PaymentDTO getPaymentDetail(Map<String, String> userId);

    /**
     * @MethodName : getOrderDetail
     * @작성일 : 2022. 12. 30.
     * @작성자 : 김수용
     * @Method 설명 : 주문 정보를 불러올 구현체의 인터페이스
     */
    OrderDTO getOrderDetail(Map<String, Integer> paymentNo);

    /**
     * @MethodName : addCart
     * @작성일 : 2023. 01. 01.
     * @작성자 : 김수용
     * @Method 설명 : 장바구니에 상품을 추가하는 기능
     */
    boolean addCart(Map<String, Integer> product) throws Exception;
}
