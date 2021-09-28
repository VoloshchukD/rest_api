package com.epam.esm.rest_api.service;

import com.epam.esm.rest_api.entity.Tag;

public interface TagService extends BaseService<Tag> {

    boolean addTagToCertificate(Long certificateId, Long tagId);

    boolean deleteTagFromCertificate(Long certificateId, Long tagId);

}
