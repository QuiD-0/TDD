package com.quid.tdd.order.usecase;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.quid.tdd.order.controller.model.OrderCreateRequest;
import com.quid.tdd.order.domain.Order;
import com.quid.tdd.order.repo.OrderRepository;
import com.quid.tdd.order.usecase.OrderCreateUseCase.OrderCreateUseCaseImpl;
import com.quid.tdd.order.usecase.OrderFindUseCase.OrderFindUseCaseImpl;
import com.quid.tdd.order.usecase.fake.FakeOrderRepository;
import com.quid.tdd.product.controller.model.AddProductRequest;
import com.quid.tdd.product.domain.DiscoundPolicy;
import com.quid.tdd.product.repo.ProductRepository;
import com.quid.tdd.product.usecase.ProductSaveUseCase;
import com.quid.tdd.product.usecase.ProductSaveUseCase.ProductSaveUseCaseImpl;
import com.quid.tdd.product.usecase.fake.FakeProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderFindUseCaseTest {
    private OrderFindUseCase orderFindUseCase;

    @BeforeEach
    void setUp() {
        OrderRepository fakeOrderRepository = new FakeOrderRepository();
        ProductRepository fakeProductRepository = new FakeProductRepository();
        ProductSaveUseCase productSaveUseCase = new ProductSaveUseCaseImpl(fakeProductRepository);
        productSaveUseCase.addProduct(new AddProductRequest("quid", 1000L, DiscoundPolicy.FIVE_PERCENT, 10));
        OrderCreateUseCase orderCreateUseCase = new OrderCreateUseCaseImpl(fakeOrderRepository, fakeProductRepository);
        orderCreateUseCase.createOrder(new OrderCreateRequest(1L, 1, "quid"));
        orderFindUseCase = new OrderFindUseCaseImpl(fakeOrderRepository);
    }

    @Test
    void findOrder() {
        Order order = orderFindUseCase.findOrder(1L);

        assertThat(order.getOrdererName()).isEqualTo("quid");
    }

}
