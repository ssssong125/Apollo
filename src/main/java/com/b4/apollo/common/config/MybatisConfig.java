package com.b4.apollo.common.config;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 @FileName : ContextConfiguration.java
 @Project : Apollo
 @Date : 2022. 12. 28.
 @작성자 : 박유리
 @프로그램 설명 : mybatis와 연동하는 configuration class
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = {"com.b4.apollo"}, annotationClass = Mapper.class)
public class MybatisConfig {

//    @Autowired
//    ApplicationContext applicationContext;

    /**
     * @MethodName : transactionManager
     * @작성일 : 2022. 12. 28.
     * @작성자 : 김수용
     * @Method 설명 :
     * 스프링 트랜잭션을 가능하게 함, 명시된 DataSource는 스프링을 사용할때 일반적으로 사용한다면 어떠한 JDBC DataSource도 될 수 있다.
     * 단, 트랜잭션 관리자에 명시된 DataSource가 SqlSessionFactoryBean을 생성할때 사용된 것과 반드시 동일해야함(아니면 트랜잭션 관리 제대로 안됨).
     * @수정일 : 2022. 12. 30.
     * @수정자 : 이현도
     * Null 값 에러 해결하기 위해서  configuration.setCallSettersOnNulls(true); 추가
     */
    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }//

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean seb = new SqlSessionFactoryBean();


        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setCallSettersOnNulls(true);
        seb.setConfiguration(configuration);




        /*주석 처리*/
//        seb.setConfigLocation(applicationContext.getResource("classpath:/mybatis/mybatis-config.xml"));
       Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*.xml");
//        Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mappers/ProductDao.xml");
//       Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mappers/CartMapper.xml");
//       Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mappers/boardMapper.xml");
//        Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mappers/UserMapper.xml");


        seb.setMapperLocations(res);
        seb.setDataSource(dataSource);


        return seb.getObject();
    }

}

