package com.epam.esm.rest_api.dao;

public final class ConstantQuery {

    public static final String CREATE_GIFT_CERTIFICATE_QUERY = "INSERT INTO gift_certificates" +
            " (name, description, price, duration, create_date, last_update_date) VALUES (?, ?, ?, ?, ?, ?)";

    public static final String FIND_GIFT_CERTIFICATE_QUERY = "SELECT * FROM gift_certificates WHERE id = ?";

    public static final String FIND_ALL_GIFT_CERTIFICATES_QUERY = "SELECT * FROM gift_certificates";

    public static final String UPDATE_GIFT_CERTIFICATE_QUERY = "UPDATE gift_certificates " +
            "SET name = COALESCE(?, name), description = COALESCE(?, description), " +
            "price = COALESCE(?, price), duration = COALESCE(?, duration), " +
            "create_date = COALESCE(?, create_date), last_update_date = COALESCE(?, last_update_date) " +
            "WHERE id = ?";

    public static final String DELETE_GIFT_CERTIFICATE_QUERY = "DELETE FROM gift_certificates WHERE id = ?";

    public static final String CREATE_TAG_QUERY = "INSERT INTO tags (name) VALUES (?)";

    public static final String FIND_TAG_QUERY = "SELECT * FROM tags WHERE id = ?";

    public static final String FIND_ALL_TAGS_QUERY = "SELECT * FROM tags";

    public static final String UPDATE_TAG_QUERY = "UPDATE tags SET name = COALESCE(?, name) WHERE id = ?";

    public static final String DELETE_TAG_QUERY = "DELETE FROM tags WHERE id = ?";

    public static final String FIND_CERTIFICATE_BY_TAG_NAME = "SELECT * FROM gift_certificates " +
            "INNER JOIN certificate_tag_maps ON certificate_tag_maps.gift_certificate_id = gift_certificates.id " +
            "INNER JOIN tags ON certificate_tag_maps.tag_id = tags.id WHERE tags.name = COALESCE(?, tags.name)";

    public static final String FIND_CERTIFICATES_BY_PART_OF_NAME_AND_DESCRIPTION = "SELECT * " +
            "FROM gift_certificates INNER JOIN certificate_tag_maps " +
            "ON certificate_tag_maps.gift_certificate_id = gift_certificates.id " +
            "INNER JOIN tags ON certificate_tag_maps.tag_id = tags.id " +
            "WHERE gift_certificates.name LIKE COALESCE(?, gift_certificates.name) " +
            "AND gift_certificates.description LIKE COALESCE(?, gift_certificates.description)";

    public static final String FIND_CERTIFICATES_SORTED = "WITH constants (sortParam) " +
            "AS (values (?))\n" +
            " SELECT * FROM constants, gift_certificates " +
            "INNER JOIN certificate_tag_maps ON certificate_tag_maps.gift_certificate_id = gift_certificates.id " +
            "INNER JOIN tags ON certificate_tag_maps.tag_id = tags.id\n" +
            " ORDER BY CASE WHEN sortParam = 'name' THEN gift_certificates.name END,\n" +
            " CASE WHEN sortParam = 'create-date' THEN gift_certificates.create_date END,\n" +
            " CASE ?  WHEN TRUE THEN gift_certificates.create_date END DESC";

    public static final String PERCENT = "%";

    private ConstantQuery() {
    }

}
