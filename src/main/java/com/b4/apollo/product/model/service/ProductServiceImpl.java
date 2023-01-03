package com.b4.apollo.product.model.service;

import com.b4.apollo.product.model.dao.ProductDAO;
import com.b4.apollo.product.model.dto.ProductDTO;
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
        int result = productDAO.registProduct(prod);
        if(result<=0){
            // throw new Exception("메뉴등록 실패");
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
    public ProductDTO productDelete(int code) {
        return productDAO.productDelete(code);
    }



    /*     public boolean registMenu(MenuDTO menu) throws Exception {
        int result = menuMapper.registMenu(menu);
        if(result<=0){
            throw new Exception("메뉴등록 실패");
        }
        return result>0 ? true:  false;
    } */
}
