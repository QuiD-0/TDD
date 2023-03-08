package com.quid.tdd.product.controller.model;

import com.quid.tdd.product.domain.DiscoundPolicy;
import com.quid.tdd.product.domain.Product;
import com.quid.tdd.product.domain.ProductValidator;

public record AddProductRequest(String name, int price, DiscoundPolicy policy) {

    public Product toProduct() {
        return ProductValidator.validate(Product.create(name, price, policy));
    }
}

