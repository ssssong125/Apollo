package com.b4.apollo.blog.post.service;//package com.b4.apollo.blog.post.service;

import com.b4.apollo.blog.post.model.dto.AttachDTO;
import com.b4.apollo.blog.post.model.dto.BlogDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BlogService {

    public boolean registerBlog(BlogDTO params);

    public boolean registerBlog(BlogDTO params, MultipartFile[] files);

    public boolean getBlogDetail(int blogNo);

    public boolean deleteBlog(int blogNo);

    List<AttachDTO> getAttachFileList(int blogNo);

    void registerBlog(String blogTitle, String blogContent, MultipartFile[] files);
}
