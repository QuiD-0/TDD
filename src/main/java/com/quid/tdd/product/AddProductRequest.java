package com.quid.tdd.product;

public record AddProductRequest(String name, int price, DiscoundPolicy policy) {
}

