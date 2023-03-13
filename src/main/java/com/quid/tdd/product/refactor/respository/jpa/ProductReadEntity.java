package com.quid.tdd.product.refactor.respository.jpa;

import com.quid.tdd.product.domain.DiscoundPolicy;
import com.quid.tdd.product.refactor.domain.Product;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Entity
@Immutable
@Table(name = "products")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductReadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int price;
    private DiscoundPolicy policy;

    public ProductReadEntity(String name, int price, DiscoundPolicy policy) {
        this.name = name;
        this.price = price;
        this.policy = policy;
    }

    public void update(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Product toDomain() {
        return new Product(id, name, BigDecimal.valueOf(price),policy);
    }
}
