package com.b4.apollo.cart.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class productDTO {

    private int productNo;
    private int productName;
    private int productPrice;
    private String productDesc;
    private int productQty;
    private String categoryCode;
}
