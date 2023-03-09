package com.quid.tdd.product.fake;

import com.quid.tdd.product.controller.model.UpdateProductRequest;
import com.quid.tdd.product.domain.Product;
import com.quid.tdd.product.domain.repository.ProductRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FakeProductRepository implements ProductRepository {

    private final Map<Long, Product> persistence = new HashMap<>();

    @Override
    public Product save(Product product) {
        persistence.put(1L, product);
        return product;
    }

    @Override
    public Product findByIdOrThrow(Long productId) {
        Product product = persistence.get(productId);
        if (product == null) {
            throw new IllegalArgumentException("Product not found");
        }
        return product;
    }

    @Override
    public List<Product> findAll() {
        return List.copyOf(persistence.values());
    }

    @Override
    public Product updateProduct(UpdateProductRequest request) {
        Product product = persistence.get(request.id());
        product.update(request.name(), request.price());
        persistence.put(1L, product);
        return product;
    }
}