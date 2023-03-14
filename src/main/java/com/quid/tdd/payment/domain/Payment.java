package com.quid.tdd.payment.domain;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import com.quid.tdd.order.domain.Order;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Embedded
    private Card card;
    @OneToOne(fetch = LAZY)
    private Order order;

    private Payment(Card card, Order order) {
        Assert.notNull(card, "card must not be null");
        Assert.notNull(order, "order must not be null");
        this.card = card;
        this.order = order;
    }

    public static Payment of(Card card, Order order) {
        return new Payment(card, order);
    }

    public String getProductName() {
        return order.getProduct().getName();
    }
}