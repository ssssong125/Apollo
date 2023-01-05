package com.b4.apollo.blog.service;//package com.b4.apollo.blog.post.service;

import com.b4.apollo.blog.model.dao.AttachMapper;
import com.b4.apollo.blog.model.dao.BlogMapper;
import com.b4.apollo.blog.model.dto.AttachDTO;
import com.b4.apollo.blog.model.dto.BlogDTO;
import com.b4.apollo.blog.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Autowired
    private AttachMapper attachMapper;

    @Autowired
    private FileUtils fileUtils;

    @Override
    public boolean registerBlog(BlogDTO params) {
        int queryResult = 0;

        if (params.getBlogNo() == null) {
            queryResult = blogMapper.insertBlog(params);
        } else {
            queryResult = blogMapper.updateBlog(params);
        }

        return (queryResult == 1) ? true : false;
    }

    @Override
    public boolean registerBlog(BlogDTO params, MultipartFile[] files) {
        int queryResult = 1;

        if (registerBlog(params) == false) {
            return false;
        }

        List<AttachDTO> fileList = fileUtils.uploadFiles(files, params.getBlogNo());
        if (CollectionUtils.isEmpty(fileList) == false) {
            queryResult = attachMapper.insertAttach(fileList);
            if (queryResult < 1) {
                queryResult = 0;
            }
        }
        return (queryResult > 0);
    }

    @Override
    public boolean getBlogDetail(int blogNo) {
            return blogMapper.selectBlogDetail(blogNo);
    }

    @Override
    public boolean deleteBlog(int blogNo) {
            int queryResult = 0;

            BlogDTO blog = blogMapper.selectBoardDetail(blogNo);

            if (blog != null && "N".equals(blog.getBlogDel())) {
                queryResult = blogMapper.deleteBoard(blogNo);
            }

            return (queryResult == 1) ? true : false;
    }

    @Override
    public List<AttachDTO> getAttachFileList(int blogNo) {
        return null;
    }

    @Override
    public void registerBlog(String blogTitle, String blogContent, MultipartFile[] files) {

    }


}
