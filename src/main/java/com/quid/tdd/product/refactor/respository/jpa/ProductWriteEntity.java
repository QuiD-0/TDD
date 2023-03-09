package com.quid.tdd.product.refactor.respository.jpa;

import com.quid.tdd.product.domain.DiscoundPolicy;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "products")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductWriteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int price;
    private DiscoundPolicy policy;

    public ProductWriteEntity(String name, int price, DiscoundPolicy policy) {
        this.name = name;
        this.price = price;
        this.policy = policy;
    }

    public void update(String name, int price) {
        this.name = name;
        this.price = price;
    }
}