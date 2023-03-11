package com.quid.tdd.payment.controller.model;

import com.quid.tdd.order.domain.Order;
import com.quid.tdd.payment.domain.Card;
import com.quid.tdd.payment.domain.Payment;
import org.springframework.util.Assert;

public record PaymentCreateRequest(Long orderId, Card card) {

    public PaymentCreateRequest {
        Assert.notNull(orderId, "orderId must not be null");
        Assert.notNull(card, "card must not be null");
    }

    public Payment toPayment(Order order) {
        return Payment.of(card, order);
    }
}