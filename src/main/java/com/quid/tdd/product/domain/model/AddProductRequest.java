package com.quid.tdd.product.domain.model;

import com.quid.tdd.product.domain.DiscoundPolicy;

public record AddProductRequest(String name, int price, DiscoundPolicy policy) {
}

