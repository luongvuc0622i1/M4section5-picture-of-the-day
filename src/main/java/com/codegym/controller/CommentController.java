package com.codegym.controller;

import com.codegym.model.Comment;
import com.codegym.service.comment.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
//@RequestMapping("customers")
public class CommentController {
    @Autowired
    private ICommentService commentService;

    @GetMapping("/start")
    public ModelAndView showHome() {
        ModelAndView modelAndView = new ModelAndView("/home");
        List<Comment> comments = commentService.findAll();
        modelAndView.addObject("comments", comments);
        return modelAndView;
    }

    @GetMapping("/saveComment")
    public String addComment(Comment comment) {
        commentService.save(comment);
        return "redirect:/start";
    }

    @GetMapping("/likeComment/{id}")
    public String like(@PathVariable Long id){
        Comment comment=commentService.findById(id);
        commentService.addLike(comment);
        return "redirect:/start";
    }

    @GetMapping("/dislikeComment/{id}")
    public String dislike(@PathVariable Long id){
        Comment comment=commentService.findById(id);
        commentService.disLike(comment);
        return "redirect:/start";
    }


}