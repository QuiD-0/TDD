package com.quid.tdd.product.refactor.respository;

import com.quid.tdd.product.refactor.domain.Product;
import com.quid.tdd.product.refactor.respository.jpa.ProductReadEntity;
import com.quid.tdd.product.refactor.respository.jpa.ProductReadRepository;
import com.quid.tdd.product.refactor.respository.jpa.ProductWriteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

public interface ProductRepository {

    Product findBy(Long id);

    List<Product> findAll();

    @Repository
    @RequiredArgsConstructor
    class ProductRdbmsRepository implements ProductRepository{
        private final ProductReadRepository read;
        private final ProductWriteRepository write;

        @Override
        @Transactional(readOnly = true)
        public Product findBy(Long id) {
            return read.findById(id)
                    .map(ProductReadEntity::toDomain)
                    .orElseThrow(() -> new RuntimeException("Product not found"));
        }

        @Override
        @Transactional(readOnly = true)
        public List<Product> findAll() {
            return read.findAll().stream()
                    .map(ProductReadEntity::toDomain)
                    .toList();
        }
    }
}
