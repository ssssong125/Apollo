package com.b4.apollo.product.model.service;

import com.b4.apollo.product.model.dao.ProductDAO;
import com.b4.apollo.product.model.dto.ProductDTO;
import com.b4.apollo.product.model.dto.ProductImageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductDAO productDAO;
    @Autowired
    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public List<ProductDTO> productList() {
        return productDAO.productList();
    }

    @Override
    public ProductDTO productDetail(int code) {
        return productDAO.productDetail(code);
    }

    @Override
    public boolean registProduct(ProductDTO prod) /*throws Exception*/ {
        int result=0;
        int productResult = productDAO.registProduct(prod);
        List<ProductImageDTO> imgList = prod.getProductImageDTOList();
        int imgResult = 0;
        for(int i = 0 ; i<imgList.size();i++){
            imgResult += productDAO.addProductImage(imgList.get(i));
        }
        if(productResult>0 && imgResult == imgList.size()) {
            result = 1;
        }
        return result>0 ? true:  false;
    }

    @Override
    public boolean editProduct(ProductDTO newProd) {
        int result = productDAO.editProduct(newProd);
        if(result<=0){
            // throw new Exception("메뉴등록 실패");
        }
        return result>0 ? true:  false;
    }

    @Override
    public boolean productDelete(Integer code) {
        int result = productDAO.productDelete(code);
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
