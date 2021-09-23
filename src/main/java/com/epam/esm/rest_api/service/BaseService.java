package com.epam.esm.rest_api.service;

public interface BaseService<T> {

    boolean add(T t);

    T find(Long id);

    T update(T t);

    boolean remove(Long id);

}
