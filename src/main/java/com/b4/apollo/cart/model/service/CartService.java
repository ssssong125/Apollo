package com.b4.apollo.cart.model.service;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 @FileName : Cart
 @Project : Apollo
 @Date : 2022. 12. 28.
 @작성자 : 김수용
 @프로그램 설명 : 주문 관련 요청을 처리할 Service 인터페이스
 */
@Service
public interface CartService {

    /**
     * @MethodName : addCart
     * @작성일 : 2023. 01. 01.
     * @작성자 : 김수용
     * @Method 설명 : 장바구니에 상품을 추가하는 기능
     */
    boolean addCart(Map<String, Integer> product) throws Exception;
}
