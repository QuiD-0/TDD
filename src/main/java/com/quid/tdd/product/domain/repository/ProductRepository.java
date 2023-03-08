package com.quid.tdd.product.domain.repository;

import com.quid.tdd.product.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

public interface ProductRepository {

    Product save(Product product);

    Product findByIdOrThrow(Long productId);

    @Repository
    @RequiredArgsConstructor
    class ProductRepositoryImpl implements ProductRepository {

        private final ProductJpaRepository productJpaRepository;

        @Override
        public Product save(Product product) {
            return productJpaRepository.save(product);
        }

        @Override
        public Product findByIdOrThrow(Long productId) {
            return productJpaRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
        }
    }
}
