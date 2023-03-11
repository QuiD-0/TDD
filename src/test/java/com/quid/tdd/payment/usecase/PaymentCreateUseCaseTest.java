package com.quid.tdd.payment.usecase;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PaymentCreateUseCaseTest {

    private PaymentCreateUseCase paymentCreateUseCase;

    @BeforeEach
    void setUp() {
        paymentCreateUseCase = new PaymentCreateUseCaseImpl();
    }

    @Test
    @DisplayName("결제를 생성한다.")
    void createPayment() {
        PaymentCreateRequest request = new PaymentCreateRequest(1L, Card.of("quid", "1234-1234-1234-1234", "123", "12/12"));

        Payment payment = paymentCreateUseCase.createPayment(request);
        assertThat(payment.getCard().owner()).isEqualTo(1L);
    }

}
