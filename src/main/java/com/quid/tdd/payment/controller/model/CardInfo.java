package com.quid.tdd.payment.controller.model;

import com.quid.tdd.payment.domain.Card;
import java.time.LocalDate;
import org.springframework.util.Assert;

public record CardInfo(String owner, String number, Integer cvc, LocalDate expiredDate) {

    public CardInfo {
        Assert.hasText(owner, "owner must not be null");
        Assert.hasText(number, "number must not be null");
        Assert.isTrue(cvc >= 100 && cvc <= 999, "cvc must be 3 digits");
        Assert.isTrue(expiredDate.isAfter(LocalDate.now()), "expiredDate must be after today");
    }

    public static CardInfo of(String quid, String number, int cvc, LocalDate plusDays) {
        return new CardInfo(quid, number, cvc, plusDays);
    }

    public Card toCard() {
        return Card.of(owner, number, cvc, expiredDate);
    }

}
