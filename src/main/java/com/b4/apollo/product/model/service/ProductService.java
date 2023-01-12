package com.b4.apollo.product.model.service;

import com.b4.apollo.product.model.dto.ProdAndImageDTO;

import java.util.List;

public interface ProductService {


    List<ProdAndImageDTO> productList();

    ProdAndImageDTO productDetail(int code);

    boolean registProduct(ProdAndImageDTO newProd);

    boolean editProduct(ProdAndImageDTO newProd);

    boolean productDelete(Integer code);

    List<ProdAndImageDTO> productListByCode();
}
