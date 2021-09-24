package com.epam.esm.rest_api.dao.impl;

import com.epam.esm.rest_api.dao.TagDao;
import com.epam.esm.rest_api.entity.Tag;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TagDaoImpl implements TagDao {

    @Override
    public boolean add(Tag tag) {
        return false;
    }

    @Override
    public Tag find(Long id) {
        return null;
    }

    @Override
    public List<Tag> findAll() {
        return null;
    }

    @Override
    public Tag update(Tag tag) {
        return null;
    }

    @Override
    public boolean remove(Long id) {
        return false;
    }

}
