package com.epam.esm.rest_api.dao;

import com.epam.esm.rest_api.entity.GiftCertificate;

import java.util.List;

public interface GiftCertificateDao extends BaseDao<GiftCertificate> {

    GiftCertificate findByTagName(String tagName);

    List<GiftCertificate> findByNameAndDescription(String name, String description);

    List<GiftCertificate> findSorted(String sortingParameter, boolean descending);

}
