package com.quid.tdd.product.controller.model;

import com.quid.tdd.product.domain.DiscoundPolicy;
import com.quid.tdd.product.domain.Product;

public record AddProductRequest(String name, int price, DiscoundPolicy policy) {

    public Product toProduct() {
        return Product.create(name, price, policy);
    }
}

