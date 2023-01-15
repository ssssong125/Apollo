package com.b4.apollo.cart.model.service;


import com.b4.apollo.cart.model.dto.CartDTO;
import com.b4.apollo.cart.model.dto.OrderDTO;
import com.b4.apollo.cart.model.dto.PaymentDTO;
import com.b4.apollo.user.model.dto.UserDTO;

import java.util.HashMap;
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
     * @MethodName : addCart
     * @작성일 : 2023. 01. 01.
     * @작성자 : 김수용
     * @Method 설명 : 장바구니에 상품을 추가하는 기능
     */
    int addProductToCart(HashMap<String, Object> parameter);
    /**
     * @MethodName : getCartList
     * @작성일 : 2022. 12. 30.
     * @작성자 : 김수용
     * @Method 설명 : 장바구니 페이지에 출력할 장바구니 품목들을 불러오는 기능
     */
    List<CartDTO> getCartList(HashMap<String, String> parameter);
    /**
     * @MethodName : getCheckedCartList
     * @작성일 : 2023. 01. 14.
     * @작성자 : 김수용
     * @Method 설명 : 체크된 장바구니 품목들을 불러오는 기능
     */
    List<CartDTO> getCheckedCartList(Map<String, String> parameter);
    /**
     * @MethodName : updateProductCount
     * @작성일 : 2023. 01. 05.
     * @작성자 : 김수용
     * @Method 설명 : 장바구니에 담긴 품목의 수량 수정하는 기능
     */
    int updateProductCount(HashMap<String, Integer> parameter);
    /**
     * @MethodName : updateCheckStatus
     * @작성일 : 2023. 01. 13.
     * @작성자 : 김수용
     * @Method 설명 : 장바구니에 담긴 품목의 구매 여부를 수정하는 기능
     */
    int updateCheckStatus(HashMap<String, Object> parameter);
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
     * @Method 설명 : 유저 정보를 불러오는 기능
     */
    UserDTO getUserDetail(Map<String, String> parameter);
    /**
     * @MethodName : order
     * @작성일 : 2023. 01. 14.
     * @작성자 : 김수용
     * @Method 설명 : 주문 테이블에 삽입하는 기능
     */
    int order(List<CartDTO> cartList);
    /**
     * @MethodName : payment
     * @작성일 : 2023. 01. 14.
     * @작성자 : 김수용
     * @Method 설명 : 결제 테이블에 삽입하는 기능
     */
    int payment(PaymentDTO paymentDTO);
    /**
     * @MethodName : getPaymentDetail
     * @작성일 : 2022. 12. 30.
     * @작성자 : 김수용
     * @Method 설명 : 결제 정보를 불러오는 기능
     */
    PaymentDTO getPaymentDetailByPaymentNo(int paymentNo);
    /**
     * @MethodName : buyCartItems
     * @작성일 : 2023. 01. 14.
     * @작성자 : 김수용
     * @Method 설명 : 장바구니에 있는 품목의 구매하는 기능
     */
    int buyCartItem(int cartNo);
    /**
     * @MethodName : getOrderDetail
     * @작성일 : 2022. 12. 30.
     * @작성자 : 김수용
     * @Method 설명 : 주문 정보를 불러오는 기능
     */
    OrderDTO getOrderDetail(int orderNo);
}