package com.quid.tdd.payment.gateway.model;

import com.quid.tdd.payment.controller.model.CardInfo;
import java.util.UUID;


public record PayRequest(String userName, CardInfo card, Long totalAmount, UUID transactionId) {

    public PayRequest {
        if (userName == null) {
            throw new IllegalArgumentException("userName must not be null");
        }
        if (card == null) {
            throw new IllegalArgumentException("card must not be null");
        }
        if (totalAmount == null) {
            throw new IllegalArgumentException("totalAmount must not be null");
        }
    }

    public static PayRequest of(String userName, CardInfo card, Long totalPrice) {
        return new PayRequest(userName, card, totalPrice, UUID.randomUUID());
    }
}