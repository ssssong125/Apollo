package com.b4.apollo.cart.model.service;

import com.b4.apollo.cart.model.dao.CartDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 @FileName : CartServiceImpl
 @Project : Apollo
 @Date : 2022. 12. 31.
 @작성자 : 김수용
 @프로그램 설명 : 주문 관련 요청을 처리할 Service 구현체
 */
public class CartServiceImpl implements CartService {

    private final CartDAO cartDAO;

    /**
     * @MethodName : CartServiceImpl
     * @작성일 : 2023. 01. 01.
     * @작성자 : 김수용
     * @Method 설명 : 기본 생성자
     */
    @Autowired
    public CartServiceImpl(CartDAO cartDAO) {
        this.cartDAO = cartDAO;
    }

    /**
     * @MethodName : addCart
     * @작성일 : 2023. 01. 01.
     * @작성자 : 김수용
     * @Method 설명 : 장바구니에 상품을 추가하는 기능 구현체
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addCart(Map<String, Integer> product) throws Exception {

        int result = cartDAO.addCart(product);

        if(result <= 0) {

            throw new Exception("장바구니 담기 실패");
        }


        return result > 0? true : false;
    }
}

//@Transactional(rollbackFor = Exception.class) // 오류 발생시 롤백 // 메소드에 붙이기
