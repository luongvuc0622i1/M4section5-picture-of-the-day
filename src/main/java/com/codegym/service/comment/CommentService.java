package com.codegym.service.comment;

import com.codegym.model.Comment;
import com.codegym.repository.comment.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CommentService implements ICommentService {

    @Autowired
    private ICommentRepository commentRepository;

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment findById(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public void save(Comment model) {
        commentRepository.save(model);
    }

    @Override
    public void remove(Long id) {
        commentRepository.remove(id);
    }

    @Override
    public void addLike(Comment model) {
        commentRepository.addLike(model);
    }

    @Override
    public void disLike(Comment model) {
        commentRepository.disLike(model);
    }
}
