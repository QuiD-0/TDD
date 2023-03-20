package com.quid.tdd.payment.domain;

import com.quid.tdd.order.domain.Order;

public class PaymentValidator {

    public static void validate(Card card, Order order) {
        if (card == null) {
            throw new IllegalArgumentException("card and order must not be null");
        }
        if (order == null) {
            throw new IllegalArgumentException("order must not be null");
        }
    }

}
