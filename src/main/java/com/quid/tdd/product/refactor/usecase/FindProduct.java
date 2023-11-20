package com.quid.tdd.product.refactor.usecase;

import com.quid.tdd.product.refactor.domain.Product;
import com.quid.tdd.product.refactor.respository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface FindProduct {
    Product findBy(Long id);
    List<Product> findAll();

    @Service
    @RequiredArgsConstructor
    class FindProductUseCase implements FindProduct{
        private final ProductRepository repository;

        @Override
        public Product findBy(Long id) {
            return repository.findBy(id);
        }

        @Override
        public List<Product> findAll() {
            return repository.findAll();
        }
    }

}
