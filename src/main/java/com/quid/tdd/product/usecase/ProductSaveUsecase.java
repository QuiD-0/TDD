package com.quid.tdd.product.usecase;

import com.quid.tdd.product.repository.ProductRepository;
import com.quid.tdd.product.domain.model.AddProductRequest;
import com.quid.tdd.product.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface ProductSaveUsecase {

    @Transactional
    void addProduct(AddProductRequest request);

    @Service
    @RequiredArgsConstructor
    class ProductSaveUsecaseImpl implements ProductSaveUsecase {

        private final ProductRepository productRepository;

        @Override
        @Transactional
        public void addProduct(AddProductRequest request) {
            Product product = new Product(request.name(), request.price(), request.policy());
            productRepository.save(product);
        }
    }

}