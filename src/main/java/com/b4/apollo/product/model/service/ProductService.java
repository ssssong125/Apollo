package com.b4.apollo.product.model.service;

import com.b4.apollo.product.model.dto.ProdAndImageDTO;

import java.util.List;

public interface ProductService {


    List<ProdAndImageDTO> productList();

    ProdAndImageDTO productDetail(int code);

    boolean registProduct(ProdAndImageDTO newProd);

    boolean editProduct(ProdAndImageDTO newProd);

    boolean productDelete(ProdAndImageDTO prod);

    List<ProdAndImageDTO> productListByCode(String parameter);

//    List<ProdAndImageDTO> productListByInst(String category);
//    Page<ProdAndImageDTO> selectList(int pageNum);
}
