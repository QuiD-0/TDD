package com.quid.tdd.product.usecase;

import com.quid.tdd.product.controller.model.ProductResponse;
import com.quid.tdd.product.domain.Product;
import com.quid.tdd.product.repo.ProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface ProductFindUseCase {

    Product findProduct(Long productId);

    List<Product> findAllProducts();

    @Service
    @RequiredArgsConstructor
    class ProductFindUseCaseImpl implements ProductFindUseCase {

        private final ProductRepository productRepository;

        @Override
        @Transactional(readOnly = true)
        public Product findProduct(Long productId) {
            Product product = productRepository.findById(productId);
            return product;
        }

        @Override
        @Transactional(readOnly = true)
        public List<Product> findAllProducts() {
            return productRepository.findAll();
        }
    }
}
