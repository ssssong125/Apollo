package com.b4.apollo.cart.model.dao;

import com.b4.apollo.cart.model.dto.OrderDTO;
import com.b4.apollo.cart.model.dto.PaymentDTO;
import com.b4.apollo.product.model.dto.ProductDTO;
import org.apache.ibatis.annotations.Mapper;

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
public interface CartDAO {

    /**
     * @MethodName : getCartList
     * @작성일 : 2022. 12. 30.
     * @작성자 : 김수용
     * @Method 설명 : CartService에서 호출되어 장바구니 품목을 조회할 쿼리문을 실행시킴
     */
    List<ProductDTO> getCartList(Map<String, String> userId);

    /**
     * @MethodName : getPaymentDetail
     * @작성일 : 2022. 12. 30.
     * @작성자 : 김수용
     * @Method 설명 : CartService에서 호출되어 결제정보를 조회할 쿼리문을 실행시킴
     */
    PaymentDTO getPaymentDetail(Map<String, String> userId);

    /**
     * @MethodName : getOrder
     * @작성일 : 2022. 12. 30.
     * @작성자 : 김수용
     * @Method 설명 : CartService에서 호출되어 오더정보를 조회할 쿼리문을 실행시킴
     */
    OrderDTO getOrderDetail(Map<String, Integer> paymentNo);

    int addCart(Map<String, Integer> product);

    int increaseProduct(Map<String, Integer> productNo);

//    MemberDTO findMemberById(String memberId); // 예시) xml로 넘겨서 쿼리 실행할 메소드 작성
}
