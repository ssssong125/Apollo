package com.b4.apollo.cart.model.dao;

import com.b4.apollo.cart.model.dto.CartDTO;
import com.b4.apollo.cart.model.dto.OrderDTO;
import com.b4.apollo.cart.model.dto.PaymentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 @FileName : CartDAO.java
 @Project : Apollo
 @Date : 2022. 12. 28.
 @작성자 : 김수용
 @프로그램 설명 : 서버 구동 프로그램
 */
@Mapper
public interface CartMapper {

    /**
     * @MethodName : getCartList
     * @작성일 : 2022. 12. 30.
     * @작성자 : 김수용
     * @Method 설명 : CartService에서 호출되어 장바구니 품목을 조회할 쿼리문을 실행시킴
     */
    List<CartDTO> getCartList(Map<String, Object> parameter);

    /**
     * @MethodName : getOrder
     * @작성일 : 2022. 12. 30.
     * @작성자 : 김수용
     * @Method 설명 : CartService에서 호출되어 오더정보를 조회할 쿼리문을 실행시킴
     */
    OrderDTO getOrderDetail(Map<String, Integer> parameter);

    /**
     * @MethodName : getPaymentDetail
     * @작성일 : 2022. 12. 30.
     * @작성자 : 김수용
     * @Method 설명 : CartService에서 호출되어 결제정보를 조회할 쿼리문을 실행시킴
     */
    PaymentDTO getPaymentDetail(HashMap<String, Integer> parameter);

    /**
     * @MethodName : addCart
     * @작성일 : 2023. 01. 01.
     * @작성자 : 김수용
     * @Method 설명 : CartService에서 호출되어 품목을 장바구니에 추가하는 쿼리문을 실행시킴
     */
    int addCart(HashMap<String, String> parameter);

    /**
     * @MethodName : increaseProduct
     * @작성일 : 2023. 01. 02.
     * @작성자 : 김수용
     * @Method 설명 : CartService에서 호출되어 장바구니 품목의 구매수량을 증가 시킴
     */
    int increaseProduct(int cartNo);

    /**
     * @MethodName : increaseProduct
     * @작성일 : 2023. 01. 03.
     * @작성자 : 김수용
     * @Method 설명 : CartService에서 호출되어 장바구니 품목의 구매수량을 감소 시킴
     */
    int decreaseProduct(int cartNo);

    /**
     * @MethodName : deleteProduct
     * @작성일 : 2023. 01. 03.
     * @작성자 : 김수용
     * @Method 설명 : CartService에서 호출되어 장바구니에서 품목을 제거함
     */
    int deleteProduct(int cartNo);


    /**
     * @MethodName : order
     * @작성일 : 2023. 01. 03.
     * @작성자 : 김수용
     * @Method 설명 : CartService에서 호출되어 주문시 필요한 주소지를 입력받음
     */
//    int order(HashMap<String, String> parameter);
}
