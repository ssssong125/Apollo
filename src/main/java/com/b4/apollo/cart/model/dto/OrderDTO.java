package com.b4.apollo.cart.model.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;

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

    private int orderNo;
    private int paymentNo;
    private Date orderDate;
    private String receiverName;
    private String receiverTel; // -또는 공백 받기위해 String 사용
    private String addressZipCode;
    private String address;
    private String addressDetail;
    private String shippingStatus;
}
