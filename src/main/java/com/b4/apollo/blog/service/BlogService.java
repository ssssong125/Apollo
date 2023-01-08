package com.b4.apollo.blog.service;

import com.b4.apollo.blog.model.dto.BlogDTO;
import com.github.pagehelper.Page;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface BlogService {


   
    BlogDTO selectBlog(int blogNo);

    void insertBlog(String userId, String blogTitle, String blogContent, MultipartFile file) throws IOException;

    void updateBlog(BlogDTO blog, String blogTitle, String blogContent, MultipartFile file) throws IOException;

    void deleteBlog(int blogNo);

    Page<BlogDTO> selectList(int pageNum);
}
