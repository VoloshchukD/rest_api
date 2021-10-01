package com.epam.esm.service.impl;

import com.epam.esm.dao.GiftCertificateDao;
import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.service.GiftCertificateService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GiftCertificateServiceImpl implements GiftCertificateService {

    private GiftCertificateDao giftCertificateDao;

    public GiftCertificateServiceImpl(GiftCertificateDao giftCertificateDao) {
        this.giftCertificateDao = giftCertificateDao;
    }

    @Override
    public boolean add(GiftCertificate certificate) {
        Date currentDate = new Date();
        certificate.setCreateDate(currentDate);
        certificate.setLastUpdateDate(currentDate);
        return giftCertificateDao.add(certificate);
    }

    @Override
    public GiftCertificate find(Long id) {
        return giftCertificateDao.find(id);
    }

    @Override
    public List<GiftCertificate> findAll() {
        return giftCertificateDao.findAll();
    }

    @Override
    public GiftCertificate update(GiftCertificate certificate) {
        certificate.setLastUpdateDate(new Date());
        GiftCertificate updated = giftCertificateDao.update(certificate);
        if (updated != null) {
            updated = find(certificate.getId());
        }
        return updated;
    }

    @Override
    public boolean delete(Long id) {
        return giftCertificateDao.delete(id);
    }

    @Override
    public GiftCertificate findByTagName(String tagName) {
        return giftCertificateDao.findByTagName(tagName);
    }

    @Override
    public List<GiftCertificate> findByNameAndDescription(String name, String description) {
        return giftCertificateDao.findByNameAndDescription(name, description);
    }

    @Override
    public List<GiftCertificate> findSorted(String sortingParameter, boolean descending) {
        return giftCertificateDao.findSorted(sortingParameter, descending);
    }

}
