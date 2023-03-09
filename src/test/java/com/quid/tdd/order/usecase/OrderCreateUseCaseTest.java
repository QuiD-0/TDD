package com.quid.tdd.order.usecase;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderCreateUseCaseTest {

    private OrderCreateUseCase orderCreateUseCase;

    @BeforeEach
    void setUp() {
        OrderRepository fakeOrderRepository = new FakeOrderRepository();
        orderCreateUseCase = new OrderCreateUseCaseImpl();
    }

    @Test
    void createOrder() {
        final OrderCreateRequest request = new OrderCreateRequest();
        Order order = orderCreateUseCase.createOrder(request.toOrder());

        assertThat(order.getProduct()).isEqualTo(request.getProduct());
    }

}
