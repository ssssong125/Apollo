package com.b4.apollo.product.model.service;

import com.b4.apollo.product.model.dto.ProdAndImageDTO;

import java.util.List;
/**
 @FileName : ProductService
 @Project : Apollo
 @Date : 2023. 01. 06.
 @작성자 : 박유리
 @프로그램 설명 : 상품에 관한 service interface
 */
public interface ProductService {


    List<ProdAndImageDTO> productList();

    ProdAndImageDTO productDetail(int code);

    boolean registProduct(ProdAndImageDTO newProd);

    boolean editProduct(ProdAndImageDTO newProd);

    boolean productDelete(ProdAndImageDTO prod);

    List<ProdAndImageDTO> productListByCode(String category);

}
