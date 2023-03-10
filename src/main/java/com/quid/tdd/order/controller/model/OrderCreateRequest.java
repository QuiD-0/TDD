package com.quid.tdd.order.controller.model;

import com.quid.tdd.order.domain.Order;
import com.quid.tdd.product.domain.Product;

public record OrderCreateRequest(Long productId, Integer quantity, String ordererName) {

    public Order toOrder(Product product) {
        return Order.of(product, ordererName, quantity);
    }
}
