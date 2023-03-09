package com.quid.tdd.product.usecase;

import com.quid.tdd.product.controller.model.ProductResponse;
import com.quid.tdd.product.domain.Product;
import com.quid.tdd.product.domain.repository.ProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface ProductFindUseCase {

    ProductResponse findProduct(Long productId);

    List<ProductResponse> findAllProducts();

    @Service
    @RequiredArgsConstructor
    class ProductFindUseCaseImpl implements ProductFindUseCase {

        private final ProductRepository productRepository;

        @Override
        @Transactional(readOnly = true)
        public ProductResponse findProduct(Long productId) {
            return ProductResponse.of(productRepository.findByIdOrThrow(productId));
        }

        @Override
        @Transactional(readOnly = true)
        public List<ProductResponse> findAllProducts() {
            return productRepository.findAll().stream().map(ProductResponse::of).toList();
        }
    }
}
