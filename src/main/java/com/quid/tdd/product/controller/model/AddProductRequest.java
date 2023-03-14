package com.quid.tdd.product.controller.model;

import com.quid.tdd.product.domain.DiscoundPolicy;
import com.quid.tdd.product.domain.Product;

public record AddProductRequest(String name, Long price, DiscoundPolicy policy, int quantity) {

    public Product toProduct() {
        return Product.create(name, price, policy, quantity);
    }
}

