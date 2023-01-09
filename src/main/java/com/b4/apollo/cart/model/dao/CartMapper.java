package com.b4.apollo.cart.model.dao;

import com.b4.apollo.cart.model.dto.CartDTO;
import com.b4.apollo.cart.model.dto.OrderDTO;
import com.b4.apollo.cart.model.dto.PaymentDTO;
import com.b4.apollo.user.model.dto.UserDTO;
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
     * @MethodName : addCart
     * @작성일 : 2023. 01. 01.
     * @작성자 : 김수용
     * @Method 설명 : CartService에서 호출되어 품목을 장바구니에 추가하는 쿼리문을 실행시킴
     */
    int addProductToCart(HashMap<String, Object> parameter);

    /**
     * @MethodName : getCartList
     * @작성일 : 2022. 12. 30.
     * @작성자 : 김수용
     * @Method 설명 : CartService에서 호출되어 장바구니 품목을 조회할 쿼리문을 실행시킴
     */
    List<CartDTO> getCartList(Map<String, String> parameter);

    /**
     * @MethodName : updateProductCount
     * @작성일 : 2023. 01. 05.
     * @작성자 : 김수용
     * @Method 설명 : CartService에서 호출되어 장바구니 품목의 구매수량 수정함
     */
    int updateProductCount(HashMap<String, Integer> parameter);

    /**
     * @MethodName : deleteProduct
     * @작성일 : 2023. 01. 03.
     * @작성자 : 김수용
     * @Method 설명 : CartService에서 호출되어 장바구니에서 품목을 제거함
     */
    int deleteProductInCart(Integer cartNo);

    /**
     * @MethodName : getUserDetail
     * @작성일 : 2023. 01. 09.
     * @작성자 : 김수용
     * @Method 설명 : CartService에서 호출되어 유저 정보를 조회할 쿼리문을 실행시킴
     */
    UserDTO getUserDetail(Map<String, String> parameter);

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
     * @MethodName : order
     * @작성일 : 2023. 01. 03.
     * @작성자 : 김수용
     * @Method 설명 : CartService에서 호출되어 주문시 필요한 주소지를 입력받음
     */
//    int order(HashMap<String, String> parameter);
}
