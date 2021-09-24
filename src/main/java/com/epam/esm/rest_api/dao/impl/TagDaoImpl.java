package com.epam.esm.rest_api.dao.impl;

import com.epam.esm.rest_api.dao.ConstantQuery;
import com.epam.esm.rest_api.dao.TagDao;
import com.epam.esm.rest_api.entity.Tag;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TagDaoImpl implements TagDao {

    private JdbcTemplate jdbcTemplate;

    public TagDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean add(Tag tag) {
        int result = jdbcTemplate.update(ConstantQuery.CREATE_TAG_QUERY, tag.getName());
        return (result == 1);
    }

    @Override
    public Tag find(Long id) {
        return jdbcTemplate.query(ConstantQuery.FIND_TAG_QUERY, new BeanPropertyRowMapper<>(Tag.class),
                new Object[]{id})
                .stream()
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Tag> findAll() {
        return jdbcTemplate.query(ConstantQuery.FIND_ALL_TAGS_QUERY,
                new BeanPropertyRowMapper<>(Tag.class));
    }

    @Override
    public Tag update(Tag tag) {
        int result = jdbcTemplate.update(ConstantQuery.UPDATE_TAG_QUERY, tag.getName(), tag.getId());
        return (result == 1) ? tag : null;
    }

    @Override
    public boolean remove(Long id) {
        int result = jdbcTemplate.update(ConstantQuery.DELETE_TAG_QUERY, id);
        return (result == 1);
    }

}
