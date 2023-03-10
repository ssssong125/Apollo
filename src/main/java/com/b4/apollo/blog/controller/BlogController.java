package com.b4.apollo.blog.controller;

import com.b4.apollo.blog.exception.CommonException;
import com.b4.apollo.blog.model.dto.BlogDTO;
import com.b4.apollo.blog.model.dto.BlogForm;
import com.b4.apollo.blog.model.dto.CommentDTO;
import com.b4.apollo.blog.service.BlogService;
import com.b4.apollo.cart.model.dto.CartDTO;
import com.b4.apollo.cart.model.service.CartService;
import com.b4.apollo.blog.service.CommentService;
import com.b4.apollo.qna.model.dto.QuestionDTO;
import com.b4.apollo.user.model.dto.UserDTO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 @FileName : BlogController.java
 @Project : Apollo
 @Date : 2023. 01. 06.
 @작성자 : 이현도
 @프로그램 설명 : 블로그 컨트롤러
 */
@RequestMapping("/blog")
@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private CartService cartService;

    // 블로그 리스트
    @GetMapping("/list")
    public String selectList(HttpSession session, BlogDTO blog, @RequestParam(required = false, defaultValue = "1") int pageNum, Model model) {

        PageInfo<BlogDTO> list = new PageInfo<>(blogService.selectList(pageNum), 10);
        String reporter = (String) session.getAttribute("userId");
        UserDTO user = new UserDTO();

        System.out.println("reporter = " + reporter);
        System.out.println("blogReporter = " + blog.getReporter());

        model.addAttribute("reporter", reporter);
        model.addAttribute("user", user);
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
    public String blogCreate(HttpSession session, @Valid BlogForm blogForm, BindingResult bindingResult, MultipartFile file) throws Exception {
        if (bindingResult.hasErrors()) {
            return "/blog/blogForm";
        }

        BlogDTO blog = new BlogDTO();

        String reporter = (String) session.getAttribute("userId");

        try {
            if (reporter.equals("admin")){
                blogService.insertBlog(reporter, blogForm.getBlogTitle(), blogForm.getBlogContent(), file);
                return "redirect:/blog/list";
            }
        }catch(NullPointerException e){
            return "redirect:/main";
        } catch(Exception e){
            e.printStackTrace();
            throw new CommonException("에러 발생");
        }
        return "redirect:/main";
    }

     //질문 게시판 상세 조회
    @GetMapping(value = "/detail/{bno}")
    public String selectBlog(HttpSession session, @PathVariable("bno") int bno, Model model) {
        BlogDTO blog = blogService.selectBlog(bno);
        CommentDTO comm = new CommentDTO();
        blog.getReporter();
        
        String reporter = (String) session.getAttribute("userId");
        System.out.println("reporter = " + reporter);
        System.out.println("blog.getReporter() = " + blog.getReporter());
        
        model.addAttribute("reporter", reporter);
        model.addAttribute("comm", comm);
        model.addAttribute("blog", blog);
        return "/blog/blogDetail";
    }

    // 질문 수정
    @GetMapping("/modify/{blogNo}")
    public String blogModify(HttpSession session, BlogForm blogForm, @PathVariable("blogNo") int blogNo) {
        BlogDTO blog = this.blogService.selectBlog(blogNo);
        
        String reporter = (String) session.getAttribute("userId");

        blog.setReporter(reporter);
        blogForm.setBlogTitle(blog.getBlogTitle());
        blogForm.setBlogContent(blog.getBlogContent());
        return "/blog/blogForm";
    }

    @PostMapping("/modify/{blogNo}")
    public String blogModify(HttpSession session, @Valid BlogForm blogForm, BindingResult bindingResult,
                                 @PathVariable("blogNo") int blogNo, MultipartFile file) throws IOException {
        if (bindingResult.hasErrors()) {
            return "/blog/blogForm";
        }
        BlogDTO blog = this.blogService.selectBlog(blogNo);

        String reporter = (String) session.getAttribute("userId");

        try{
            if(reporter.equals("admin")){
                this.blogService.updateBlog(blog, blogForm.getBlogTitle(), blogForm.getBlogContent(), file);
                return String.format("redirect:/blog/detail/%s", blogNo);
            }
        }catch(NullPointerException e){
            throw new CommonException("관리자만 수정 가능합니다.");
        }catch(Exception e) {
            throw new CommonException("에러 발생");
        }
        return "redirect:/main";
    }

    // 게시글 삭제
    @GetMapping("/delete/{blogNo}")
    private String deleteBlog(HttpSession session, @PathVariable("blogNo")  int blogNo) {

        BlogDTO blog = this.blogService.selectBlog(blogNo);

        String reporter = (String) session.getAttribute("userId");

        try {
            if (reporter.equals("admin")) {
                blogService.deleteBlog(blogNo);
                return "redirect:/blog/list";
            }
        } catch(NullPointerException e){
            throw new CommonException("관리자만 삭제 가능합니다.");
        } catch(Exception e) {
            throw new CommonException("에러 발생");
        }
        return "redirect:/main";
    }
    /**
     * @MethodName : headerBadge
     * @작성일 : 2023. 01. 17.
     * @작성자 : 김수용
     * @Method 설명 : GetMapping방식으로 현재 장바구니에 담긴 상품수를 헤더 카트 아이콘 옆에 뱃지로 표현
     */
    @GetMapping("/header")
    public void headerBadge(HttpSession session, Model model){

        String userId = (String) session.getAttribute("userId");

        if (userId != null){

            List<CartDTO> cartList = cartService.getCartList(userId);
            model.addAttribute("cartList", cartList);
        }
    }
}
