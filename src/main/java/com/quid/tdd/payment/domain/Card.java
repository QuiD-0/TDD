package com.quid.tdd.payment.domain;

import java.time.LocalDate;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Card {

    private String owner;
    private String number;
    private Integer cvc;
    private LocalDate expiredDate;

    public Card(String owner, String number, Integer cvc, LocalDate expiredDate) {
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