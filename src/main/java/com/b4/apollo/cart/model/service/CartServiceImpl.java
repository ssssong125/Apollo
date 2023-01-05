package com.b4.apollo.cart.model.service;

import com.b4.apollo.cart.model.dao.CartMapper;
import com.b4.apollo.cart.model.dto.CartDTO;
import com.b4.apollo.cart.model.dto.OrderDTO;
import com.b4.apollo.cart.model.dto.PaymentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 @FileName : CartServiceImpl.java
 @Project : Apollo
 @Date : 2022. 12. 30.
 @작성자 : 김수용
 @프로그램 설명 : 주문 관련 요청을 처리할 Service의 구현체
 */
@Service
public class CartServiceImpl implements CartService{

    private CartMapper cartMapper;

    /**
     * @MethodName : 기본 생성자
     * @작성일 : 2022. 12. 30.
     * @작성자 : 김수용
     * @Method 설명 : 생성자를 통한 주입
     */
    @Autowired
    public CartServiceImpl(CartMapper cartDAO) {
        this.cartMapper = cartDAO;
    }

    /**
     * @MethodName : getCartList
     * @작성일 : 2022. 12. 30.
     * @작성자 : 김수용
     * @Method 설명 : 장바구니 페이지에 출력할 장바구니 품목들을 불러올 인터페이스의 구현체
     */
    @Override
    public List<CartDTO> getCartList(HashMap<String, String> parameter) {

        return cartMapper.getCartList(parameter);
    }

    /**
     * @MethodName : getPaymentDetail
     * @작성일 : 2022. 12. 30.
     * @작성자 : 김수용
     * @Method 설명 : 결제 정보를 불러올 인터페이스의 구현체
     */
    @Override
    public PaymentDTO getPaymentDetail(int paymentNo) {

        HashMap<String, Integer> parameter = new HashMap<>();
        parameter.put("paymentNo", paymentNo);

        return cartMapper.getPaymentDetail(parameter);
    }

    /**
     * @MethodName : getOrderDetail
     * @작성일 : 2022. 12. 30.
     * @작성자 : 김수용
     * @Method 설명 : 주문 정보를 불러올 인터페이스의 구현체
     */
    @Override
    public OrderDTO getOrderDetail(int orderNo) {

        HashMap<String, Integer> parameter = new HashMap<>();
        parameter.put("orderNo", orderNo);

        return cartMapper.getOrderDetail(parameter);
    }

    /*
     * @MethodName : addCart
     * @작성일 : 2023. 01. 01.
     * @작성자 : 김수용
     * @Method 설명 : 장바구니에 상품을 추가하는 기능 구현체
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addProductToCart(int productNo, String userId, int productCount) throws Exception{

        HashMap<String, Object> parameter = new HashMap<>();
        parameter.put("productNo", productNo);
        parameter.put("userId", userId);
        parameter.put("productCount", productCount);

//        CartDTO cartDTO = cartDAO.getCart(userId);
//        if(cartDTO == null){
//            cartDTO = cartDAO.insertCart(userId);
//        }
//        int result = cartDAO.addProductToCart(cartDTO.getCartNo(), productNo);
        int result = 0;
        if(result <= 0) {

            throw new Exception("장바구니 담기 실패");
        }

        return result > 0;
    }

    /*
     * @MethodName : increaseProduct
     * @작성일 : 2023. 01. 03.
     * @작성자 : 김수용
     * @Method 설명 : 장바구니에 품목의 주문수량 증가시키는 기능의 구현체
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void increaseProduct(int cartNo) throws Exception {

//        int result = cartMapper.increaseProduct(cartNo);
//
//        if(result <= 0) {
//
//            throw new Exception("주문수량 증가 실패");
//        }
//
//        return result > 0;

        cartMapper.increaseProduct(cartNo);
    }

    /*
     * @MethodName : decreaseProduct
     * @작성일 : 2023. 01. 03.
     * @작성자 : 김수용
     * @Method 설명 : 장바구니에 품목의 주문수량 감소시키는 기능의 구현체
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void decreaseProduct(int cartNo) throws Exception {

//        int result = cartMapper.decreaseProduct(cartNo);
//
//        if(result <= 0) {
//
//            throw new Exception("주문수량 감소 실패");
//        }
//
//        return result > 0;

        cartMapper.decreaseProduct(cartNo);
    }

    public void updateProductCount(int cartNo, int count) {

        cartMapper.updateProductCount(cartNo, count);
    }

    @Override
    public boolean deleteProduct(int cartNo) throws Exception {

        int result = cartMapper.deleteProduct(cartNo);

        if(result <= 0) {

            throw new Exception("품목 삭제 실패");
        }

        return result > 0;
    }


}
//@Transactional(rollbackFor = Exception.class) // 오류 발생시 롤백 // 메소드에
