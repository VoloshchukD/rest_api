package com.epam.esm.rest_api.service.impl;

import com.epam.esm.rest_api.dao.GiftCertificateDao;
import com.epam.esm.rest_api.entity.GiftCertificate;
import com.epam.esm.rest_api.service.GiftCertificateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiftCertificateServiceImpl implements GiftCertificateService {

    private GiftCertificateDao giftCertificateDao;

    public GiftCertificateServiceImpl(GiftCertificateDao giftCertificateDao) {
        this.giftCertificateDao = giftCertificateDao;
    }

    @Override
    public boolean add(GiftCertificate certificate) {
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
        return giftCertificateDao.update(certificate);
    }

    @Override
    public boolean remove(Long id) {
        return giftCertificateDao.remove(id);
    }

}
