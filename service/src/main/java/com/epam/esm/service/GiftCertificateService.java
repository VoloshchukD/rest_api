package com.epam.esm.service;

import com.epam.esm.entity.GiftCertificate;

import java.util.List;

public interface GiftCertificateService extends BaseService<GiftCertificate> {

    GiftCertificate findByTagName(String tagName);

    List<GiftCertificate> findByNameAndDescription(String name, String description);

    List<GiftCertificate> findSorted(String sortingParameter, boolean descending);

}
