package com.quid.tdd.product.domain.repository;

import com.quid.tdd.product.controller.model.UpdateProductRequest;
import com.quid.tdd.product.domain.Product;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

public interface ProductRepository {

    Product save(Product product);

    Product findByIdOrThrow(Long productId);

    List<Product> findAll();

    void updateProduct(Product product, UpdateProductRequest request);

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

        @Override
        public List<Product> findAll() {
            return productJpaRepository.findAll();
        }

        @Override
        public void updateProduct(Product product, UpdateProductRequest request) {
            product.update(request.name(), request.price());
            productJpaRepository.save(product);
        }
    }
}
