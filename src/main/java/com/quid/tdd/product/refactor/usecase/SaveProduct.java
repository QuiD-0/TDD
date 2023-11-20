package com.quid.tdd.product.refactor.usecase;

import com.quid.tdd.product.refactor.domain.Product;
import com.quid.tdd.product.refactor.respository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

public interface SaveProduct {

    Product save(Product product);

    @Service
    @RequiredArgsConstructor
    class SaveProductUseCase implements SaveProduct{
        private final ProductRepository repository;

        @Override
        public Product save(Product product) {
            return repository.save(product);
        }
    }
}
