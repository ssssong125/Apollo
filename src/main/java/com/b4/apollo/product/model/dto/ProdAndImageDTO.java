package com.b4.apollo.product.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@ToString
@Getter
@Setter

public class ProdAndImageDTO {
    private Integer productNo;
    private String productName;
    private int productPrice;
    private String productDesc;
    private int productQty;
    private String categoryCode;
  //  private ProductImageDTO imgDTO;
   private List<ProductImageDTO> productImageDTOList;
}
