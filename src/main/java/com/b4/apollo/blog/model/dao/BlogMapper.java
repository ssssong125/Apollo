package com.b4.apollo.blog.model.dao;

import com.b4.apollo.blog.model.dto.BlogDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

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
