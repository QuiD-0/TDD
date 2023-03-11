package com.quid.tdd.payment.usecase;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.quid.tdd.order.controller.model.OrderCreateRequest;
import com.quid.tdd.order.repo.OrderRepository;
import com.quid.tdd.order.usecase.OrderCreateUseCase;
import com.quid.tdd.order.usecase.OrderCreateUseCase.OrderCreateUseCaseImpl;
import com.quid.tdd.order.usecase.fake.FakeOrderRepository;
import com.quid.tdd.payment.controller.model.PaymentCreateRequest;
import com.quid.tdd.payment.domain.Card;
import com.quid.tdd.payment.domain.Payment;
import com.quid.tdd.payment.repository.PaymentRepository;
import com.quid.tdd.payment.usecase.PaymentCreateUseCase.PaymentCreateUseCaseImpl;
import com.quid.tdd.payment.usecase.fake.FakePaymentRepository;
import com.quid.tdd.product.controller.model.AddProductRequest;
import com.quid.tdd.product.domain.DiscoundPolicy;
import com.quid.tdd.product.repo.ProductRepository;
import com.quid.tdd.product.usecase.ProductCreateUseCase;
import com.quid.tdd.product.usecase.ProductCreateUseCase.ProductCreateUseCaseImpl;
import com.quid.tdd.product.usecase.fake.FakeProductRepository;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PaymentCreateUseCaseTest {

    private PaymentCreateUseCase paymentCreateUseCase;

    @Test
    @DisplayName("결제를 생성한다.")
    void createPayment() {
        PaymentCreateRequest request = new PaymentCreateRequest(1L,
            Card.of("quid", "1234-1234-1234-1234", 123, LocalDate.now().plusDays(10)));

        Payment payment = paymentCreateUseCase.createPayment(request);
        assertThat(payment.getCard().owner()).isEqualTo("quid");
    }

    @BeforeEach
    void setUp() {
        PaymentRepository paymentRepository = new FakePaymentRepository();
        OrderRepository orderRepository = new FakeOrderRepository();
        ProductRepository productRepository = new FakeProductRepository();
        ProductCreateUseCase productSaveUseCase = new ProductCreateUseCaseImpl(productRepository);
        OrderCreateUseCase orderSaveUseCase = new OrderCreateUseCaseImpl(orderRepository, productRepository);
        OrderCreateRequest request = new OrderCreateRequest(1L, 10, "quid");
        AddProductRequest productRequest = new AddProductRequest("coffee", 10000L, DiscoundPolicy.NONE, 1000);
        productSaveUseCase.addProduct(productRequest);
        orderSaveUseCase.createOrder(request);
        paymentCreateUseCase = new PaymentCreateUseCaseImpl(paymentRepository, orderRepository);
    }
}
