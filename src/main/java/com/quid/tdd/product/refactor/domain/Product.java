package com.quid.tdd.product.refactor.domain;

import com.quid.tdd.product.domain.DiscoundPolicy;

import java.math.BigDecimal;

public record Product(
        Long id,
        String name,
        BigDecimal price,
        DiscoundPolicy policy
) {

    public Product {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name must not be blank");
        }
        if (price == null || price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("price must be greater than 0");
        }
    }
}
