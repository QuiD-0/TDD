package com.quid.tdd.product;

import java.util.HashMap;
import java.util.Map;

class ProductRepository {

    private Long seq = 0L;
    private Map<Long, Product> persistance = new HashMap<>();

    public void save(Product product) {
        product.assignId(++seq);
        persistance.put(product.getId(), product);
    }
}
