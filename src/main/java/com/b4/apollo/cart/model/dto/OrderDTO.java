package com.b4.apollo.cart.model.dto;

import lombok.Builder;
import lombok.Data;

/**
 @FileName : OrderDTO.java
 @Project : Apollo
 @Date : 2022. 12. 28.
 @작성자 : 김수용
 @프로그램 설명 : 주문에 필요한 정보를 담은 DTO
 */
@Data
@Builder(toBuilder = true) // lombok 기능, 생성자를 조금 바꾼거를 바로바로 생성가능
public class OrderDTO {

    /**
     * @param orderNo 주문 번호
     */
//    private int orderNo;
    /**
     * @param paymentNo 결제 번호
     */
    private int paymentNo;
    /**
     * @param cartNo 장바구니 번호
     */
    private int cartNo;
}
