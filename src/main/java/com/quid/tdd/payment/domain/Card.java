package com.quid.tdd.payment.domain;

import java.time.LocalDate;
import org.springframework.util.Assert;

public record Card(String owner, String number, Integer cvc, LocalDate expiredDate) {

    public Card {
        Assert.notNull(owner, "owner must not be null");
        Assert.notNull(number, "number must not be null");
        Assert.notNull(cvc, "cvc must not be null");
        if (expiredDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("expiredDate must be after today");
        }
    }

    public static Card of(String owner, String number, Integer cvc, LocalDate expiredDate) {
        return new Card(owner, number, cvc, expiredDate);
    }
}