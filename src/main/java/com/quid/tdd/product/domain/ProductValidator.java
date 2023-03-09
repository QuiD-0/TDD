package com.quid.tdd.product.domain;

import org.springframework.util.Assert;

public class ProductValidator {
    public static Product validate(Product product) {
        Assert.hasText(product.getName(), "name must not be empty");
        Assert.isTrue(product.getPrice() >= 0, "price must be greater than 0");
        Assert.notNull(product.getPolicy(), "policy must not be null");
        return product;
    }
}
