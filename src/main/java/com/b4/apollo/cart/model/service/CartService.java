package com.b4.apollo.cart.model.service;

import com.b4.apollo.cart.model.dto.OrderDTO;
import com.b4.apollo.cart.model.dto.PaymentDTO;
import com.b4.apollo.product.model.dto.ProductDTO;

import java.util.List;

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
     * @Method 설명 : 장바구니 페이지에 출력할 장바구니 품목들을 불러오는 기능
     */
    List<ProductDTO> getCartList(String userId);

    /**
     * @MethodName : getPaymentDetail
     * @작성일 : 2022. 12. 30.
     * @작성자 : 김수용
     * @Method 설명 : 결제 정보를 불러오는 기능
     */
    PaymentDTO getPaymentDetail(int paymentNo);

    /**
     * @MethodName : getOrderDetail
     * @작성일 : 2022. 12. 30.
     * @작성자 : 김수용
     * @Method 설명 : 주문 정보를 불러오는 기능
     */
    OrderDTO getOrderDetail(int orderNo);

    /**
     * @MethodName : addCart
     * @작성일 : 2023. 01. 01.
     * @작성자 : 김수용
     * @Method 설명 : 장바구니에 상품을 추가하는 기능
     */
    boolean addCart(int productNo, String userId, int productCount) throws Exception;

    /**
     * @MethodName : increaseProduct
     * @작성일 : 2023. 01. 03.
     * @작성자 : 김수용
     * @Method 설명 : 장바구니에 담긴 품목의 수량을 증가시키는 기능
     */
    boolean increaseProduct(int cartNo) throws Exception;

    /**
     * @MethodName : decreaseProduct
     * @작성일 : 2023. 01. 03.
     * @작성자 : 김수용
     * @Method 설명 : 장바구니에 담긴 품목의 수량을 감소시키는 기능
     */
    boolean decreaseProduct(int cartNo) throws Exception;

    /**
     * @MethodName : deleteProduct
     * @작성일 : 2023. 01. 03.
     * @작성자 : 김수용
     * @Method 설명 : CartService에서 호출되어 장바구니에서 품목을 제거함
     */
    boolean deleteProduct(int cartNo) throws Exception;
}
