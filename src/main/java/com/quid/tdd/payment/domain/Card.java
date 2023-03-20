package com.quid.tdd.payment.domain;

import java.time.LocalDate;

public class Card {

    private final String owner;
    private final String number;
    private final Integer cvc;
    private final LocalDate expiredDate;

    private Card(String owner, String number, Integer cvc, LocalDate expiredDate) {
        this.owner = owner;
        this.number = number;
        this.cvc = cvc;
        this.expiredDate = expiredDate;
    }

    public static Card of(String owner, String number, Integer cvc, LocalDate expiredDate) {
        return new Card(owner, number, cvc, expiredDate);
    }

    public String owner() {
        return owner;
    }
}