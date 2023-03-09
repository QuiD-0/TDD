package com.quid.tdd.product.usecase;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import com.quid.tdd.product.controller.model.AddProductRequest;
import com.quid.tdd.product.controller.model.UpdateProductRequest;
import com.quid.tdd.product.domain.DiscoundPolicy;
import com.quid.tdd.product.domain.Product;
import com.quid.tdd.product.domain.repository.ProductRepository;
import com.quid.tdd.product.usecase.ProductFindUseCase.ProductFindUseCaseImpl;
import com.quid.tdd.product.usecase.ProductSaveUseCase.ProductSaveUseCaseImpl;
import com.quid.tdd.product.usecase.ProductUpdateUseCase.ProductUpdateUseCaseImpl;
import com.quid.tdd.product.usecase.fake.FakeProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProductUpdateUseCaseTest {

    private ProductUpdateUseCase productUpdateUseCase;
    private ProductFindUseCase productFindUseCase;

    @BeforeEach
    void setUp() {
        ProductRepository fakeProductRepository = new FakeProductRepository();
        ProductSaveUseCase productSaveUseCase = new ProductSaveUseCaseImpl(fakeProductRepository);
        productUpdateUseCase = new ProductUpdateUseCaseImpl(fakeProductRepository);
        productFindUseCase = new ProductFindUseCaseImpl(fakeProductRepository);
        final AddProductRequest request = new AddProductRequest("상품명", 1000, DiscoundPolicy.NONE);
        productSaveUseCase.addProduct(request);
    }

    @Test
    @DisplayName("상품을 수정한다.")
    void update_product() {
        final Long productId = 1L;
        final UpdateProductRequest request = new UpdateProductRequest(1L , "업데이트된 상품명", 2000);

        productUpdateUseCase.updateProduct(request);

        Product product = productFindUseCase.findByIdOrThrow(productId);
        assertThat(product.getName()).isEqualTo("업데이트된 상품명");
        assertThat(product.getPrice()).isEqualTo(2000);
    }

    @Test
    @DisplayName("상품을 수정할 때, 상품명이 없으면 예외를 발생시킨다.")
    void update_product_with_no_name() {
        final UpdateProductRequest request = new UpdateProductRequest(1L , null, 2000);

        assertThatCode(() -> productUpdateUseCase.updateProduct(request))
            .isInstanceOf(IllegalArgumentException.class);
    }

}