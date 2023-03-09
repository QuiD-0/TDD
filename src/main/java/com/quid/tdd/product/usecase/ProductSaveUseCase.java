package com.quid.tdd.product.usecase;

import static com.quid.tdd.product.domain.ProductValidator.*;

import com.quid.tdd.product.controller.model.AddProductRequest;
import com.quid.tdd.product.domain.Product;
import com.quid.tdd.product.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface ProductSaveUseCase {

    Product addProduct(AddProductRequest request);

    @Service
    @RequiredArgsConstructor
    class ProductSaveUseCaseImpl implements ProductSaveUseCase {

        private final ProductRepository productRepository;

        @Override
        @Transactional
        public Product addProduct(AddProductRequest request) {
            Product product = validate(request.toProduct());
            return productRepository.save(product);
        }
    }

}