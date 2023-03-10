package com.quid.tdd.product.domain;

import static javax.persistence.EnumType.STRING;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "products")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long price;
    private Integer quantity;
    @Enumerated(STRING)
    private DiscoundPolicy policy;

    private Product(String name, Long price, DiscoundPolicy policy, int quantity) {
        this.name = name;
        this.price = price;
        this.policy = policy;
        this.quantity = quantity;
    }

    public static Product create(String name, Long price, DiscoundPolicy policy, int quantity) {
        return new Product(name, price, policy, quantity);
    }

    public void update(String name, Long price) {
        this.name = name;
        this.price = price;
    }

    public void reduceQuantity(Integer quantity) {
        if (this.quantity < quantity) {
            throw new IllegalArgumentException("Not enough quantity");
        }
        this.quantity -= quantity;
    }

    public Double getDiscountPrice() {
        return this.price * this.policy.getDiscountRate();
    }
}
