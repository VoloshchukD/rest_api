package com.epam.esm.rest_api.service.impl;

import com.epam.esm.rest_api.dao.TagDao;
import com.epam.esm.rest_api.entity.Tag;
import com.epam.esm.rest_api.service.TagService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    private TagDao tagDao;

    public TagServiceImpl(TagDao tagDao) {
        this.tagDao = tagDao;
    }

    @Override
    public boolean add(Tag tag) {
        return tagDao.add(tag);
    }

    @Override
    public Tag find(Long id) {
        return tagDao.find(id);
    }

    @Override
    public List<Tag> findAll() {
        return tagDao.findAll();
    }

    @Override
    public Tag update(Tag tag) {
        return tagDao.update(tag);
    }

    @Override
    public boolean delete(Long id) {
        return tagDao.delete(id);
    }

}
