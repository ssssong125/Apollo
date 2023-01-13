package com.b4.apollo.blog.controller;

import com.b4.apollo.blog.model.dto.BlogDTO;
import com.b4.apollo.blog.model.dto.CommentDTO;
import com.b4.apollo.blog.service.BlogService;
import com.b4.apollo.blog.service.CommentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.xml.stream.events.Comment;
import java.util.List;


@RestController
@RequestMapping("/comment/*")
public class CommentController {

    @Autowired
    private CommentService commentService;



}
