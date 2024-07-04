package com.cydeo.service;

import java.util.List;

public interface ICrudService<T, S> {

    T save(T object);
    T findById(S id);
    List<T> findAll();
    void deleteById(S id);
    T update(T object);
}
