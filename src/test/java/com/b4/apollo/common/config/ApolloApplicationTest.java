package com.b4.apollo.common.config;

import com.b4.apollo.blog.model.dto.CommentDTO;
import com.b4.apollo.blog.service.CommentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootTest
class ApolloApplicationTest {

//    @Autowired
//    private BoardService boardService;
//
//    @Autowired
//    private ProductService productService;
//
//    private ProdAndImageDTO dto;
//
//    @Test
//    void 질문_삽입_테스트() {
//        for (int i = 1; i <= 40; i++) {
//            String userId = "user01";
//            String boardTitle = String.format("테스트 데이터입니다:[%03d]", i);
//            String boardContent = "내용무";
//            this.boardService.insertBoard(userId, boardTitle, boardContent);
//        }
//    }

    
//    @Test
//    void 상품_등록_테스트(){
//        dto.setProductNo(1);
//      dto.setProductName("헬로키티 기타");
//      dto.setProductPrice(3000);
//      dto.setProductDesc("매우 귀엽습니다.");
//      dto.setProductQty(1);
//      dto.setCategoryCode("C8");
//
//        List<ProductImageDTO> productImageDTOList =new ArrayList<>();
//        dto.setProductImageDTOList(productImageDTOList);
//        this.productService.registProduct(dto);
//
//    }

    @Autowired
    private CommentService commentService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void registerComments() {
        int number = 20;

        for (int i = 1; i <= number; i++) {
            CommentDTO comm = new CommentDTO();
            comm.setBlogNo(2); // 댓글을 추가할 게시글 번호
            comm.setCommContent(i + "번 댓글을 추가합니다!");
            commentService.registerComment(comm);
        }

        logger.debug("댓글 " + number + "개가 등록되었습니다.");
    }

    @Test
    public void deleteComment() {
        commentService.deleteComment(4); // 삭제할 댓글 번호

        getCommentList();
    }

    @Test
    public void getCommentList() {
        CommentDTO comm = new CommentDTO();
        comm.setBlogNo(2);

        commentService.getCommentList(comm);
    }

}