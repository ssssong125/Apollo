package com.b4.apollo.product.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
/**
 @FileName : ProdAndImageDTO
 @Project : Apollo
 @Date : 2023. 01. 06.
 @작성자 : 박유리
 @프로그램 설명 : 상품에 대한 정보를 담은 dto
 */
@NoArgsConstructor
@Data
public class ProdAndImageDTO {
    private Integer productNo;
    private String productName;
    private int productPrice;
    private String productDesc;
    private int productQty;
    private String categoryCode;
    private List<ProductImageDTO> productImageDTOList;
}
