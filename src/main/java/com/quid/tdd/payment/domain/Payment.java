package com.quid.tdd.payment.domain;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import com.quid.tdd.order.domain.Order;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Embedded
    private Card card;
    @OneToOne(fetch = LAZY)
    private Order order;

    private Payment(Card card, Order order) {
        this.card = card;
        this.order = order;
    }

    public static Payment of(Card card, Order order) {
        return new Payment(card, order);
    }
}