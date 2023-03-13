package com.quid.tdd.payment.controller.model;

import com.quid.tdd.payment.domain.Payment;

public record PaymentResponse(Long id, String orderer, String productName) {

    public static PaymentResponse of(Payment payment) {
        return new PaymentResponse(payment.getId(), payment.getOrder().getOrdererName(), payment.getProductName());
    }
}
