package com.b4.apollo.product.model.dto;

import lombok.*;
/**
 @FileName : ProductImageDTO
 @Project : Apollo
 @Date : 2023. 01. 06.
 @작성자 : 박유리
 @프로그램 설명 : 상품 사진에 대한 정보를 담은 dto
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
public class ProductImageDTO {
     private int fileNo;
     private String originName;
     private String storedName;
     private String isThumbnail;
     private int productNo;
     private String imgPath;

}
