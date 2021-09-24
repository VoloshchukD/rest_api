package com.epam.esm.rest_api.service;

import java.util.List;

public interface BaseService<T> {

    boolean add(T t);

    T find(Long id);

    List<T> findAll();

    T update(T t);

    boolean remove(Long id);

}
