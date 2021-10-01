package com.epam.esm.service;

import com.epam.esm.entity.Tag;

public interface TagService extends BaseService<Tag> {

    boolean addTagToCertificate(Long certificateId, Long tagId);

    boolean deleteTagFromCertificate(Long certificateId, Long tagId);

}