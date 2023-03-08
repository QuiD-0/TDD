package com.quid.tdd.product.domain.repository;

import com.quid.tdd.product.domain.Product;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

public interface ProductRepository {

    void save(Product product);

    @Repository
    @RequiredArgsConstructor
    class ProductRepositoryImpl implements ProductRepository {

        private final ProductJpaRepository productJpaRepository;

        @Override
        public void save(Product product) {
            productJpaRepository.save(product);
        }
    }
}
