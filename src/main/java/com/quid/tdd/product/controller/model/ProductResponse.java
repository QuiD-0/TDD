package com.quid.tdd.product.controller.model;

import com.quid.tdd.product.domain.Product;
import java.util.List;

public record ProductResponse(Long id, String name, int price) {


    public static ProductResponse of(Product product) {
        return new ProductResponse(product.getId(), product.getName(), product.getPrice());
    }

    public static List<ProductResponse> listOf(List<Product> products) {
        return products.stream().map(ProductResponse::of).toList();
    }
}
