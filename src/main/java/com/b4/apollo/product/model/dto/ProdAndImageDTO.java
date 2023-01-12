package com.b4.apollo.product.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data

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
