package com.b4.apollo.cart.model.dto;


import com.b4.apollo.user.model.dto.UserDTO;
import com.b4.apollo.product.model.dto.ProductDTO;
import lombok.Builder;
import lombok.Data;



import java.sql.Date;

/**
 @FileName : ProductDTO.java
 @Project : Apollo
 @Date : 2022. 12. 28.
 @작성자 : 김수용
 @프로그램 설명 : 상품 정보를 담은 DTO
 */
//@Data
@Getter
@Setter
@Builder(toBuilder = true) // lombok 기능, 생성자를 조금 바꾼거를 바로바로 생성가능
public class CartDTO extends ProductDTO {

    /**
     * @param cartNo 장바구니 번호(고유 일련번호)
     */
    private int cartNo;

    /**
     * @param user 유저 아이디
     */
    private String userId;

    /**
     * @param productCount 구매 수량
     */
    private int productCount;

    private UserDTO user;


    /**
     * @param productDTO 상품 객체
     */
    private ProductDTO productInfo;

    private int productNo;
    private String productName;
    private int productPrice;
    private String productDesc;
    private int productQty;
    private String categoryCode;
}
