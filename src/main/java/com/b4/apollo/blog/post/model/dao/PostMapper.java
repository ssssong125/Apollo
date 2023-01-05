package com.b4.apollo.blog.post.model.dao;//package com.b4.apollo.blog.post.model.dao;

import com.b4.apollo.blog.post.model.dto.PostDTO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PostMapper {

    //목록
    Page<PostDTO> selectList();

    //상세보기
    PostDTO selectPost(int bno);


    // 등록
    int insertPost(PostDTO po);

    //업데이트
    int updatePost(PostDTO po);

    //삭제
    int deletePost(int blogNo);


}
