package com.quid.tdd.payment.controller.model;

import com.quid.tdd.order.domain.Order;
import com.quid.tdd.payment.domain.Payment;

public record CreatePaymentRequest(Long orderId, CardInfo cardInfo) {

    public CreatePaymentRequest {
        if (orderId == null) {
            throw new IllegalArgumentException("orderId must not be null");
        }
        if (cardInfo == null) {
            throw new IllegalArgumentException("cardInfo must not be null");
        }
    }

    public Payment toPayment(Order order, Long payTransactionId) {
        return Payment.of(cardInfo.toCard(), order, payTransactionId);
    }
}