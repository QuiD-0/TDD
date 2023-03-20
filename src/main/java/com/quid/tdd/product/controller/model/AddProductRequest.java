package com.quid.tdd.product.controller.model;

import com.quid.tdd.product.domain.DiscoundPolicy;
import com.quid.tdd.product.domain.Product;

public record AddProductRequest(String name, Long price, DiscoundPolicy policy, int quantity) {

    public AddProductRequest {
        if (name == null) {
            throw new IllegalArgumentException("name must not be null");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("quantity must not be null");
        }
        if (policy == null) {
            throw new IllegalArgumentException("policy must not be null");
        }
        if (price < 0) {
            throw new IllegalArgumentException("price must not be null");
        }
    }

    public Product toProduct() {
        return Product.create(name, price, policy, quantity);
    }
}

