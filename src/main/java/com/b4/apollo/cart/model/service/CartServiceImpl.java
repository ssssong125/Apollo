package com.b4.apollo.cart.model.service;

import com.b4.apollo.cart.model.dao.CartMapper;
import com.b4.apollo.cart.model.dto.CartDTO;
import com.b4.apollo.cart.model.dto.OrderDTO;
import com.b4.apollo.cart.model.dto.PaymentDTO;
import com.b4.apollo.qna.exception.CommonException;
import com.b4.apollo.user.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
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
     * @MethodName : addProductToCart
     * @작성일 : 2023. 01. 01.
     * @작성자 : 김수용
     * @Method 설명 : 장바구니에 상품을 추가하는 기능 구현체
     */
    @Override

    @Transactional(rollbackFor = Exception.class) // 오류 발생시 롤백 // 메소드에
    public int addProductToCart(HashMap<String, Object> parameter) {

        int result = cartMapper.addProductToCart(parameter);

        if(result <= 0) {

            throw new CommonException("장바구니 담기 실패");
        }

        return result;
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
     * @MethodName : getCheckedCartList
     * @작성일 : 2023. 01. 14.
     * @작성자 : 김수용
     * @Method 설명 : 체크된 장바구니 품목들을 불러올 인터페이스의 구현체
     */
    @Override
    public List<CartDTO> getCheckedCartList(Map<String, String> parameter) {

        return cartMapper.getCheckedCartList(parameter);
    }
    /**
     * @MethodName : updateProductCount
     * @작성일 : 2023. 01. 06.
     * @작성자 : 김수용
     * @Method 설명 : 장바구니 페이지에서 구매수량을 수정할 인터페이스의 구현체
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateProductCount(HashMap<String, Integer> parameter) {

        int result = cartMapper.updateProductCount(parameter);

        if(result < 1) {

            throw new CommonException("구매 수량 조절 실패");
        }

        return result;
    }

    /**
     * @MethodName : updateCheckStatus
     * @작성일 : 2023. 01. 13.
     * @작성자 : 김수용
     * @Method 설명 : 장바구니 페이지에서 품목의 체크상태를 수정할 인터페이스의 구현체
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateCheckStatus(HashMap<String, Object> parameter) {

        int result = cartMapper.updateCheckStatus(parameter);

        if(result < 1) {

            throw new CommonException("구매 여부 수정 실패");
        }

        return result;
    }
    /**
     * @MethodName : deleteProductInCart
     * @작성일 : 2023. 01. 07.
     * @작성자 : 김수용
     * @Method 설명 : 장바구니 페이지에서 품목을 삭제하는 인터페이스의 구현체
     */
    @Override
    @Transactional(rollbackFor = Exception.class) // 오류 발생시 롤백 // 메소드에
    public int deleteProductInCart(Integer cartNo) {

        int result = cartMapper.deleteProductInCart(cartNo);

        if(result < 1) {

            throw new CommonException("품목 삭제 실패");
        }

        return result;
    }

    /**
     * @MethodName : getPaymentDetail
     * @작성일 : 2022. 12. 30.
     * @작성자 : 김수용
     * @Method 설명 : 결제 정보를 불러올 인터페이스의 구현체
     */
    @Override
    public UserDTO getUserDetail(Map<String, String> parameter) {

        return cartMapper.getUserDetail(parameter);
    }

    /**
     * @MethodName : order
     * @작성일 : 2023. 01. 14.
     * @작성자 : 김수용
     * @Method 설명 : 주문 테이블에 삽입할 인터페이스의 구현체
     */
    @Override
    @Transactional(rollbackFor = Exception.class) // 오류 발생시 롤백 // 메소드에
    public int order(List<CartDTO> cartList) {

        return cartMapper.order(cartList);
    }
    /**
     * @MethodName : payment
     * @작성일 : 2023. 01. 14.
     * @작성자 : 김수용
     * @Method 설명 : 결제 테이블에 삽입할 인터페이스의 구현체
     */
    @Override
    @Transactional(rollbackFor = Exception.class) // 오류 발생시 롤백 // 메소드에
    public int payment(PaymentDTO paymentDTO) {

        return cartMapper.payment(paymentDTO);
    }
    /**
     * @MethodName : payment
     * @작성일 : 2023. 01. 14.
     * @작성자 : 김수용
     * @Method 설명 : 결제 테이블에 삽입할 인터페이스의 구현체
     */
    public int updateProductQty(Map<String, Integer> parameter) {

        if (cartMapper.getProductQty(parameter.get("productNo")) >= parameter.get("productCount"))
            return cartMapper.updateProductQty(parameter);
         else
            return 0;
    }
    /**
     * @MethodName : getPaymentDetail
     * @작성일 : 2022. 12. 30.
     * @작성자 : 김수용
     * @Method 설명 : 결제 정보를 불러올 인터페이스의 구현체
     */
    @Override

    public PaymentDTO getPaymentDetailByPaymentNo(int paymentNo) {

        return cartMapper.getPaymentDetailByPaymentNo(paymentNo);
    }
    /**
     * @MethodName : buyCartItems
     * @작성일 : 2023. 01. 14.
     * @작성자 : 김수용
     * @Method 설명 : 체크된 장바구니 품목들의 구매상태를 변경하는 인터페이스의 구현체
     */
    @Override
    @Transactional(rollbackFor = Exception.class) // 오류 발생시 롤백 // 메소드에
    public int buyCartItem(int cartNo) {

        return cartMapper.buyCartItem(cartNo);
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

}
