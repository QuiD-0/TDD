package com.quid.tdd.payment.controller.model;

import com.quid.tdd.payment.domain.Card;
import java.time.LocalDate;

public record CardInfo(String owner, String number, Integer cvc, LocalDate expiredDate) {

    public CardInfo {
        if (owner == null) {
            throw new IllegalArgumentException("owner must not be null");
        }
        if (number == null) {
            throw new IllegalArgumentException("number must not be null");
        }
        if (cvc <= 100 || cvc >= 999) {
            throw new IllegalArgumentException("cvc must be 3 digits");
        }
        if (expiredDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("expiredDate must be after today");
        }
    }

    public static CardInfo of(String quid, String number, int cvc, LocalDate expiredDate) {
        return new CardInfo(quid, number, cvc, expiredDate);
    }

    public Card toCard() {
        return Card.of(owner, number, cvc, expiredDate);
    }

}
