package com.quid.tdd.order.controller.model;

import com.quid.tdd.order.domain.Order;

public record OrderResponse(Long id, String productName, String ordererName, Integer quantity,
                            Long totalPrice) {

    public static OrderResponse of(Order order) {
        return new OrderResponse(order.getId(), order.getProduct().getName(),
            order.getOrdererName(), order.getQuantity(), order.getTotalPrice());
    }
}
