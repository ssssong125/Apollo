package com.b4.apollo.common.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 @FileName : ContextConfiguration.java
 @Project : Apollo
 @Date : 2022. 12. 28.
 @작성자 : 김수용
 @프로그램 설명 : 어플리케이션 컨텍스트 리소스의 위치 혹은 컨텍스트를 로드할때 사용되는 클래스의 컴포넌트를 선언
 */
@Configuration
@ComponentScan(basePackages = "com.b4.apollo")
//@MapperScan("com.b4.apollo.cart.model.dao")
public class ContextConfiguration {

}
