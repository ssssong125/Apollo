package com.b4.apollo.blog.post.service;//package com.b4.apollo.blog.post.service;

import com.b4.apollo.blog.post.model.dao.PostMapper;
import com.b4.apollo.blog.post.model.dto.PostDTO;
import com.b4.apollo.qna.exception.DataNotFoundException;
import com.b4.apollo.qna.model.dto.QuestionDTO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class postServiceImpl implements postService{

    @Autowired
    private PostMapper postMapper;

    @Override
    public Page<PostDTO> selectList(int pageNum) {
        PageHelper.startPage(pageNum, 10);
        return postMapper.selectList();
    }

    @Override
    public PostDTO selectPost(int bno) {
        Optional<PostDTO> po = Optional.ofNullable((PostDTO) this.postMapper.selectPost(bno));
        if (po.isPresent()) {
            return po.get();
        } else {
            throw new DataNotFoundException("Post not found");
        }
    }

    @Override
    public int insertPost(PostDTO po) {
        return postMapper.insertPost(po);
    }

    @Override
    public int updatePost(PostDTO po) {
        return postMapper.updatePost(po);
    }

    @Override
    public int deletePost(int blogNo) {
        return postMapper.deletePost(blogNo);
    }
}
