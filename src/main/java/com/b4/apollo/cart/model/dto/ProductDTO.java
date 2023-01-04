package com.b4.apollo.cart.model.dto;


import lombok.Builder;
import lombok.Data;

/**
 @FileName : ProductDTO.java
 @Project : Apollo
 @Date : 2022. 12. 28.
 @작성자 : 김수용
 @프로그램 설명 : 상품 정보를 담은 DTO
 */
@Data
@Builder(toBuilder = true) // lombok 기능, 생성자를 조금 바꾼거를 바로바로 생성가능
public class ProductDTO {

    private int productNo;
    private int productName;
    private int productPrice;
    private String productDesc;
    private int productQty;
    private String categoryCode;

}