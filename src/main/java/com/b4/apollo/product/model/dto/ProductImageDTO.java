package com.b4.apollo.product.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter
@Setter

public class ProductImageDTO {


     private int fileNo;
     private String originName;
     private String storedName;
     private String isThumbnail;
     private int productNo;
}
