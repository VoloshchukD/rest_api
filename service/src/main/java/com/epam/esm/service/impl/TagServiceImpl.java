package com.epam.esm.service.impl;

import com.epam.esm.dao.TagDao;
import com.epam.esm.entity.Tag;
import com.epam.esm.service.TagService;
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
        Tag updated = tagDao.update(tag);
        if (updated != null) {
            updated = find(tag.getId());
        }
        return updated;
    }

    @Override
    public boolean delete(Long id) {
        return tagDao.delete(id);
    }

    @Override
    public boolean addTagToCertificate(Long certificateId, Long tagId) {
        return tagDao.addTagToCertificate(certificateId, tagId);
    }

    @Override
    public boolean deleteTagFromCertificate(Long certificateId, Long tagId) {
        return tagDao.deleteTagFromCertificate(certificateId, tagId);
    }

}
