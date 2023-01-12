package com.b4.apollo.product.model.dto;

import lombok.*;

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

//     public ProductImageDTO(int i, String originalFilename, String storeFilename, String isThumb, int i1) {
//     }
}
