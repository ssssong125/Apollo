package com.b4.apollo.cart.model.dto;

import lombok.Builder;
import lombok.Data;

/**
 @FileName : PaymentDTO.java
 @Project : Apollo
 @Date : 2022. 12. 30.
 @작성자 : 김수용
 @프로그램 설명 : 결제 정보를 담은 DTO
 */
@Data
@Builder(toBuilder = true) // lombok 기능, 생성자를 조금 바꾼거를 바로바로 생성가능
public class PaymentDTO {

    private int paymentNo;
    private String userId;
    private String paymentMethod;
    private int paymentAmount;
}
