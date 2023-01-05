package com.b4.apollo.blog.post.service;//package com.b4.apollo.blog.post.service;

import com.b4.apollo.blog.post.model.dto.PostDTO;
import com.github.pagehelper.Page;

public interface postService {

    //목록
    Page<PostDTO> selectList(int pageNum);

    //상세보기
    PostDTO selectPost(int bno);


    // 등록
    int insertPost(PostDTO po);

    //업데이트
    int updatePost(PostDTO po);

    //삭제
    int deletePost(int blogNo);
}
