package com.epam.esm.rest_api.dao;

public interface BaseDao<T> {

    boolean add(T t);

    T find(Long id);

    T update(T t);

    boolean remove(Long id);

}
