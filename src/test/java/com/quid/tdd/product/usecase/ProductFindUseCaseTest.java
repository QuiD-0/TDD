package com.quid.tdd.product.usecase;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import com.quid.tdd.product.controller.model.AddProductRequest;
import com.quid.tdd.product.controller.model.ProductResponse;
import com.quid.tdd.product.domain.DiscoundPolicy;
import com.quid.tdd.product.domain.repository.ProductRepository;
import com.quid.tdd.product.usecase.ProductFindUseCase.ProductFindUseCaseImpl;
import com.quid.tdd.product.usecase.ProductSaveUseCase.ProductSaveUseCaseImpl;
import com.quid.tdd.product.fake.FakeProductRepository;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProductFindUseCaseTest {

    private ProductFindUseCase productFindUseCase;

    @BeforeEach
    void setUp() {
        ProductRepository fakeProductRepository = new FakeProductRepository();
        productFindUseCase = new ProductFindUseCaseImpl(fakeProductRepository);
        ProductSaveUseCase productSaveUseCase = new ProductSaveUseCaseImpl(fakeProductRepository);
        final AddProductRequest request = new AddProductRequest("상품명", 1000, DiscoundPolicy.NONE);
        productSaveUseCase.addProduct(request);
    }

    @Test
    @DisplayName("상품을 조회한다.")
    void find_product_by_id() {
        final Long productId = 1L;

        ProductResponse product = productFindUseCase.findProduct(productId);

        assertThat(product.name()).isEqualTo("상품명");
    }

    @Test
    @DisplayName("상품을 조회할 때 상품이 없으면 예외를 발생시킨다.")
    void find_product_by_id_when_product_is_not_exist() {
        final Long productId = 2L;

        assertThatCode(() -> productFindUseCase.findProduct(productId)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @Test
    @DisplayName("상품의 리스트를 조회한다.")
    void find_product_list() {
        List<ProductResponse> list = productFindUseCase.findAllProducts();

        assertThat(list.size()).isEqualTo(1);
    }
}
