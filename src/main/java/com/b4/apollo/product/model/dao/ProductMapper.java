package com.b4.apollo.product.model.dao;

import com.b4.apollo.product.model.dto.ProdAndImageDTO;
import com.b4.apollo.product.model.dto.ProductImageDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProdAndImageDTO productDetail(int code);

    List<ProdAndImageDTO> productList();

    int registProduct(ProdAndImageDTO prod);

    int productDelete(Integer code);

    int editProduct(/*@RequestParam("newProd")*/ ProdAndImageDTO newProd /*@RequestParam("code")*/);

    int addProductImage(ProductImageDTO prodImg);

    int editProductImage( ProductImageDTO prodImg);

    int deleteImg(int code);
    List<ProdAndImageDTO> productListByCode(String parameter);

//    List<ProdAndImageDTO> productListByInst(String categoryCode);
    Page<ProdAndImageDTO> selectList();

//    String[] getCategory();
    List<String> readCategory();
}
