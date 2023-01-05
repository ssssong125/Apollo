package com.b4.apollo.product.model.service;

import com.b4.apollo.product.model.dao.ProductMapper;
import com.b4.apollo.product.model.dto.ProdAndImageDTO;
import com.b4.apollo.product.model.dto.ProductDTO;
import com.b4.apollo.product.model.dto.ProductImageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductMapper productMapper;
    @Autowired
    public ProductServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductDTO> productList() {
        return productMapper.productList();
    }

    @Override
    public ProductDTO productDetail(int code) {
        return productMapper.productDetail(code);
    }

    @Override
    public boolean registProduct(ProdAndImageDTO prod) /*throws Exception*/ {
        int result=0;
        int productResult = productMapper.registProduct(prod);
        List<ProductImageDTO> imgList = prod.getProductImageDTOList();
        int imgResult = 0;
        for(int i = 0 ; i<imgList.size();i++){
            imgResult += productMapper.addProductImage(imgList.get(i));
        }
        if(productResult>0 && imgResult == imgList.size()) {
            result = 1;
        }
        return result>0 ? true:  false;
    }

    @Override
    public boolean editProduct(ProdAndImageDTO newProd) {
        int result = productMapper.editProduct(newProd);
        if(result<=0){
            // throw new Exception("메뉴등록 실패");
        }
        return result>0 ? true:  false;
    }

    @Override
    public boolean productDelete(Integer code) {
        int result = productMapper.productDelete(code);
        if(result<=0){
            // throw new Exception("메뉴등록 실패");
        }
        return result>0 ? true:  false;    }



    /*     public boolean registMenu(MenuDTO menu) throws Exception {
        int result = menuMapper.registMenu(menu);
        if(result<=0){
            throw new Exception("메뉴등록 실패");
        }
        return result>0 ? true:  false;
    } */
}
