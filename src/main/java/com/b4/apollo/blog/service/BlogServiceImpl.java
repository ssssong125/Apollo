package com.b4.apollo.blog.service;


import com.b4.apollo.blog.model.dao.BlogMapper;
import com.b4.apollo.blog.model.dto.BlogDTO;
import com.b4.apollo.qna.exception.CommonException;
import com.b4.apollo.qna.exception.DataNotFoundException;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.io.file.PathUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;


    @Override
    public BlogDTO selectBlog(int blogNo) {
        blogMapper.updateCount(blogNo);

        Optional<BlogDTO> blog = Optional.ofNullable(this.blogMapper.selectBlog(blogNo));

        if (blog.isPresent()) {
            return blog.get();
        } else {
            throw new DataNotFoundException("question not found");
        }
    }

    @Override
    public void insertBlog(String reporter, String blogTitle, String blogContent, MultipartFile file) throws IOException {
        BlogDTO blog = new BlogDTO();

        String projectPath = System.getProperty("user.dir") + "/src/main/resources/static\\upload";
        UUID uuid = UUID.randomUUID();

        String originName = file.getOriginalFilename();
        String fileName = uuid+"_"+file.getOriginalFilename();

        File saveFile = new File(projectPath, fileName);

        try {
            file.transferTo(saveFile);
        } catch (IllegalStateException | IOException e){
            e.printStackTrace();
            throw new CommonException("file Upload Error");
        }
        blog.setReporter(reporter);
        blog.setBlogTitle(blogTitle);
        blog.setBlogContent(blogContent);
        blog.setFileName(fileName);
        blog.setFilePath("\\upload\\" + fileName);

        blogMapper.insertBlog(blog);
    }

    @Override
    public void updateBlog(BlogDTO blog, String blogTitle, String blogContent, MultipartFile file) throws IOException {

        String orgChangeName = blog.getFileName();
        String projectPath = System.getProperty("user.dir") + "/src/main/resources/static\\upload";

        UUID uuid = UUID.randomUUID();

        if(!file.getOriginalFilename().equals("")){
            String fileName = uuid+"_"+file.getOriginalFilename();
            blog.setFileName(fileName);
            blog.setFilePath("\\upload\\" + fileName);
        }
        blog.setBlogTitle(blogTitle);
        blog.setBlogContent(blogContent);

        if(orgChangeName != null) {
            PathUtils.deleteFile(Paths.get(orgChangeName));
        }

        int result = blogMapper.updateBlog(blog);

        if(result < 0) {
            throw new CommonException("글 수정 실패 ");
        }
    }

    @Override
    public void deleteBlog(int blogNo) {
        int result = blogMapper.deleteBlog(blogNo);

        if(result < 0) {
            throw new CommonException("삭제실패 ");
        }
    }

    @Override
    public Page<BlogDTO> selectList(int pageNum) {
        PageHelper.startPage(pageNum, 10);
        return blogMapper.selectList();
    }
}

