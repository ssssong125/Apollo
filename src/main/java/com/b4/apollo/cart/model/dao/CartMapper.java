package com.b4.apollo.cart.model.dao;

import com.b4.apollo.cart.model.dto.CartProductDTO;
import com.b4.apollo.cart.model.dto.OrderDTO;
import com.b4.apollo.cart.model.dto.PaymentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 @FileName : CartDAO.java
 @Project : Apollo
 @Date : 2022. 12. 28.
 @작성자 : 김수용
 @프로그램 설명 : 서버 구동 프로그램
 */
@Mapper
public interface CartMapper {

    /**
     * @MethodName : getCartList
     * @작성일 : 2022. 12. 30.
     * @작성자 : 김수용
     * @Method 설명 : CartService에서 호출되어 장바구니 품목을 조회할 쿼리문을 실행시킴
     */
//    List<ProductDTO> getCartList(Map<String, String> parameter);
    List<CartProductDTO> getCartList(String userId);

    /**
     * @MethodName : getOrder
     * @작성일 : 2022. 12. 30.
     * @작성자 : 김수용
     * @Method 설명 : CartService에서 호출되어 오더정보를 조회할 쿼리문을 실행시킴
     */
    OrderDTO getOrderDetail(Map<String, Integer> parameter);

    /**
     * @MethodName : getPaymentDetail
     * @작성일 : 2022. 12. 30.
     * @작성자 : 김수용
     * @Method 설명 : CartService에서 호출되어 결제정보를 조회할 쿼리문을 실행시킴
     */
    PaymentDTO getPaymentDetail(HashMap<String, Integer> parameter);

    /**
     * @MethodName : addCart
     * @작성일 : 2023. 01. 01.
     * @작성자 : 김수용
     * @Method 설명 : CartService에서 호출되어 품목을 장바구니에 추가하는 쿼리문을 실행시킴
     */
    int addCart(HashMap<String, String> parameter);

    /**
     * @MethodName : increaseProduct
     * @작성일 : 2023. 01. 02.
     * @작성자 : 김수용
     * @Method 설명 : CartService에서 호출되어 장바구니 품목의 구매수량을 증가 시킴
     */
    int increaseProduct(int cartNo);

    /**
     * @MethodName : increaseProduct
     * @작성일 : 2023. 01. 03.
     * @작성자 : 김수용
     * @Method 설명 : CartService에서 호출되어 장바구니 품목의 구매수량을 감소 시킴
     */
    int decreaseProduct(int cartNo);

    /**
     * @MethodName : deleteProduct
     * @작성일 : 2023. 01. 03.
     * @작성자 : 김수용
     * @Method 설명 : CartService에서 호출되어 장바구니에서 품목을 제거함
     */
    int deleteProduct(int cartNo);


    /**
     * @MethodName : order
     * @작성일 : 2023. 01. 03.
     * @작성자 : 김수용
     * @Method 설명 : CartService에서 호출되어 주문시 필요한 주소지를 입력받음
     */
//    int order(HashMap<String, String> parameter);

//    MemberDTO findMemberById(String memberId); // 예시) xml로 넘겨서 쿼리 실행할 메소드 작성
}


//@Repository
//public class CartDAO {
//
////    List<ProductDTO> getCartList(String userId);
//// PaymentDTO getPaymentDetail(HashMap<String, Integer> parameter);
////    OrderDTO getOrderDetail(Map<String, Integer> parameter);
////    int addCart(HashMap<String, String> parameter);
////    int increaseProduct(int cartNo);
////    int decreaseProduct(int cartNo);
////    int deleteProduct(int cartNo);
//
//    public ArrayList<ProductDTO> getCartList(SqlSessionTemplate sqlSession, String userId) {
//
//        return (ArrayList) sqlSession.selectList("CartMapper.getCartList", userId);
//    }
//
////    public int selectListCount(SqlSessionTemplate sqlSession) {
////        return sqlSession.selectOne("boardMapper.selectListCount");
////    }
////
////    public ArrayList<Question> selectList(SqlSessionTemplate sqlSession, PageInfo pageInfo) {
////        int offset = (pageInfo.getCurrentPage() - 1) * pageInfo.getBoardLimit();
////        RowBounds rowBounds = new RowBounds(offset, pageInfo.getBoardLimit());
////
////        return (ArrayList)sqlSession.selectList("boardMapper.selectList", null, rowBounds);
////    }
////
////    public int increaseCount(SqlSessionTemplate sqlSession, int bno) {
////        return sqlSession.update("boardMapper.increaseCount", bno);
////    }
////
////    public Question selectBoard(SqlSessionTemplate sqlSession, int bno) {
////        return sqlSession.selectOne("boardMapper.selectBoard", bno);
////    }
////
////    public int insertBoard(SqlSessionTemplate sqlSession, Question q) {
////        return sqlSession.insert("boardMapper.insertBoard", q);
////    }
////
////    public int deleteBoard(SqlSessionTemplate sqlSession, int boardNo) {
////        return sqlSession.update("boardMapper.deleteBoard", boardNo);
////    }
////
////    public int updateBoard(SqlSessionTemplate sqlSession, Question q) {
////        return sqlSession.update("boardMapper.updateBoard", q);
////    }
////}
