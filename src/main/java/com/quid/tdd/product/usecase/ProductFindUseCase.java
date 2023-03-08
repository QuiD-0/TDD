package com.quid.tdd.product.usecase;

import com.quid.tdd.product.domain.Product;
import com.quid.tdd.product.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

public interface ProductFindUseCase {

    Product findProductById(Long productId);

    @Service
    @RequiredArgsConstructor
    class ProductFindUseCaseImpl implements ProductFindUseCase {

        private final ProductRepository productRepository;

        public Product findProductById(Long productId) {
            return productRepository.findByIdOrThrow(productId);
        }
    }
}
