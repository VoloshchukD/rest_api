package com.epam.esm.dao.impl;

import com.epam.esm.dao.ConstantQuery;
import com.epam.esm.dao.GiftCertificateDao;
import com.epam.esm.entity.GiftCertificate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    @Override
    public GiftCertificate update(GiftCertificate giftCertificate) {
        int result = jdbcTemplate.update(ConstantQuery.UPDATE_GIFT_CERTIFICATE_QUERY,
                giftCertificate.getName(), giftCertificate.getDescription(),
                giftCertificate.getPrice(), giftCertificate.getDuration(),
                giftCertificate.getCreateDate(), giftCertificate.getLastUpdateDate(),
                giftCertificate.getId());
        return (result == 1) ? giftCertificate : null;
    }

    @Transactional
    @Override
    public boolean delete(Long id) {
        jdbcTemplate.update(ConstantQuery.DELETE_TAG_FROM_CERTIFICATES_QUERY_BY_CERTIFICATE_ID, id);
        int affectedRows = jdbcTemplate.update(ConstantQuery.DELETE_GIFT_CERTIFICATE_QUERY, id);
        return (affectedRows == 1);
    }

    @Override
    public GiftCertificate findByTagName(String tagName) {
        return jdbcTemplate.query(ConstantQuery.FIND_CERTIFICATE_BY_TAG_NAME,
                new BeanPropertyRowMapper<>(GiftCertificate.class),
                new Object[]{tagName})
                .stream()
                .findAny()
                .orElse(null);
    }

    @Override
    public List<GiftCertificate> findByNameAndDescription(String name, String description) {
        return jdbcTemplate.query(ConstantQuery.FIND_CERTIFICATES_BY_PART_OF_NAME_AND_DESCRIPTION,
                new BeanPropertyRowMapper<>(GiftCertificate.class),
                ConstantQuery.PERCENT + name + ConstantQuery.PERCENT,
                ConstantQuery.PERCENT + description + ConstantQuery.PERCENT);
    }

    @Override
    public List<GiftCertificate> findSorted(String sortingParameter, boolean descending) {
        return jdbcTemplate.query(ConstantQuery.FIND_CERTIFICATES_SORTED,
                new BeanPropertyRowMapper<>(GiftCertificate.class), sortingParameter, descending);
    }

}
