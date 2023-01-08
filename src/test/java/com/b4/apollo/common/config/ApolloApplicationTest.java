package com.b4.apollo.common.config;

import com.b4.apollo.product.model.dto.ProdAndImageDTO;

import com.b4.apollo.product.model.service.ProductService;
import com.b4.apollo.qna.service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ApolloApplicationTest {

    @Autowired
    private BoardService boardService;

    @Autowired
    private ProductService productService;
    private ProdAndImageDTO dto;

    @Test
    void 질문_삽입_테스트() {
        for (int i = 1; i <= 40; i++) {
            String userId = "user01";
            String boardTitle = String.format("테스트 데이터입니다:[%03d]", i);
            String boardContent = "내용무";
            this.boardService.insertBoard(userId, boardTitle, boardContent);
        }
    }

    
//    @Test
//    void 상품_등록_테스트(){
//
//      dto.setProductName("헬로키티 기타");
//      dto.setProductPrice(3000);
//      dto.setProductDesc("매우 귀엽습니다.");
//      dto.setProductQty(1);
//      dto.setCategoryCode("C8");
////
////        List<ProductImageDTO> productImageDTOList ={1, "안녕"};
////        dto.getProductImageDTOList().set(0,productImageDTOList);
//        this.productService.registProduct(dto);
//
//    }

}