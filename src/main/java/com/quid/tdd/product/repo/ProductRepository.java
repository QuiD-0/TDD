package com.quid.tdd.product.repo;

import com.quid.tdd.product.controller.model.UpdateProductRequest;
import com.quid.tdd.product.domain.Product;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

public interface ProductRepository {

    Product save(Product product);

    Product findById(Long productId);

    List<Product> findAll();

    void updateProduct(UpdateProductRequest request);

    @Repository
    @RequiredArgsConstructor
    class ProductRepositoryImpl implements ProductRepository {

        private final ProductJpaRepository productJpaRepository;

        @Override
        public Product save(Product product) {
            return productJpaRepository.save(product);
        }

        @Override
        public Product findById(Long productId) {
            return productJpaRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
        }

        @Override
        public List<Product> findAll() {
            return productJpaRepository.findAll();
        }

        @Override
        public void updateProduct(UpdateProductRequest request) {
            Product product = productJpaRepository.findById(request.id())
                .orElseThrow(IllegalArgumentException::new);

            product.update(request.name(), request.price());
            productJpaRepository.save(product);
        }
    }
}
