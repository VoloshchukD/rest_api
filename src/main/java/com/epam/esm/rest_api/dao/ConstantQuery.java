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

    private ConstantQuery() {
    }

}
