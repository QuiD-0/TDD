package com.quid.tdd.order.domain;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

import com.quid.tdd.product.domain.Product;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "orders")
@NoArgsConstructor(access = PROTECTED)
public class Order {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @OneToOne(fetch = LAZY)
    private Product product;
    private String ordererName;
    private Integer quantity;
    private Long totalPrice;

    private Order(Product product, String ordererName, Integer quantity) {
        this.product = product;
        this.ordererName = ordererName;
        this.quantity = quantity;
        this.totalPrice = Math.round(product.getDiscountPrice() * quantity);
    }

    public static Order of(Product product, String ordererName, Integer quantity) {
        return new Order(product, ordererName, quantity);
    }

}