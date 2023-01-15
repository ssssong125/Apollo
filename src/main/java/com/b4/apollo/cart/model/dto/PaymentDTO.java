package com.b4.apollo.cart.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 @FileName : PaymentDTO.java
 @Project : Apollo
 @Date : 2022. 12. 30.
 @작성자 : 김수용
 @프로그램 설명 : 결제 정보를 담은 DTO
 */
@Data
@NoArgsConstructor
//@Builder(toBuilder = true) // lombok 기능, 생성자를 조금 바꾼거를 바로바로 생성가능
public class PaymentDTO {

    /**
     * @param paymentNo 결제 번호
     */
    private int paymentNo;
    /**
     * @param userId 유저 아이디
     */
    private String userId;
    /**
     * @param usedPoint 사용 포인트
     */
    private int usedPoint;
    /**
     * @param paymentAmount 결제 금액
     */
    private int paymentAmount;
    /**
     * @param paymentMethod 결제 방식
     */
    private String paymentMethod;
    /**
     * @param receiverName 수취인
     */
    private String receiverName;
    /**
     * @param receiverTel 연락처
     */
    private String receiverTel;
    /**
     * @param address 배송지 주소
     */
    private String address;
    /**
     * @param paymentDate 주문 날짜
     */
    private Date paymentDate;
    /**
     * @param shippingStatus 배송 상태
     */
    private String shippingStatus;
    /**
     * @param deliveryRequires 배송 요청사항
     */
    private String deliveryRequires;
}
