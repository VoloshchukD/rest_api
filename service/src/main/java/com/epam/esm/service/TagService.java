package com.epam.esm.service;

import com.epam.esm.entity.Tag;
import com.epam.esm.service.exception.ParameterNotPresentException;

public interface TagService extends BaseService<Tag> {

    boolean addTagToCertificate(Long certificateId, Long tagId) throws ParameterNotPresentException;

    boolean addTagToCertificate(Tag tag, Long certificateId) throws ParameterNotPresentException;

    boolean deleteTagFromCertificate(Long certificateId, Long tagId) throws ParameterNotPresentException;

}
