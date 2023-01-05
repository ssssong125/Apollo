package com.b4.apollo.product.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class CategoryDTO {
    private String categoryCode;
    private String categoryName;
}
