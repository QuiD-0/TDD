package com.quid.tdd.payment.controller.model;

import com.quid.tdd.order.domain.Order;
import com.quid.tdd.payment.domain.Payment;
import org.springframework.util.Assert;

public record CreatePaymentRequest(Long orderId, CardInfo cardInfo) {

    public CreatePaymentRequest {
        Assert.notNull(orderId, "orderId must not be null");
        Assert.notNull(cardInfo, "card must not be null");
    }

    public Payment toPayment(Order order) {
        return Payment.of(cardInfo.toCard(), order);
    }
}