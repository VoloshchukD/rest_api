package com.epam.esm.rest_api.dao;

import com.epam.esm.rest_api.entity.Tag;

public interface TagDao extends BaseDao<Tag> {

    boolean addTagToCertificate(Long certificateId, Long tagId);

    boolean deleteTagFromCertificate(Long certificateId, Long tagId);

}
