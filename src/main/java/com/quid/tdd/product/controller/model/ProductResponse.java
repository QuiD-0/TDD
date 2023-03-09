package com.quid.tdd.product.controller.model;

import com.quid.tdd.product.domain.Product;

public record ProductResponse(Long id, String name, int price) {

    public static ProductResponse of(Product product) {
        return new ProductResponse(product.getId(), product.getName(), product.getPrice());
    }
}
