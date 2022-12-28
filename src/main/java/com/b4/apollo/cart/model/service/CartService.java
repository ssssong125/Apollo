package com.b4.apollo.cart.model.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 @FileName : CartService.java
 @Project : Apollo
 @Date : 2022. 12. 28.
 @작성자 : 김수용
 @프로그램 설명 : 주문 관련 요청을 처리할 Service 클래스
 */
@Service
@Transactional(rollbackFor = Exception.class) // 오류 발생시 롤백
public class CartService {


}
