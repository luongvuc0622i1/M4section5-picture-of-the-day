package com.codegym.repository;

import java.util.List;

public interface IGenericRepository<T> {
    List<T> findAll();
    T findById(Long id);
    void save(T model);
    void remove(Long id);
    void addLike(T model);
    void disLike(T model);
}
