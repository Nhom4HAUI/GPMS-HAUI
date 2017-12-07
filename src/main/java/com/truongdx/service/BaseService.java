package com.truongdx.service;

import org.springframework.stereotype.Service;

import java.util.List;

public interface BaseService<T> {

    Iterable<T> findAll();

    List<T> seach(String q);

    T findOne(int id);

    void save(T data);

    void delete(int id);
}
