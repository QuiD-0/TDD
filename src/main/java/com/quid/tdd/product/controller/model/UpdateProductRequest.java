package com.quid.tdd.product.controller.model;

public record UpdateProductRequest(Long id, String name, Long price) {

    public UpdateProductRequest {
        if (name == null) {
            throw new IllegalArgumentException("name must not be null");
        }
        if (price < 0) {
            throw new IllegalArgumentException("price must not be null");
        }
    }
}
