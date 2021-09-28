package com.epam.esm.rest_api.service;

import com.epam.esm.rest_api.entity.GiftCertificate;

import java.util.List;

public interface GiftCertificateService extends BaseService<GiftCertificate> {

    GiftCertificate findByTagName(String tagName);

    List<GiftCertificate> findByNameAndDescription(String name, String description);

    List<GiftCertificate> findSorted(String sortingParameter, boolean descending);

}
