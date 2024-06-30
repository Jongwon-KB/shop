package com.kb.shop.domain;

import com.kb.shop.domain.enums.ShippingStatus;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ShippingInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Order id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    // OrderItem id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderItem_id", nullable = false)
    private OrderItem orderItem;

    // shippingStatus
    @Enumerated(EnumType.STRING)
    private ShippingStatus shippingStatus;
}
