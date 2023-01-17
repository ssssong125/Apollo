package com.b4.apollo.product.model.dao;

import com.b4.apollo.product.model.dto.CategoryDTO;
import com.b4.apollo.product.model.dto.ProdAndImageDTO;
import com.b4.apollo.product.model.dto.ProductImageDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 @FileName : ProductMapper
 @Project : Apollo
 @Date : 2023. 01. 06.
 @작성자 : 박유리
 @프로그램 설명 : 상품 crud의 dao interface
 */
@Mapper
public interface ProductMapper {
    ProdAndImageDTO productDetail(int code);

    List<ProdAndImageDTO> productList();

    int registProduct(ProdAndImageDTO prod);

    int productDelete(Integer code);

    int editProduct( ProdAndImageDTO newProd );

    int addProductImage(ProductImageDTO prodImg);

    int editProductImage( ProductImageDTO prodImg);

    int deleteImg(int code);
    List<ProdAndImageDTO> productListByCode(String parameter);

    Page<ProdAndImageDTO> selectList();

    List<CategoryDTO> readCategory();
}
