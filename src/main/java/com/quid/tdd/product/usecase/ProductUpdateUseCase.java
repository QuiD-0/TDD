package com.quid.tdd.product.usecase;

import static com.quid.tdd.product.domain.ProductValidator.validate;

import com.quid.tdd.product.controller.model.UpdateProductRequest;
import com.quid.tdd.product.domain.Product;
import com.quid.tdd.product.repo.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface ProductUpdateUseCase {

    void updateProduct(UpdateProductRequest request);

    @Service
    @RequiredArgsConstructor
    class ProductUpdateUseCaseImpl implements ProductUpdateUseCase {

        private final ProductRepository productRepository;

        @Override
        @Transactional
        public void updateProduct(UpdateProductRequest request) {
            Product product = productRepository.updateProduct(request);
            validate(product);
        }

    }
}
