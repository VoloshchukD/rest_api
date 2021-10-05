package com.epam.esm.service;

import com.epam.esm.service.exception.ParameterNotPresentException;

import java.util.List;

public interface BaseService<T> {

    boolean add(T t);

    T find(Long id) throws ParameterNotPresentException;

    List<T> findAll();

    T update(T t) throws ParameterNotPresentException;

    boolean delete(Long id) throws ParameterNotPresentException;

}
