package com.b4.apollo.blog.post.controller;//package com.b4.apollo.blog.post.controller;

import com.b4.apollo.blog.post.model.dto.AttachDTO;
import com.b4.apollo.blog.post.model.dto.BlogDTO;
import com.b4.apollo.blog.post.model.dto.BlogForm;
import com.b4.apollo.blog.post.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    //게시글 작성
    @GetMapping("/create")
    public String insertBlog(){
        return "/blog/blog_form";
    }
    @PostMapping("/create")
    public String registerBlog(@Valid BlogForm blogForm, MultipartFile[] files, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "/blog/blog_form";
        }

        blogService.registerBlog(blogForm.getBlogTitle(), blogForm.getBlogContent(), files);
        return "redirect:/blog/list";
    }

//    @GetMapping(value = "/board/write")
//    public String openBoardWrite(@ModelAttribute("params") BlogDTO params
//            , @RequestParam(value = "blogNo", required = false) int blogNo, Model model) {
//            BlogDTO blog = blogService.getBlogDetail(blogNo);
//            model.addAttribute("blog", blog);
//
//            List<AttachDTO> fileList = blogService.getAttachFileList(blogNo);
//            model.addAttribute("fileList", fileList);
//
//        return "board/write";
//    }
//
//    @PostMapping(value = "/board/register")
//    public String registerBoard(final BlogDTO params, final MultipartFile[] files, Model model) {
//        Map<String, Object> pagingParams = getPagingParams(params);
//        try {
//            boolean isRegistered = boardService.registerBoard(params, files);
//            if (isRegistered == false) {
//                return showMessageWithRedirect("게시글 등록에 실패하였습니다.", "/board/list.do", Method.GET, pagingParams, model);
//            }
//        } catch (DataAccessException e) {
//            return showMessageWithRedirect("데이터베이스 처리 과정에 문제가 발생하였습니다.", "/board/list.do", Method.GET, pagingParams, model);
//
//        } catch (Exception e) {
//            return showMessageWithRedirect("시스템에 문제가 발생하였습니다.", "/board/list.do", Method.GET, pagingParams, model);
//        }
//
//        return showMessageWithRedirect("게시글 등록이 완료되었습니다.", "/board/list.do", Method.GET, pagingParams, model);
//    }
//
//    @GetMapping(value = "/board/list.do")
//    public String openBoardList(@ModelAttribute("params") BoardDTO params, Model model) {
//        List<BoardDTO> boardList = boardService.getBoardList(params);
//        model.addAttribute("boardList", boardList);
//
//        return "board/list";
//    }
//
//    @GetMapping(value = "/board/view.do")
//    public String openBoardDetail(@ModelAttribute("params") BoardDTO params, @RequestParam(value = "idx", required = false) Long idx, Model model) {
//        if (idx == null) {
//            return showMessageWithRedirect("올바르지 않은 접근입니다.", "/board/list.do", Method.GET, null, model);
//        }
//
//        BoardDTO board = boardService.getBoardDetail(idx);
//        if (board == null || "Y".equals(board.getDeleteYn())) {
//            return showMessageWithRedirect("없는 게시글이거나 이미 삭제된 게시글입니다.", "/board/list.do", Method.GET, null, model);
//        }
//        model.addAttribute("board", board);
//
//        List<AttachDTO> fileList = boardService.getAttachFileList(idx); // 추가된 로직
//        model.addAttribute("fileList", fileList); // 추가된 로직
//
//        return "board/view";
//    }
//
//    @PostMapping(value = "/board/delete.do")
//    public String deleteBoard(@ModelAttribute("params") BoardDTO params, @RequestParam(value = "idx", required = false) Long idx, Model model) {
//        if (idx == null) {
//            return showMessageWithRedirect("올바르지 않은 접근입니다.", "/board/list.do", Method.GET, null, model);
//        }
//
//        Map<String, Object> pagingParams = getPagingParams(params);
//        try {
//            boolean isDeleted = boardService.deleteBoard(idx);
//            if (isDeleted == false) {
//                return showMessageWithRedirect("게시글 삭제에 실패하였습니다.", "/board/list.do", Method.GET, pagingParams, model);
//            }
//        } catch (DataAccessException e) {
//            return showMessageWithRedirect("데이터베이스 처리 과정에 문제가 발생하였습니다.", "/board/list.do", Method.GET, pagingParams, model);
//
//        } catch (Exception e) {
//            return showMessageWithRedirect("시스템에 문제가 발생하였습니다.", "/board/list.do", Method.GET, pagingParams, model);
//        }
//
//        return showMessageWithRedirect("게시글 삭제가 완료되었습니다.", "/board/list.do", Method.GET, pagingParams, model);
//    }

}
