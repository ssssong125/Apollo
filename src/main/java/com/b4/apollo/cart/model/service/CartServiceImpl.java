package com.b4.apollo.cart.model.service;

import com.b4.apollo.cart.model.dao.CartDAO;
import com.b4.apollo.cart.model.dto.OrderDTO;
import com.b4.apollo.cart.model.dto.PaymentDTO;
import com.b4.apollo.product.model.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

/**
 @FileName : CartServiceImpl.java
 @Project : Apollo
 @Date : 2022. 12. 30.
 @작성자 : 김수용
 @프로그램 설명 : 주문 관련 요청을 처리할 Service의 구현체
 */
@Service
public class CartServiceImpl implements CartService{

    private final CartDAO cartDAO;

    /**
     * @MethodName : 기본 생성자
     * @작성일 : 2022. 12. 30.
     * @작성자 : 김수용
     * @Method 설명 : 생성자를 통한 주입
     */
    @Autowired
    public CartServiceImpl(CartDAO cartDAO) {
        this.cartDAO = cartDAO;
    }

    /**
     * @MethodName : getCartList
     * @작성일 : 2022. 12. 30.
     * @작성자 : 김수용
     * @Method 설명 : 장바구니 페이지에 출력할 장바구니 품목들을 불러올 인터페이스의 구현체
     */
    @Override
    public List<ProductDTO> getCartList(Map<String, String> userId) {

        List<ProductDTO> pList = cartDAO.getCartList(userId);

//        if(productList == null) {
////            throw new ProductNotFoundException("상품 정보가 존재하지 않습니다.");
////            throw new Exception("상품 정보가 존재하지 않습니다.");
//        }

        return pList;
    }

    /**
     * @MethodName : getPaymentDetail
     * @작성일 : 2022. 12. 30.
     * @작성자 : 김수용
     * @Method 설명 : 결제 정보를 불러올 인터페이스의 구현체
     */
    @Override
    public PaymentDTO getPaymentDetail(Map<String, String> userId) {

        PaymentDTO paymentDetail = cartDAO.getPaymentDetail(userId);

        return paymentDetail;
    }

    /**
     * @MethodName : getOrderDetail
     * @작성일 : 2022. 12. 30.
     * @작성자 : 김수용
     * @Method 설명 : 주문 정보를 불러올 인터페이스의 구현체
     */
    @Override
    public OrderDTO getOrderDetail(Map<String, Integer> paymentNo) {

        OrderDTO orderDetail = cartDAO.getOrderDetail(paymentNo);

        return orderDetail;
    }

    /*
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
//@Transactional(rollbackFor = Exception.class) // 오류 발생시 롤백 // 메소드에 
