package com.quid.tdd.product.usecase;

import com.quid.tdd.product.domain.Product;
import com.quid.tdd.product.domain.repository.ProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

public interface ProductFindUseCase {

    Product findByIdOrThrow(Long productId);

    List<Product> findAll();

    @Service
    @RequiredArgsConstructor
    class ProductFindUseCaseImpl implements ProductFindUseCase {

        private final ProductRepository productRepository;

        public Product findByIdOrThrow(Long productId) {
            return productRepository.findByIdOrThrow(productId);
        }

        @Override
        public List<Product> findAll() {
            return productRepository.findAll();
        }
    }
}
