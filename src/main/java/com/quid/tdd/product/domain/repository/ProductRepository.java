package com.quid.tdd.product.domain.repository;

import com.quid.tdd.product.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

public interface ProductRepository {

    Product save(Product product);

    @Repository
    @RequiredArgsConstructor
    class ProductRepositoryImpl implements ProductRepository {

        private final ProductJpaRepository productJpaRepository;

        @Override
        public Product save(Product product) {
            return productJpaRepository.save(product);
        }
    }
}
