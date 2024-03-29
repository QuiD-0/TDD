package com.quid.tdd.payment.domain;

import static com.quid.tdd.payment.domain.PaymentValidator.validate;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import com.quid.tdd.order.domain.Order;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    @Column(columnDefinition = "BINARY(16)")
    private UUID payTransactionId;

    private Payment(Card card, Order order, UUID payTransactionId) {
        validate(card, order);
        this.card = card;
        this.order = order;
        this.payTransactionId = payTransactionId;
    }

    public static Payment of(Card card, Order order, UUID payTransactionId) {
        return new Payment(card, order, payTransactionId);
    }

    public String getProductName() {
        return order.getProduct().getName();
    }
}