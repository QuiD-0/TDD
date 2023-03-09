package com.quid.tdd.product.usecase;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import com.quid.tdd.product.controller.model.AddProductRequest;
import com.quid.tdd.product.domain.DiscoundPolicy;
import com.quid.tdd.product.domain.Product;
import com.quid.tdd.product.domain.repository.ProductRepository;
import com.quid.tdd.product.fake.FakeProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProductSaveUseCaseTest {

    private ProductSaveUseCase productService;

    @BeforeEach
    void setUp() {
        ProductRepository fakeProductRepository = new FakeProductRepository();
        productService = new ProductSaveUseCase.ProductSaveUseCaseImpl(fakeProductRepository);
    }

    @Test
    @DisplayName("상품을 추가한다.")
    void add_product() {
        final AddProductRequest request = new AddProductRequest("상품명", 1000, DiscoundPolicy.NONE);

        Product product = productService.addProduct(request);

        assertThat(product.getName()).isEqualTo("상품명");
    }

    @Test
    @DisplayName("상품 가격이 0원 이하일 경우 예외를 발생시킨다.")
    void add_product_when_price_is_smaller_than_0() {
        final AddProductRequest request = new AddProductRequest("상품명", 0, DiscoundPolicy.NONE);

        assertThatCode(() -> productService.addProduct(request)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("상품명이 null일 경우 예외를 발생시킨다.")
    void add_prodcut_when_name_is_null() {
        final AddProductRequest request = new AddProductRequest(null, 1000, DiscoundPolicy.NONE);

        assertThatCode(() -> productService.addProduct(request)).isInstanceOf(IllegalArgumentException.class);
    }
}