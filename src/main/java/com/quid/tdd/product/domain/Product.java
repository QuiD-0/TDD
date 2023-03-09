package com.quid.tdd.product.domain;

import javax.persistence.Entity;
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
    private int price;
    private DiscoundPolicy policy;

    private Product(String name, int price, DiscoundPolicy policy) {
        this.name = name;
        this.price = price;
        this.policy = policy;
    }

    public static Product create(String name, int price, DiscoundPolicy policy) {
        return new Product(name, price, policy);
    }

    public void update(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
