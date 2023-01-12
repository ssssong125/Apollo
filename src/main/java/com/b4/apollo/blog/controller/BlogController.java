package com.b4.apollo.blog.controller;

import com.b4.apollo.blog.model.dto.BlogDTO;
import com.b4.apollo.blog.model.dto.BlogForm;
import com.b4.apollo.blog.model.dto.CommentDTO;
import com.b4.apollo.blog.service.BlogService;
import com.b4.apollo.blog.service.CommentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/blog")
@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private CommentService commentService;
    private Map paramMap;


    @GetMapping("/list")
    public String selectList(BlogDTO blog, @RequestParam(required = false, defaultValue = "1") int pageNum, Model model) {

        PageInfo<BlogDTO> list = new PageInfo<>(blogService.selectList(pageNum), 10);

        model.addAttribute("blog", blog);
        model.addAttribute("list", list);
        return "blog/blogList";
    }

    // 게시글 작성
    @GetMapping("/create")
    public String insertBlog(BlogForm blogForm){
        return "blog/blogForm";
    }

    @PostMapping("/create")
    public String questionCreate(@Valid BlogForm blogForm, BindingResult bindingResult, MultipartFile file) throws IOException {
        if (bindingResult.hasErrors()) {
            return "/blog/blogForm";
        }
        blogService.insertBlog(blogForm.getUserId(), blogForm.getBlogTitle(), blogForm.getBlogContent(), file);
        return "redirect:/blog/list";
    }

     //질문 게시판 상세 조회
    @GetMapping(value = "/detail/{bno}")
    public String selectBlog(@PathVariable("bno") int bno, Model model) {
        BlogDTO blog = blogService.selectBlog(bno);
        CommentDTO comm = new CommentDTO();

        model.addAttribute("comm", comm);
        model.addAttribute("blog", blog);
        return "/blog/blogDetail";
    }

    // 질문 수정
    @GetMapping("/modify/{blogNo}")
    public String questionModify(BlogForm blogForm, @PathVariable("blogNo") int blogNo) {
        BlogDTO blog = this.blogService.selectBlog(blogNo);
        blogForm.setBlogTitle(blog.getBlogTitle());
        blogForm.setBlogContent(blog.getBlogContent());
        return "/blog/blogForm";
    }

    @PostMapping("/modify/{blogNo}")
    public String questionModify(@Valid BlogForm blogForm, BindingResult bindingResult,
                                 @PathVariable("blogNo") int blogNo, MultipartFile file) throws IOException {
        if (bindingResult.hasErrors()) {
            return "/blog/blogForm";
        }
        BlogDTO blog = this.blogService.selectBlog(blogNo);
        this.blogService.updateBlog(blog, blogForm.getBlogTitle(), blogForm.getBlogContent(), file);
        return String.format("redirect:/blog/detail/%s", blogNo);
    }

    @GetMapping("/delete/{blogNo}")
    private String deleteBlog(@PathVariable("blogNo")  int blogNo) {
        blogService.deleteBlog(blogNo);
        return "redirect:/blog/list";
    }

    @RequestMapping(value = "/view", method = { RequestMethod.POST })
    public String viewPostMethod(Model model, @RequestParam(required = false) Map<String, Object> param){
        this.paramMap = param;
        CommentDTO comm = new CommentDTO();
        comm.setCommWriter(param.get("commWriter").toString());
        comm.setBlogNo((Integer) param.get("blogNo"));

        //DB 댓글 추가
        commentService.insertComm(comm);

        // 댓글 리스트 추가
        model.addAttribute("commentList", commentService.getList(comm));

        // 수정&삭제 버튼 게시를 위한 유저 정보 전달
        Map<String, Object> userInform = new HashMap<String, Object>();
        userInform.put("commWriter", param.get("userId"));
        model.addAttribute("userInform", userInform);

        return "/view :: #commentTable";
    }



}
