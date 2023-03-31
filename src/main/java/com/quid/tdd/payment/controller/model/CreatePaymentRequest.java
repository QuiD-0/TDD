package com.quid.tdd.payment.controller.model;

import com.quid.tdd.order.domain.Order;
import com.quid.tdd.payment.domain.Payment;
import com.quid.tdd.payment.gateway.model.PayRequest;
import java.util.UUID;

public record CreatePaymentRequest(Long orderId, CardInfo cardInfo) {

    public CreatePaymentRequest {
        if (orderId == null) {
            throw new IllegalArgumentException("orderId must not be null");
        }
        if (cardInfo == null) {
            throw new IllegalArgumentException("cardInfo must not be null");
        }
    }

    public Payment toPayment(Order order, UUID payTransactionId) {
        return Payment.of(cardInfo.toCard(), order, payTransactionId);
    }

    public PayRequest toPayRequest(Order order) {
        return PayRequest.of(order.getOrdererName(), cardInfo.toCard(), order.getTotalPrice());
    }
}