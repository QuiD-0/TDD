package com.quid.tdd.order.controller.model;

import com.quid.tdd.order.domain.Order;
import com.quid.tdd.product.domain.Product;

public record OrderCreateRequest(Long productId, Integer quantity, String ordererName) {

    public OrderCreateRequest {
        if(productId == null) {
            throw new IllegalArgumentException("productId must not be null");
        }
        if(quantity == null) {
            throw new IllegalArgumentException("quantity must not be null");
        }
        if(ordererName == null) {
            throw new IllegalArgumentException("ordererName must not be null");
        }
    }

    public Order toOrder(Product product) {
        return Order.of(product, ordererName, quantity);
    }
}
