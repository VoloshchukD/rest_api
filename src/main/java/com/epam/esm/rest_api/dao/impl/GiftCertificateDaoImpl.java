package com.epam.esm.rest_api.dao.impl;

import com.epam.esm.rest_api.dao.ConstantQuery;
import com.epam.esm.rest_api.dao.GiftCertificateDao;
import com.epam.esm.rest_api.entity.GiftCertificate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GiftCertificateDaoImpl implements GiftCertificateDao {

    private JdbcTemplate jdbcTemplate;

    public GiftCertificateDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean add(GiftCertificate giftCertificate) {
        int result = jdbcTemplate.update(ConstantQuery.CREATE_GIFT_CERTIFICATE_QUERY,
                giftCertificate.getName(), giftCertificate.getDescription(),
                giftCertificate.getPrice(), giftCertificate.getDuration(),
                giftCertificate.getCreateDate(), giftCertificate.getLastUpdateDate());
        return (result == 1);
    }

    @Override
    public GiftCertificate find(Long id) {
        return jdbcTemplate.query(ConstantQuery.FIND_GIFT_CERTIFICATE_QUERY,
                new BeanPropertyRowMapper<>(GiftCertificate.class),
                new Object[]{id})
                .stream()
                .findAny()
                .orElse(null);
    }

    @Override
    public List<GiftCertificate> findAll() {
        return jdbcTemplate.query(ConstantQuery.FIND_ALL_GIFT_CERTIFICATES_QUERY,
                new BeanPropertyRowMapper<>(GiftCertificate.class));
    }

    @Override
    public GiftCertificate update(GiftCertificate giftCertificate) {
        int result = jdbcTemplate.update(ConstantQuery.UPDATE_GIFT_CERTIFICATE_QUERY,
                giftCertificate.getName(), giftCertificate.getDescription(),
                giftCertificate.getPrice(), giftCertificate.getDuration(),
                giftCertificate.getCreateDate(), giftCertificate.getLastUpdateDate(),
                giftCertificate.getId());
        GiftCertificate resultEntity = null;
        if (result == 1) {
            resultEntity = giftCertificate;
        }
        return resultEntity;
    }

    @Override
    public boolean remove(Long id) {
        int result = jdbcTemplate.update(ConstantQuery.DELETE_GIFT_CERTIFICATE_QUERY, id);
        return (result == 1);
    }

}
