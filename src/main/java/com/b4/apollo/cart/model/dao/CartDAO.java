package com.b4.apollo.cart.model.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 @FileName : CartMapper.java
 @Project : Apollo
 @Date : 2022. 12. 28.
 @작성자 : 김수용
 @프로그램 설명 : 서버 구동 프로그램
 */
@Mapper
public interface CartDAO {

    int addCart(Map<String, Integer> product);

    int increaseProduct(Map<String, Integer> productNo);

//    MemberDTO findMemberById(String memberId); // 예시) xml로 넘겨서 쿼리 실행할 메소드 작성
}
