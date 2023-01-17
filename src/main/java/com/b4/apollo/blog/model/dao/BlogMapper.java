package com.b4.apollo.blog.model.dao;

import com.b4.apollo.blog.model.dto.BlogDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 @FileName : BlogMapper.java
 @Project : Apollo
 @Date : 2023. 01. 06.
 @작성자 : 이현도
 @프로그램 설명 : 서버 구동 프로그램
 */
@Repository
@Mapper
public interface BlogMapper {


    BlogDTO selectBlog(int pageNum);

    void insertBlog(BlogDTO blog);

    Page<BlogDTO> selectList();

    void updateCount(int blogNo);

    int updateBlog(BlogDTO blog);

    int deleteBlog(int blogNo);

}
