package com.b4.apollo.product.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/**
 @FileName : CategoryDTO
 @Project : Apollo
 @Date : 2023. 01. 06.
 @작성자 : 박유리
 @프로그램 설명 : 상품 카테고리에 대한 정보를 담은 dto
 */
@NoArgsConstructor
@ToString
@Getter
@Setter
public class CategoryDTO {
    private String categoryCode;
    private String categoryName;
}
