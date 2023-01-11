package com.b4.apollo.product.model.service;

import com.b4.apollo.product.model.dao.ProductMapper;
import com.b4.apollo.product.model.dto.ProdAndImageDTO;
import com.b4.apollo.product.model.dto.ProductImageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductMapper productMapper;
    @Autowired
    public ProductServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public List<ProdAndImageDTO> productList() {
        return productMapper.productList();
    }

    @Override
    public ProdAndImageDTO productDetail(int code) {
        Optional<ProdAndImageDTO> prod = Optional.ofNullable(this.productMapper.productDetail(code));
   //     if (prod.isPresent()) {
            return prod.get();
      //  } //else {
    //        throw new DataNotFoundException("product not found");
     //   }
//        return productMapper.productDetail(code);
    }

    @Override
    public boolean registProduct(ProdAndImageDTO prod) /*throws Exception*/ {
        int result=0;
        int productResult = productMapper.registProduct(prod);
        List<ProductImageDTO> imgList = prod.getProductImageDTOList();
      // ProductImageDTO imgList = prod.getProductImageDTOList();
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
    @Transactional(rollbackFor = Exception.class)
    public boolean editProduct(ProdAndImageDTO newProd) {
        int result=0;
        int productResult = productMapper.editProduct(newProd);
        List<ProductImageDTO> imgList = newProd.getProductImageDTOList();
        System.out.println("서비스의 이미지 리스트: "+imgList);
        // ProductImageDTO imgList = prod.getProductImageDTOList();
        int imgResult = 0;
        for(int i = 0 ; i<imgList.size();i++){
            System.out.println("반복문이 실행됨.");
            imgResult += productMapper.editProductImage(imgList.get(i));
        }
        if(productResult>0 && imgResult == imgList.size()) {
            result = 1;
        }
        return result>0;
    }

    @Override
    public boolean productDelete(Integer code) {
        int result = productMapper.productDelete(code);
        if(result<=0){
            // throw new Exception("메뉴등록 실패");
        }
        return result>0 ? true:  false;    }

    @Override
    public List<ProdAndImageDTO> productListByCode() {
        return productMapper.productListByCode();
    }



    /*     public boolean registMenu(MenuDTO menu) throws Exception {
        int result = menuMapper.registMenu(menu);
        if(result<=0){
            throw new Exception("메뉴등록 실패");
        }
        return result>0 ? true:  false;
    } */
}
