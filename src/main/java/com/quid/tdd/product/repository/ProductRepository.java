package com.quid.tdd.product.repository;

import com.quid.tdd.product.domain.Product;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

public interface ProductRepository {

    void save(Product product);

    @Repository
    class ProductRepositoryImpl implements ProductRepository {

        private Long seq = 0L;
        private Map<Long, Product> persistance = new HashMap<>();

        @Override
        public void save(Product product) {
            product.assignId(++seq);
            persistance.put(product.getId(), product);
        }
    }
}
