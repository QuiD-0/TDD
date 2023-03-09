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
            Product product = productRepository.findByIdOrThrow(productId);
            return ProductResponse.of(product);
        }

        @Override
        @Transactional(readOnly = true)
        public List<ProductResponse> findAllProducts() {
            List<Product> products = productRepository.findAll();
            return ProductResponse.listOf(products);
        }
    }
}
