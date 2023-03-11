package com.quid.tdd.order.usecase;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

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
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderFindUseCaseTest {
    private OrderFindUseCase orderFindUseCase;

    @BeforeEach
    void setUp() {
        OrderRepository fakeOrderRepository = new FakeOrderRepository();
        ProductRepository fakeProductRepository = new FakeProductRepository();
        ProductSaveUseCase productSaveUseCase = new ProductSaveUseCaseImpl(fakeProductRepository);
        OrderCreateUseCase orderCreateUseCase = new OrderCreateUseCaseImpl(fakeOrderRepository, fakeProductRepository);
        orderFindUseCase = new OrderFindUseCaseImpl(fakeOrderRepository);
        productSaveUseCase.addProduct(new AddProductRequest("quid", 1000L, DiscoundPolicy.FIVE_PERCENT, 10));
        orderCreateUseCase.createOrder(new OrderCreateRequest(1L, 1, "quid"));
    }

    @Test
    @DisplayName("주문을 찾는다.")
    void findOrder() {
        Order order = orderFindUseCase.findOrder(1L);

        assertThat(order.getOrdererName()).isEqualTo("quid");
    }

    @Test
    @DisplayName("없는 주문을 찾으면 예외를 던진다.")
    void findOrderWithWrongId() {
        assertThatCode(() -> orderFindUseCase.findOrder(2L))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("주문자의 모든 주문내역을 찾는다.")
    void findOrdersByOrdererName() {
        List<Order> order = orderFindUseCase.findOrder("quid");

        assertThat(order.size()).isEqualTo(1);
    }

}
