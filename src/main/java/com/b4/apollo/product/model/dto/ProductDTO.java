package com.b4.apollo.product.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
@ToString
public class ProductDTO {
    private int productNo;
    private int productName;
    private int productPrice;
    private String productDesc;
    private int productQty;
    private String categoryCode;
}
