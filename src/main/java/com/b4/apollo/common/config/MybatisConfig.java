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
 @FileName : MybatisConfig.java

 @Project : Apollo

 @Date : 2022. 12. 28.

 @작성자 : 김수용

 @프로그램 설명 : DB와 연결시 필요한 Mybatis 설정을 잡아줄 설정파일
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "com.b4.apollo", annotationClass = Mapper.class)
public class MybatisConfig {

    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SqlSessionFactory sqlSessoinFactory(DataSource datasource) throws Exception{
        SqlSessionFactoryBean seb  = new SqlSessionFactoryBean();
        Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mappers/**/*.xml");

        seb.setMapperLocations(res);

        seb.setDataSource(datasource);
        return seb.getObject();
    }

}
