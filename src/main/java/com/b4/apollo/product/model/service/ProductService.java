package com.b4.apollo.product.model.service;

import com.b4.apollo.product.model.dto.ProductDTO;

import java.util.List;

public interface ProductService {


    List<ProductDTO> productList();

    ProductDTO productDetail(int code);

    boolean registProduct(ProductDTO newProd);

    boolean editProduct(ProductDTO newProd);

    ProductDTO productDelete(int code);
}
