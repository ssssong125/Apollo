package com.b4.apollo.blog.post.model.dao;//package com.b4.apollo.blog.post.model.dao;

import com.b4.apollo.blog.post.model.dto.BlogDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BlogMapper {

    //목록
    Page<BlogDTO> selectList();

    //상세보기
    BlogDTO selectPost(int bno);


    // 등록
    int insertPost(BlogDTO po);

    //업데이트
    int updatePost(BlogDTO po);

    //삭제
    int deletePost(int blogNo);


    int insertBlog(BlogDTO params);

    int updateBlog(BlogDTO params);

    boolean selectBlogDetail(int blogNo);

    BlogDTO selectBoardDetail(int blogNo);

    int deleteBoard(int blogNo);
}
