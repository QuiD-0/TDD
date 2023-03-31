package com.quid.tdd.payment.gateway.model;

import com.quid.tdd.payment.domain.Card;
import java.util.UUID;


public record PayRequest(Long userId, Card card, Long totalAmount, UUID transactionId) {

    public PayRequest {
        if (userId == null) {
            throw new IllegalArgumentException("userId must not be null");
        }
        if (card == null) {
            throw new IllegalArgumentException("card must not be null");
        }
        if (totalAmount == null) {
            throw new IllegalArgumentException("totalAmount must not be null");
        }
    }

    public static PayRequest of(Long userId, Card card, Long totalAmount) {
        return new PayRequest(userId, card, totalAmount, UUID.randomUUID());
    }
}