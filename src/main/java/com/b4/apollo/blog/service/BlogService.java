package com.b4.apollo.blog.service;

import com.b4.apollo.blog.model.dto.BlogDTO;
import com.github.pagehelper.Page;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

/**
 @FileName : BlogService.java
 @Project : Apollo
 @Date : 2023. 01. 06.
 @작성자 : 이현도
 @프로그램 설명 : 블로그 관련 요청을 처리할 Service interface
 */
public interface BlogService {
   
    BlogDTO selectBlog(int blogNo);

    void insertBlog(String reporter, String blogTitle, String blogContent, MultipartFile file) throws IOException;

    void updateBlog(BlogDTO blog, String blogTitle, String blogContent, MultipartFile file) throws IOException;

    void deleteBlog(int blogNo);

    Page<BlogDTO> selectList(int pageNum);
}
