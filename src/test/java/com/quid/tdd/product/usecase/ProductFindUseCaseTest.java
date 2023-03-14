package com.quid.tdd.product.usecase;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import com.quid.tdd.product.controller.model.AddProductRequest;
import com.quid.tdd.product.domain.DiscoundPolicy;
import com.quid.tdd.product.domain.Product;
import com.quid.tdd.product.repo.ProductRepository;
import com.quid.tdd.product.usecase.ProductFindUseCase.ProductFindUseCaseImpl;
import com.quid.tdd.product.usecase.ProductCreateUseCase.ProductCreateUseCaseImpl;
import com.quid.tdd.product.usecase.fake.FakeProductRepository;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProductFindUseCaseTest {

    private ProductFindUseCase productFindUseCase;

    @Test
    @DisplayName("상품을 조회한다.")
    void find_product_by_id() {
        final Long productId = 1L;

        Product product = productFindUseCase.findProduct(productId);

        assertThat(product.getName()).isEqualTo("상품명");
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
        List<Product> list = productFindUseCase.findAllProducts();

        assertThat(list.size()).isEqualTo(1);
    }

    @BeforeEach
    void setUp() {
        ProductRepository fakeProductRepository = new FakeProductRepository();
        productFindUseCase = new ProductFindUseCaseImpl(fakeProductRepository);
        ProductCreateUseCase productSaveUseCase = new ProductCreateUseCaseImpl(fakeProductRepository);
        final AddProductRequest request = new AddProductRequest("상품명", 1000L, DiscoundPolicy.NONE, 10);
        productSaveUseCase.addProduct(request);
    }
}
