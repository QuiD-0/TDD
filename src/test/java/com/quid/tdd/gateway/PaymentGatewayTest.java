package com.quid.tdd.gateway;

import com.quid.tdd.payment.domain.Card;
import com.quid.tdd.payment.gateway.model.PayRequest;
import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PaymentGatewayTest {

    @BeforeAll
    public void setUp() {
        Card card_fixture = Card.of("owner", "1234-1234-1234-1234", 123, LocalDate.now());
        payRequestFixture = PayRequest.of(1L, card_fixture, 1000L);
    }

    private PayRequest payRequestFixture;

    @Test
    public void test() {
        PaymentGateway paymentGateway = new PaymentGateway();
        Assertions.assertDoesNotThrow(() -> paymentGateway.requestPayment(payRequestFixture));
    }
}
