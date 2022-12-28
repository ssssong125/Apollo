package com.b4.apollo.product.model.dao;

import com.b4.apollo.product.model.dto.ProductDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductDAO {
    ProductDTO findProductByCode(int code);
}
