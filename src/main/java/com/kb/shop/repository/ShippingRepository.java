package com.kb.shop.repository;

import com.kb.shop.domain.Seller;
import com.kb.shop.domain.ShippingInfo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class ShippingRepository {

    private final JdbcTemplate jdbcTemplate;

    public ShippingRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public ShippingInfo selectShippingInfo(Long id) {
        String sql = "SELECT * FROM seller WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, BeanPropertyRowMapper.newInstance(ShippingInfo.class));
    }

    public void setShippingInfo(ShippingInfo shippingInfo) {
        String sql = "INSERT INTO shippingInfo (shipping_id, order_id, orderItem_id, shippingStatus) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, shippingInfo.getId(), shippingInfo.getOrder(), shippingInfo.getOrderItem(), shippingInfo.getShippingStatus());
    }
}
