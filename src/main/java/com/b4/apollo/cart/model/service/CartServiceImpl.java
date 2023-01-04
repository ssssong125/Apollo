package com.b4.apollo.cart.model.service;

import com.b4.apollo.cart.model.dao.CartMapper;
import com.b4.apollo.cart.model.dto.CartProductDTO;
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

    private CartMapper cartDAO;

    /**
     * @MethodName : 기본 생성자
     * @작성일 : 2022. 12. 30.
     * @작성자 : 김수용
     * @Method 설명 : 생성자를 통한 주입
     */
    @Autowired
    public CartServiceImpl(CartMapper cartDAO) {
        this.cartDAO = cartDAO;
    }

    /**
     * @MethodName : getCartList
     * @작성일 : 2022. 12. 30.
     * @작성자 : 김수용
     * @Method 설명 : 장바구니 페이지에 출력할 장바구니 품목들을 불러올 인터페이스의 구현체
     */
    @Override
    public List<CartProductDTO> getCartList(String userId) {
//    public List<ProductDTO> getCartList(Map<String, String> parameter) {

        // 널값은 스크립트로 처리하자
        //        if(productList == null) {
////            throw new ProductNotFoundException("상품 정보가 존재하지 않습니다.");
////            throw new Exception("상품 정보가 존재하지 않습니다.");
//        }

        return cartDAO.getCartList(userId);
//        return cartDAO.getCartList(parameter);
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

        return cartDAO.getPaymentDetail(parameter);
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

        return cartDAO.getOrderDetail(parameter);
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
    public boolean increaseProduct(int cartNo) throws Exception{

        int result = cartDAO.increaseProduct(cartNo);

        if(result <= 0) {

            throw new Exception("주문수량 증가 실패");
        }

        return result > 0;
    }

    /*
     * @MethodName : decreaseProduct
     * @작성일 : 2023. 01. 03.
     * @작성자 : 김수용
     * @Method 설명 : 장바구니에 품목의 주문수량 감소시키는 기능의 구현체
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean decreaseProduct(int cartNo) throws Exception {

        int result = cartDAO.decreaseProduct(cartNo);

        if(result <= 0) {

            throw new Exception("주문수량 감소 실패");
        }

        return result > 0;
    }

    @Override
    public boolean deleteProduct(int cartNo) throws Exception {

        int result = cartDAO.deleteProduct(cartNo);

        if(result <= 0) {

            throw new Exception("품목 삭제 실패");
        }

        return result > 0;
    }


}
//@Transactional(rollbackFor = Exception.class) // 오류 발생시 롤백 // 메소드에 
