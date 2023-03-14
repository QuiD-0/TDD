package com.quid.tdd.order.usecase;

import static com.quid.tdd.product.usecase.ProductCreateUseCase.ProductCreateUseCaseImpl;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.quid.tdd.order.controller.model.OrderCreateRequest;
import com.quid.tdd.order.domain.Order;
import com.quid.tdd.order.repo.OrderRepository;
import com.quid.tdd.order.usecase.OrderCreateUseCase.OrderCreateUseCaseImpl;
import com.quid.tdd.order.usecase.fake.FakeOrderRepository;
import com.quid.tdd.product.controller.model.AddProductRequest;
import com.quid.tdd.product.domain.DiscoundPolicy;
import com.quid.tdd.product.repo.ProductRepository;
import com.quid.tdd.product.usecase.ProductCreateUseCase;
import com.quid.tdd.product.usecase.fake.FakeProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderCreateUseCaseTest {

    private OrderCreateUseCase orderCreateUseCase;

    @Test
    void createOrder() {
        final OrderCreateRequest request = new OrderCreateRequest(1L, 1, "quid");
        Order order = orderCreateUseCase.createOrder(request);

        assertThat(order.getOrdererName()).isEqualTo(request.ordererName());
    }

    @Test
    void totalPriceTest() {
        final OrderCreateRequest request = new OrderCreateRequest(1L, 1, "quid");
        Order order = orderCreateUseCase.createOrder(request);
        assertThat(order.getTotalPrice()).isEqualTo(950);
    }


    @BeforeEach
    void setUp() {
        OrderRepository fakeOrderRepository = new FakeOrderRepository();
        ProductRepository fakeProductRepository = new FakeProductRepository();
        ProductCreateUseCase productSaveUseCase = new ProductCreateUseCaseImpl(fakeProductRepository);
        productSaveUseCase.addProduct(
            new AddProductRequest("quid", 1000L, DiscoundPolicy.FIVE_PERCENT, 10));
        orderCreateUseCase = new OrderCreateUseCaseImpl(fakeOrderRepository, fakeProductRepository);
    }
}
