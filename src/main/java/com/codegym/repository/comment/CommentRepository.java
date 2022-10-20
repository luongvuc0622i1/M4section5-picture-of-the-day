package com.codegym.repository.comment;

import com.codegym.model.Comment;

//import javax.persistence.*;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class CommentRepository implements ICommentRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Comment> findAll() {
        String queryStr = "SELECT c FROM com.codegym.model.Comment AS c";
        TypedQuery<Comment> query = em.createQuery(queryStr, Comment.class);
        return query.getResultList();
    }

    @Override
    public Comment findById(Long id) {
        String queryStr = "SELECT c FROM com.codegym.model.Comment AS c WHERE c.id=:id";
        TypedQuery<Comment> query = em.createQuery(queryStr, Comment.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(Comment model) {
        if (model.getId() != null) {
            em.merge(model);
        } else {
            em.persist(model);
        }
    }

    @Override
    public void remove(Long id) {
        Comment model = findById(id);
        if (model != null) {
            em.remove(model);
        }
    }

    @Override
    public void addLike(Comment comment) {

    }

    @Override
    public void disLike(Comment model) {

    }
}