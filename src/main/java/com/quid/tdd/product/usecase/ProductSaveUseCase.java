package com.quid.tdd.product.usecase;

import com.quid.tdd.product.controller.model.AddProductRequest;
import com.quid.tdd.product.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface ProductSaveUseCase {

    void addProduct(AddProductRequest request);

    @Service
    @RequiredArgsConstructor
    class ProductSaveUseCaseImpl implements ProductSaveUseCase {

        private final ProductRepository productRepository;

        @Override
        @Transactional
        public void addProduct(AddProductRequest request) {
            productRepository.save(request.toProduct());
        }
    }

}