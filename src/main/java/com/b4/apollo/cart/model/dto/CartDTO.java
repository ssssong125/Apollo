package com.b4.apollo.cart.model.dto;


import com.b4.apollo.member.model.dto.MemberDTO;
import com.b4.apollo.product.model.dto.ProductDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 @FileName : ProductDTO.java
 @Project : Apollo
 @Date : 2022. 12. 28.
 @작성자 : 김수용
 @프로그램 설명 : 상품 정보를 담은 DTO
 */
@Data
@Builder(toBuilder = true) // lombok 기능, 생성자를 조금 바꾼거를 바로바로 생성가능
public class CartDTO {

    private int cartNo;

    private int productNo;

    /**
     *  유 저 아이디
     */
    private String userId;

    private int productCount;

    private MemberDTO user;

    private List<ProductDTO> productList;
}
